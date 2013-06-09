/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.testwarehouse.shumenko.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import ua.testwarehouse.shumenko.model.dao.IncomingDocumentDAO;
import ua.testwarehouse.shumenko.model.dao.ShipperDAO;
import ua.testwarehouse.shumenko.model.dao.WarehouseDAO;
import ua.testwarehouse.shumenko.model.entity.IncomingDocument;
import ua.testwarehouse.shumenko.model.entity.Shipper;
import ua.testwarehouse.shumenko.model.entity.Warehouse;

/**
 *
 * @author Michael Shumenko
 */
public class ViewIncomingDocumentController extends AbstractController {

    private static final String ERROR_VIEW_NAME = "error";
    private static final String WAREHOUSE_MODEL_NAME = "warehouse";
    private static final String SHIPPER_MODEL_NAME = "shipper";
    private static final String INCOMING_MODEL_NAME = "incoming";
    private static final String INCOMING_DOCUMENT_VIEW_NAME = "incoming";
    private static final String PARAMETER_DATE = "date";
    private static final String PARAMETER_SHIPPER = "shipper";
    private static final String PARAMETER_WAREHOUSE = "warehouse";
    private ShipperDAO shipper;
    private WarehouseDAO warehouse;
    private IncomingDocumentDAO incomingDocument;

    public ViewIncomingDocumentController() {
    }

    @Override
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView result = null;
        try {
            ModelAndView mv = new ModelAndView(INCOMING_DOCUMENT_VIEW_NAME);
            List<Shipper> allShipper = shipper.getAllShipper();
            List<Warehouse> allWarehouse = warehouse.getAllWarehouse();
            mv.addObject(WAREHOUSE_MODEL_NAME, allWarehouse);
            mv.addObject(SHIPPER_MODEL_NAME, allShipper);

            String selectedDate = request.getParameter(PARAMETER_DATE);
            String selectedShipper = request.getParameter(PARAMETER_SHIPPER);
            String selectedWarehouse = request.getParameter(PARAMETER_WAREHOUSE);

            Date date1 = null;
            Date date2 = null;
            if (selectedDate != null) {
                try {
                    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    date1 = formatter.parse(selectedDate);
                    date2 = formatter.parse(selectedDate);
                } catch (Exception e) {
                }
            }
            List<IncomingDocument> infoToIncomingDocument = incomingDocument.getInfoToIncomingDocument(
                    date1, date2, selectedShipper, selectedWarehouse);
            mv.addObject(INCOMING_MODEL_NAME, infoToIncomingDocument);
            result = mv;
        } catch (Exception ex) {

        }
        return result;
    }

    public void setShipper(ShipperDAO shipper) {
        this.shipper = shipper;
    }

    public void setWarehouse(WarehouseDAO warehouse) {
        this.warehouse = warehouse;
    }

    public void setIncomingDocument(IncomingDocumentDAO incomingDocument) {
        this.incomingDocument = incomingDocument;
    }
}