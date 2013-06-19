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
import ua.testwarehouse.shumenko.model.dao.ProductDAO;
import ua.testwarehouse.shumenko.model.dao.ShipperDAO;
import ua.testwarehouse.shumenko.model.dao.WarehouseDAO;
import ua.testwarehouse.shumenko.model.entity.IncomingDocument;
import ua.testwarehouse.shumenko.model.entity.Product;
import ua.testwarehouse.shumenko.model.entity.Shipper;
import ua.testwarehouse.shumenko.model.entity.Warehouse;

/**
 *
 * @author miha
 */
public class ViewShipperPageController extends AbstractController {

    private static final String SHIPPER_PAGE_VIEW_NAME = "shipper";
    private static final String SHIPPER_SUCCESS_PAGE_VIEW_NAME = "shipperSuccess";
    private static final String WAREHOUSE_MODEL_NAME = "warehouse";
    private static final String SHIPPER_MODEL_NAME = "shipper";
    private static final String ROW_AMOUNT_MODEL_NAME = "rowAmount";
    private static final String PARAMETER_AMOUNT_ROW = "addRow";
    private static final String PARAMETER_DATE = "date";
    private static final String PARAMETER_SHIPPER = "shipper";
    private static final String PARAMETER_WAREHOUSE = "warehouse";
    private static final String PARAMETER_PRODUCT = "product";
    private static final String PARAMETER_PRICE = "price";
    private static final String PARAMETER_AMOUNT = "amount";
    private static final String PARAMETER_AMOUNT_TO_BE_PAID = "amountToBePaid";
    private static final String SERVLET_PATH_ADD_INCOMING = "/addShipperInfo.htm";
    private WarehouseDAO warehouse;
    private ShipperDAO shipper;
    private ProductDAO product;
    private IncomingDocumentDAO incomingDocument;
    private Integer rowAmount = 1;

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

            List<Shipper> allShipper = shipper.getAllShipper();
            List<Warehouse> allWarehouse = warehouse.getAllWarehouse();
            mv.addObject(WAREHOUSE_MODEL_NAME, allWarehouse);
            mv.addObject(SHIPPER_MODEL_NAME, allShipper);

            String parameterRow = request.getParameter(PARAMETER_AMOUNT_ROW);
            if (parameterRow != null) {
                Integer addRow = Integer.parseInt(parameterRow);
                if (addRow > rowAmount) {
                    this.rowAmount = addRow;
                }
            }

//-------------------------------------------------------------------------------------------------------

            String selectedDate = request.getParameter(PARAMETER_DATE);
            String selectedShipper = request.getParameter(PARAMETER_SHIPPER);
            String selectedWarehouse = request.getParameter(PARAMETER_WAREHOUSE);

            Date date = null;
            if (selectedDate != null) {
                try {
                    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    date = formatter.parse(selectedDate);
                } catch (Exception e) {
                }
            }

            if (request.getServletPath().equals(SERVLET_PATH_ADD_INCOMING)) {
                try {
                    for (int i = 1; i <= rowAmount; i++) {
                        if (incomingDocument.checkAvailabilityProductInIncomingForSelectedShipperAndUpdate(date,
                                selectedShipper,
                                selectedWarehouse,
                                request.getParameter(PARAMETER_PRODUCT + i),
                                Double.parseDouble(request.getParameter(PARAMETER_PRICE + i)),
                                Double.parseDouble(request.getParameter(PARAMETER_AMOUNT_TO_BE_PAID + i)),
                                Integer.parseInt(request.getParameter(PARAMETER_AMOUNT + i)))) {
                            mv.setViewName(SHIPPER_SUCCESS_PAGE_VIEW_NAME);
                        } else {
                            incomingDocument.saveIncoming(new IncomingDocument(date, selectedShipper, selectedWarehouse,
                                    request.getParameter(PARAMETER_PRODUCT + i),
                                    Integer.parseInt(request.getParameter(PARAMETER_AMOUNT + i)),
                                    Double.parseDouble(request.getParameter(PARAMETER_PRICE + i)),
                                    Double.parseDouble(request.getParameter(PARAMETER_AMOUNT_TO_BE_PAID + i))));
                            mv.setViewName(SHIPPER_SUCCESS_PAGE_VIEW_NAME);
                        }
                        boolean checkProductAvailability = product.checkProductAvailability(request.getParameter(PARAMETER_PRODUCT + i));
                        if (checkProductAvailability) {
                        } else {
                            product.saveProduct(new Product(request.getParameter(PARAMETER_PRODUCT + i)));
                        }
                    }
                    this.rowAmount = 1;
                } catch (Exception ex) {
                    System.out.println("SQL EXCEPTION");
                }
            }
            mv.addObject(ROW_AMOUNT_MODEL_NAME, rowAmount);
            result = mv;
        } catch (Exception e) {
        }
        return result;
    }

    public void setWarehouse(WarehouseDAO warehouse) {
        this.warehouse = warehouse;
    }

    public void setShipper(ShipperDAO shipper) {
        this.shipper = shipper;
    }

    public void setIncomingDocument(IncomingDocumentDAO incomingDocument) {
        this.incomingDocument = incomingDocument;
    }

    public void setProduct(ProductDAO product) {
        this.product = product;
    }
}