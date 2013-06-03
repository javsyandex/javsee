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
import model.entity.Camera;
import model.entity.Notebook;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import service.cart.Cart;

/**
 *
 * @author miha
 */
public class ViewListProductsFromSelectedCategoryController extends AbstractController {

    public static final String NOTEBOOK_MODEL_NAME = "notebook";
    public static final String CAMERA_MODEL_NAME = "camera";
    public static final String CABLE_MODEL_NAME = "cable";
    public static final String REQUEST_VIEW_NAME="nameView";
    public static final String NOTEBOOK_VIEW_NAME = "notebook";
    public static final String CAMERA_VIEW_NAME = "camera";
    public static final String CABLE_VIEW_NAME = "cable";
    DAOShopFactory factoryDAO = DAOShopFactory.getInstance();
    CartShopFactory factoryCart = CartShopFactory.getCartShopInstance();
    Cart cart = factoryCart.getCartFactory(CartTypes.CARTLIST);
    DAO notebook = factoryDAO.getDAOFactory(DAOTypes.NOTEBOOK);
    DAO camera = factoryDAO.getDAOFactory(DAOTypes.CAMERA);
    DAO cable = factoryDAO.getDAOFactory(DAOTypes.CABLE);

    public ViewListProductsFromSelectedCategoryController() {
    }

    @Override
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView result = null;
        try {

            List<Notebook> listNotebook = notebook.getAll();
            List<Camera> listCamera = camera.getAll();
            List<Cable> listCable = cable.getAll();

            ModelAndView mv = new ModelAndView();
            mv.addObject(CABLE_MODEL_NAME, listCable);
            mv.addObject(CAMERA_MODEL_NAME, listCamera);
            mv.addObject(NOTEBOOK_MODEL_NAME, listNotebook);

            result=mv;
        } catch (Exception ex) {
            result = new ModelAndView("error");
        }

        return result;
    }
}