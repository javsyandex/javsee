/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.daoImpl;

import java.util.List;
import model.dao.CustomerDAO;
import model.entity.Customer;
import model.entity.CustomerOrder;
import model.hbutil.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Michael Shumenko
 */
public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public List getAll() {


        List<Customer> result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction().begin();
            Criteria criteria = session.createCriteria(Customer.class);

            result = (List<Customer>) criteria.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

    @Override
    public void addCustomer(Customer customer) {
         Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction().begin();
            session.save(customer);
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
    public List getItemsByIdCustomer(Integer customerId) {
        List<CustomerOrder> result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction().begin();
            Criteria criteria = session.createCriteria(CustomerOrder.class);
            Criteria customer = criteria.add(Restrictions.eq("idCustomer", customerId ));
            result = (List<CustomerOrder>) customer.list();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

    @Override
    public void addCustomerOrder(CustomerOrder order) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction().begin();
            session.save(order);
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
