/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.spring;

import factory.CartShopFactory;
import factory.CartTypes;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import service.cart.Cart;

/**
 *
 * @author Michael Shumenko
 */
public class OrderController extends AbstractController {

    CartShopFactory factoryCart = CartShopFactory.getCartShopInstance();
    Cart cart = factoryCart.getCartFactory(CartTypes.CARTLIST);

    public OrderController() {
    }

    @Override
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView result;
        try {

            List<String> nameItemList = cart.getAllNameItem();
            List<Integer> priceItemList = cart.getAllPriceItem();
            ModelAndView mv = new ModelAndView("order", "name", nameItemList);
            mv.addObject("price", priceItemList);
            Integer summaryPrice = cart.getSummaryPrice();
            mv.addObject("summaryPrice", summaryPrice);
            result = mv;
        } catch (Exception e) {
            result = new ModelAndView("error");
        }
        return result;
    }
}