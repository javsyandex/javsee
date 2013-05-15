/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.daoImpl;

import factory.DAOTypes;
import java.util.List;
import model.dao.DAO;
import model.entity.Camera;
import model.hbutil.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Michael Shumenko
 */
public class CameraDAOImpl implements DAO {

    @Override
    public List<Camera> getAll() {


        List<Camera> result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction().begin();
            Criteria criteria = session.createCriteria(Camera.class);

            result = (List<Camera>) criteria.list();
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

   
}
