/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.spring;

import factory.CustomerFactory;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.CustomerDAO;
import model.entity.Customer;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author miha
 */
public class CustomersController extends AbstractController {

    CustomerFactory customerDAO = CustomerFactory.getCustomerInstance();
    CustomerDAO factoryCustomer = customerDAO.getCustomerFactory();

    public CustomersController() {
    }

    @Override
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView result;
        try {
            List<Customer> customers = factoryCustomer.getAll();
            
            ModelAndView mv = new ModelAndView("customers","customers",customers);
            result = mv;

        } catch (Exception e) {
            result = new ModelAndView("error");
        }
        return result;
    }
}