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
import model.entity.Cable;
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
public class CableController extends AbstractController {

    
        DAOShopFactory factoryDAO = DAOShopFactory.getInstance();
        DAO daoCategory = factoryDAO.getDAOFactory(DAOTypes.CATEGORY);
        DAO daoCable = factoryDAO.getDAOFactory(DAOTypes.CABLE);
        CartShopFactory factoryCart = CartShopFactory.getCartShopInstance();
        Cart cart = factoryCart.getCartFactory(CartTypes.CARTLIST);
    

public CableController() {
    }

    @Override
        protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView result;
        
        try {
          
            List<Cable> listCable = daoCable.getAll();
            List<Category> listCategory = daoCategory.getAll();
            ModelAndView mv = new ModelAndView("cable", "cable", listCable);
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