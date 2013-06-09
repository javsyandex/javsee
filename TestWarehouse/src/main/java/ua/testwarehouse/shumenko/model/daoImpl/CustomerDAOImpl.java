/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.testwarehouse.shumenko.model.daoImpl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import ua.testwarehouse.shumenko.model.dao.CustomerDAO;
import ua.testwarehouse.shumenko.model.entity.Customer;
import ua.testwarehouse.shumenko.model.entity.WarehouseHibernateUtil;

/**
 *
 * @author Michael Shumenko
 */
public class CustomerDAOImpl implements CustomerDAO {

   
    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> result = null;
        Session session = WarehouseHibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction().begin();
            Criteria criteria = session.createCriteria(Customer.class);

            result = (List<Customer>) criteria.list();
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }
}
