/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import factory.CartShopFactory;
import factory.CartTypes;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.hbutil.HibernateUtil;
import org.hibernate.Session;
import service.cart.Cart;

/**
 *
 * @author miha
 */
@WebServlet(name = "DeleteFromCartServlet", urlPatterns = {"/delete"})
public class DeleteFromCartServlet extends HttpServlet {
    
    public static final String PRICE_ITEM = "priceItem";
    public static final String NAME_ITEM = "nameItem";
    public static final String TARGET = "target";
    CartShopFactory factoryCart = CartShopFactory.getCartShopInstance();
    Cart cart = factoryCart.getCartFactory(CartTypes.CARTLIST);

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
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        session.beginTransaction().begin();
        
        String name = String.valueOf(request.getParameter(NAME_ITEM));
        String url = String.valueOf(request.getParameter(TARGET));
        List<String> listName = cart.getAllNameItem();
        List<Integer> listPrice = cart.getAllPriceItem();
        Integer id = cart.getCurrentId(name);
        Integer price = listPrice.get(id);
        cart.setSummaryPrice(-price);
        
        cart.deleteItemFromCart(name, price);
        
        request.getRequestDispatcher(url).forward(request, response);
        session.getTransaction().commit();
        
        
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
