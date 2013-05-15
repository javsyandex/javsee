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
import model.entity.Book;
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
public class BookController extends AbstractController {

    
        DAOShopFactory factoryDAO = DAOShopFactory.getInstance();
        DAO daoCategory = factoryDAO.getDAOFactory(DAOTypes.CATEGORY);
        DAO daoBook = factoryDAO.getDAOFactory(DAOTypes.BOOK);
        CartShopFactory factoryCart = CartShopFactory.getCartShopInstance();
        Cart cart = factoryCart.getCartFactory(CartTypes.CARTLIST);
   


public BookController() {
    }

    @Override
        protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView result;
       
        try {
            
            List<Book> listBook = daoBook.getAll();
            List<Category> listCategory = daoCategory.getAll();
            ModelAndView mv = new ModelAndView("book", "book", listBook);
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