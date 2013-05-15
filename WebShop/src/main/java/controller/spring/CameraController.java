/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.spring;

import factory.CartShopFactory;
import factory.CartTypes;
import factory.DAOShopFactory;
import factory.DAOTypes;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.DAO;
import model.entity.Camera;
import model.entity.Category;
import model.hbutil.HibernateUtil;
import org.hibernate.Session;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import service.cart.Cart;

/**
 *
 * @author Michael Shumenko
 */
public class CameraController extends AbstractController {

   
        DAOShopFactory factoryDAO = DAOShopFactory.getInstance();
        DAO daoCategory = factoryDAO.getDAOFactory(DAOTypes.CATEGORY);
        DAO daoCamera = factoryDAO.getDAOFactory(DAOTypes.CAMERA);
        CartShopFactory factoryCart = CartShopFactory.getCartShopInstance();
        Cart cart = factoryCart.getCartFactory(CartTypes.CARTLIST);
    

public CameraController() {
    }

    @Override
        protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView result;
        
        try {
           
            List<Camera> listCamera = daoCamera.getAll();
            List<Category> listCategory = daoCategory.getAll();
            ModelAndView mv = new ModelAndView("camera", "camera", listCamera);
            mv.addObject("category", listCategory);
            mv.addObject("lastItem",cart.getLastItemFromCart());
            mv.addObject("summaryPrice",cart.getSummaryPrice());
            result = mv;
            
        } catch (Exception e) {
            result = new ModelAndView("error");
        }
        return result;

    }
}