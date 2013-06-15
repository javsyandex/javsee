/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.testwarehouse.shumenko.model.daoImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import ua.testwarehouse.shumenko.model.dao.ExpenseDocumentDAO;
import ua.testwarehouse.shumenko.model.entity.ExpenseDocument;
import ua.testwarehouse.shumenko.model.entity.WarehouseHibernateUtil;

/**
 *
 * @author Michael Shumenko
 */
public class ExpenseDocumentDAOImpl implements ExpenseDocumentDAO {

    private static final String DELIVERY_DATE_COLUMN = "deliveryDate";
    private static final String CUSTOMER_COLUMN = "customer";
    private static final String WAREHOUSE_COLUMN = "warehouse";
    private static final String PRODUCT_COLUMN = "product";

    @Override
    public List<ExpenseDocument> getInfoToExpenseDocument(Date fromDeliveryDate, Date byDeliveryDate,
            String customer, String warehouse) {
        ArrayList<ExpenseDocument> result = null;
        Session session = WarehouseHibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction().begin();
            Criteria criteria = session.createCriteria(ExpenseDocument.class);
            Criteria expenseDocument = null;

            if (!customer.equals("")) {
                expenseDocument = criteria.add(Restrictions.eq(CUSTOMER_COLUMN, customer));
            } 

            if (!warehouse.equals("")) {
                 expenseDocument = criteria.add(Restrictions.eq(WAREHOUSE_COLUMN, warehouse));
            } 
            if (fromDeliveryDate != null) {
                expenseDocument = criteria.add(Restrictions.between(DELIVERY_DATE_COLUMN,
                        fromDeliveryDate, byDeliveryDate));
            }
           
            result = (ArrayList<ExpenseDocument>)expenseDocument.list();
        } catch (Exception e) {
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

    @Override
    public List<ExpenseDocument> getInfoToRemainderDocument(Date deliveryDate, String warehouse, String product) {
        ArrayList<ExpenseDocument> result = null;
        Session session = WarehouseHibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction().begin();
            Criteria criteria = session.createCriteria(ExpenseDocument.class);
            Criteria remainderDocument = criteria.add(Restrictions.eq(DELIVERY_DATE_COLUMN, deliveryDate)).
                    add(Restrictions.eq(WAREHOUSE_COLUMN, warehouse)).add(Restrictions.eq(PRODUCT_COLUMN, product));
            result = (ArrayList<ExpenseDocument>) remainderDocument.list();

        } catch (Exception e) {
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }
    
    @Override
    public void saveExpense(ExpenseDocument exdoc) {
        Session session = WarehouseHibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction().begin();
            session.save(exdoc);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
