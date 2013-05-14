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
import model.entity.Category;
import model.hbutil.HibernateUtil;
import org.hibernate.Session;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import service.cart.Cart;

/**
 *
 * @author miha
 */
public class CategoryController extends AbstractController {

    
        DAOShopFactory factoryDAO = DAOShopFactory.getInstance();
        DAO dao = factoryDAO.getDAOFactory(DAOTypes.CATEGORY);
        CartShopFactory factoryCart = CartShopFactory.getCartShopInstance();
        Cart cart = factoryCart.getCartFactory(CartTypes.CARTLIST);
        Category prod = new Category();

public CategoryController() {
    }

    @Override
        protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView result;
       
        try {
            
            String amount = prod.viewAmountProduct();
            List  listDAO = dao.getAll();
            ModelAndView mv = new ModelAndView("hello", "category", listDAO);
            mv.addObject("lastItem", cart.getLastItemFromCart());
            mv.addObject("summaryPrice", cart.getSummaryPrice());            
            result = mv;
            
        } catch (Exception e) {
            result = new ModelAndView("error");
        }
        return result;

    }
}