/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.testwarehouse.shumenko.model.daoImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import ua.testwarehouse.shumenko.model.dao.IncomingDocumentDAO;
import ua.testwarehouse.shumenko.model.entity.IncomingDocument;
import ua.testwarehouse.shumenko.model.entity.WarehouseHibernateUtil;

/**
 *
 * @author Michael Shumenko
 */
public class IncomingDocumentDAOImpl implements IncomingDocumentDAO {

    private static final String DELIVERY_DATE_COLUMN = "deliveryDate";
    private static final String SHIPPER_COLUMN = "shipper";
    private static final String WAREHOUSE_COLUMN = "warehouse";
    private static final String PRODUCT_COLUMN = "product";
    private static final String PRICE_COLUMN = "price";

    @Override
    public List<IncomingDocument> getInfoToIncomingDocument(Date fromDeliveryDate,
            Date byDeliveryDate, String shipper, String warehouse) {
        ArrayList<IncomingDocument> result = null;
        Session session = WarehouseHibernateUtil.getSessionFactory().openSession();
        Criteria incomingDocument = null;
        try {
            session.beginTransaction().begin();
            Criteria criteria = session.createCriteria(IncomingDocument.class);
//            Criteria incomingDocument = criteria.add(Restrictions.between(DELIVERY_DATE_COLUMN, fromDeliveryDate, byDeliveryDate)).
//                    add(Restrictions.eq(WAREHOUSE_COLUMN, warehouse)).add(Restrictions.eq(SHIPPER_COLUMN, shipper));
            if (!shipper.equals("")) {
                incomingDocument = criteria.add(Restrictions.eq(SHIPPER_COLUMN, shipper));
            }

            if (!warehouse.equals("")) {
                incomingDocument = criteria.add(Restrictions.eq(WAREHOUSE_COLUMN, warehouse));
            }
            if (fromDeliveryDate != null) {
                incomingDocument = criteria.add(Restrictions.between(DELIVERY_DATE_COLUMN,
                        fromDeliveryDate, byDeliveryDate));
            }
            result = (ArrayList<IncomingDocument>) incomingDocument.list();

        } catch (Exception e) {
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

    @Override
    public List<IncomingDocument> getInfoToRemainderDocument(Date deliveryDate, String warehouse, String product) {
        ArrayList<IncomingDocument> result = null;
        Session session = WarehouseHibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction().begin();
            Criteria criteria = session.createCriteria(IncomingDocument.class);
            Criteria remainderDocument = criteria.add(Restrictions.eq(DELIVERY_DATE_COLUMN, deliveryDate)).
                    add(Restrictions.eq(WAREHOUSE_COLUMN, warehouse)).add(Restrictions.eq(PRODUCT_COLUMN, product));
            result = (ArrayList<IncomingDocument>) remainderDocument.list();

        } catch (Exception e) {
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

    @Override
    public void saveIncoming(IncomingDocument incdoc) {
        Session session = WarehouseHibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction().begin();
            session.save(incdoc);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public boolean checkAvailabilityProductInIncomingForSelectedShipperAndUpdate(Date date, String shipper, String warehouse,
            String product, Double price, Double amountToBePaid, Integer amount) {
        Session session = WarehouseHibernateUtil.getSessionFactory().openSession();
        boolean result = false;
        try {
            session.beginTransaction().begin();
            Criteria criteria = session.createCriteria(IncomingDocument.class);
            Criteria incomingDocument = criteria.add(Restrictions.eq(DELIVERY_DATE_COLUMN, date)).
                    add(Restrictions.eq(WAREHOUSE_COLUMN, warehouse)).add(Restrictions.eq(SHIPPER_COLUMN, shipper)).
                    add(Restrictions.eq(PRODUCT_COLUMN, product)).add(Restrictions.eq(PRICE_COLUMN, price));
            ArrayList<IncomingDocument> list = (ArrayList<IncomingDocument>) incomingDocument.list();
            if (list.size() > 0) {
                result = true;
                for (IncomingDocument incdoc : list) {
                    Integer id = incdoc.getId();
                    updateIncoming(amountToBePaid, amount, id);
                }

            }
           session.getTransaction().commit(); 
        } catch (Exception e) {
        }
        return result;
    }

    @Override
    public void updateIncoming(Double amountToBePaid, Integer amount, Integer id) {
        Session session = WarehouseHibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction().begin();
            IncomingDocument ic = (IncomingDocument) session.load(IncomingDocument.class, id);
            ic.setAmount(ic.getAmount() + amount);
            ic.setAmountToBePaid(amountToBePaid + ic.getAmountToBePaid());
            session.flush();  
            session.getTransaction().commit();
        } catch (Exception e) {
        }
    }

    @Override
    public boolean checkAvailabilityProductInIncomingFromAllShipper(Date date, String warehouse, String product, Double price) {
        Session session = WarehouseHibernateUtil.getSessionFactory().openSession();
        boolean result = false;
        try {
            session.beginTransaction().begin();
            Criteria criteria = session.createCriteria(IncomingDocument.class);
            Criteria incomingDocument = criteria.add(Restrictions.eq(DELIVERY_DATE_COLUMN, date)).
                    add(Restrictions.eq(WAREHOUSE_COLUMN, warehouse)).add(Restrictions.eq(PRODUCT_COLUMN, product)).
                    add(Restrictions.eq(PRICE_COLUMN, price));
            ArrayList<IncomingDocument> list = (ArrayList<IncomingDocument>) incomingDocument.list();
            if (list.size() > 0) {
                result = true;
            }
           session.getTransaction().commit(); 
        } catch (Exception e) {
        }
        return result;
    }
}
