/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import model.dao.DAO;
import model.daoImpl.BookDAOImpl;
import model.daoImpl.CableDAOImpl;
import model.daoImpl.CameraDAOImpl;
import model.daoImpl.CategoryDAOImpl;
import model.daoImpl.NotebookDAOImpl;

/**
 *
 * @author miha
 */
public class DAOShopFactory {

    private static DAOShopFactory INSTANCE;

    public static DAOShopFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DAOShopFactory();
        }
        return INSTANCE;
    }

    private DAOShopFactory() {
    }

    public DAO getDAOFactory(DAOTypes daoType) {
        DAO result = null;
        switch (daoType) {
            case BOOK:
                result = new BookDAOImpl();
                break;

            case NOTEBOOK:
                result = new NotebookDAOImpl();
                break;

            case CABLE:
                result = new CableDAOImpl();
                break;

            case CAMERA:
                result = new CameraDAOImpl();
                break;

            case CATEGORY:
                result = new CategoryDAOImpl();
                break;

        }


        return result;
    }
}
