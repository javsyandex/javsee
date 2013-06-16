/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.testwarehouse.shumenko.model.daoImpl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import ua.testwarehouse.shumenko.model.dao.ProductDAO;
import ua.testwarehouse.shumenko.model.entity.Product;
import ua.testwarehouse.shumenko.model.entity.WarehouseHibernateUtil;

/**
 *
 * @author miha
 */
public class ProductDAOImpl implements ProductDAO {
    
    private static final String PRODUCT_COLUMN_NAME = "product";

    @Override
    public List<Product> getAllProduct() {
        List<Product> result = null;
        Session session = WarehouseHibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction().begin();
            Criteria criteria = session.createCriteria(Product.class);

            result = (List<Product>) criteria.list();
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

    @Override
    public boolean checkProductAvailability(String product) {
        Session session = WarehouseHibernateUtil.getSessionFactory().openSession();
        boolean result = false;
        try {
            session.beginTransaction().begin();
            Criteria criteria = session.createCriteria(Product.class);
            Criteria products = criteria.add(Restrictions.eq(PRODUCT_COLUMN_NAME, product));
            ArrayList<Product> list = (ArrayList<Product>) products.list();
            if(list.size()>0){
                result = true;
            }
            
        }catch(Exception e){
            
        }
        return result;
    }

    @Override
    public void saveProduct(Product product) {
        Session session = WarehouseHibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction().begin();
            session.save(product);
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
