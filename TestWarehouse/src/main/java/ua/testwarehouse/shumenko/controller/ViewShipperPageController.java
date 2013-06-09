/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.testwarehouse.shumenko.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author miha
 */
public class ViewShipperPageController extends AbstractController {

    private static final String SHIPPER_PAGE_VIEW_NAME = "shipper";
    
    public ViewShipperPageController() {
    }

    @Override
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView result = null;
        try {
            ModelAndView mv = new ModelAndView();
            mv.setViewName(SHIPPER_PAGE_VIEW_NAME);
            result = mv;
        } catch (Exception e) {
        }
        return result;
    }
}