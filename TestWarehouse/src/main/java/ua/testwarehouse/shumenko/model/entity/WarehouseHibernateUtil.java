package ua.testwarehouse.shumenko.model.entity;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Michael Shumenko
 */
public class WarehouseHibernateUtil {

    private static final SessionFactory sessionFactory;
    
  static {
        try {

          AnnotationConfiguration ac = new AnnotationConfiguration(); 
          ac.addAnnotatedClass(IncomingDocument.class).addAnnotatedClass(Shipper.class).
                  addAnnotatedClass(Warehouse.class).addAnnotatedClass(ExpenseDocument.class).
                  addAnnotatedClass(Customer.class).addAnnotatedClass(Product.class);        

          sessionFactory = ac.configure().buildSessionFactory();
        } catch (Throwable ex) {         
           // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex); 
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
