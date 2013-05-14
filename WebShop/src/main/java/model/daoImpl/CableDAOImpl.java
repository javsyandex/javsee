/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.daoImpl;

import factory.DAOTypes;
import java.util.List;
import model.dao.DAO;
import model.entity.Cable;
import model.hbutil.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author miha
 */
public class CableDAOImpl implements DAO {

    @Override
    public List<Cable> getAll() {


        List<Cable> result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction().begin();
            Criteria criteria = session.createCriteria(Cable.class);

            result = (List<Cable>) criteria.list();
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
