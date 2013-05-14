/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import factory.CartShopFactory;
import factory.CartTypes;
import factory.CustomerFactory;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.CustomerDAO;
import model.entity.Customer;
import model.entity.CustomerOrder;
import service.cart.Cart;

/**
 *
 * @author miha
 */
@WebServlet(name = "AddCustomerServlet", urlPatterns = {"/AddCustomerServlet"})
public class AddCustomerServlet extends HttpServlet {

    public final static String URL = "target";
    public static final String EMEIL = "customerEmailAdress";
    public static final String NAME = "customerName";
    public static final String CREDIT_CART = "customerCreditCart";
    CartShopFactory factoryCart = CartShopFactory.getCartShopInstance();
    Cart cart = factoryCart.getCartFactory(CartTypes.CARTLIST);
    CustomerFactory factoryCustomer = CustomerFactory.getCustomerInstance();
    CustomerDAO customerDAO = factoryCustomer.getCustomerFactory();

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {

            Integer cartNumber = Integer.parseInt(request.getParameter(CREDIT_CART));
            String nameCustomer = (String) request.getParameter(NAME);
            Integer sumPrice = cart.getSummaryPrice();
            String emeil = (String) request.getParameter(EMEIL);
            String url = request.getParameter(URL);

            Customer customer = new Customer(nameCustomer, emeil, cartNumber, sumPrice);

            customerDAO.addCustomer(customer);

            Integer idCustomer = customer.getCustomerId();
           
            List nameItem = cart.getAllNameItem();
            List priceItem = cart.getAllPriceItem();

            Integer n = nameItem.size();
            
            for (int i = 0; i < n; i++) {
                String name=(String) nameItem.get(i);
                Integer price=(Integer) priceItem.get(i);
                customerDAO.addCustomerOrder(new CustomerOrder(idCustomer, name, price));
            }

            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
