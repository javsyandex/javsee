/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.spring;

import factory.CartShopFactory;
import factory.CartTypes;
import factory.CustomerFactory;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.CustomerDAO;
import model.entity.CustomerOrder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import service.cart.Cart;

/**
 *
 * @author Michael Shumenko
 */
public class EndController extends AbstractController {

    CartShopFactory factoryCart = CartShopFactory.getCartShopInstance();
    Cart cart = factoryCart.getCartFactory(CartTypes.CARTLIST);
    CustomerFactory factoryCustomer = CustomerFactory.getCustomerInstance();
    CustomerDAO order = factoryCustomer.getCustomerFactory();
    private static final String NO_ITEM="Вы еще не добавили ни одной вещи";
    private static final String URL="helloPage.htm";
    public EndController() {
    }

    @Override
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        try {            
            cart.setSummaryPrice(0);
            cart.setLastItemFromCart(NO_ITEM);
            cart.deleteAll();
            
            request.getRequestDispatcher(URL).forward(request, response);
        } catch (Exception e) {
        }
        return null;
    }
}