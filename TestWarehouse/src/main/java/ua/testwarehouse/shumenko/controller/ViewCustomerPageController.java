/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.testwarehouse.shumenko.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import ua.testwarehouse.shumenko.service.ProductError;
import ua.testwarehouse.shumenko.model.dao.CustomerDAO;
import ua.testwarehouse.shumenko.model.dao.ExpenseDocumentDAO;
import ua.testwarehouse.shumenko.model.dao.IncomingDocumentDAO;
import ua.testwarehouse.shumenko.model.dao.ProductDAO;
import ua.testwarehouse.shumenko.model.dao.WarehouseDAO;
import ua.testwarehouse.shumenko.model.entity.Customer;
import ua.testwarehouse.shumenko.model.entity.ExpenseDocument;
import ua.testwarehouse.shumenko.model.entity.Product;
import ua.testwarehouse.shumenko.model.entity.Warehouse;

/**
 *
 * @author miha
 */
public class ViewCustomerPageController extends AbstractController {

    private final static String CUSTOMER_PAGE_VIEW_NAME = "customer";
    private final static String CUSTOMER_ERROR_PAGE_VIEW_NAME = "customerError";
    private final static String CUSTOMER_SUCCESS_PAGE_VIEW_NAME = "customerSuccess";
    private static final String WAREHOUSE_MODEL_NAME = "warehouse";
    private static final String CUSTOMER_MODEL_NAME = "customer";
    private static final String ROW_AMOUNT_MODEL_NAME = "rowAmount";
    private static final String PARAMETER_AMOUNT_ROW = "addRow";
    private static final String PARAMETER_DATE = "date";
    private static final String PARAMETER_CUSTOMER = "customer";
    private static final String PARAMETER_WAREHOUSE = "warehouse";
    private static final String PARAMETER_PRODUCT = "product";
    private static final String PARAMETER_PRICE = "price";
    private static final String PARAMETER_AMOUNT = "amount";
    private static final String PARAMETER_AMOUNT_TO_BE_PAID = "amountToBePaid";
    private static final String SERVLET_PATH_ADD_EXPENSE = "/addCustomerInfo.htm";
    private static final String ERR_MSG_NOT_AVAILABLE_PRODUCT = "productError";
    private static final String ERR_MSG_WAREHOUSE = "warehouseError";
    private static final String ERR_MSG_DATE = "dateError";
    
    private WarehouseDAO warehouse;
    private CustomerDAO customer;
    private ProductDAO product;
    private ExpenseDocumentDAO expenseDocument;
    private IncomingDocumentDAO incomingDocument;
    private Integer rowAmount = 1;
    private boolean statusErrorPage = false;
    private List<ProductError> prodErr = new ArrayList();

    public ViewCustomerPageController() {
    }

    @Override
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView result = null;
        try {
            prodErr.removeAll(prodErr);
            statusErrorPage = false;
            ModelAndView mv = new ModelAndView();
            mv.setViewName(CUSTOMER_PAGE_VIEW_NAME);
            

            List<Customer> allCustomer = customer.getAllCustomer();
            List<Warehouse> allWarehouse = warehouse.getAllWarehouse();
            mv.addObject(WAREHOUSE_MODEL_NAME, allWarehouse);
            mv.addObject(CUSTOMER_MODEL_NAME, allCustomer);

            String parameterRow = request.getParameter(PARAMETER_AMOUNT_ROW);
            if (parameterRow != null) {
                Integer addRow = Integer.parseInt(parameterRow);
                if (addRow > rowAmount) {
                    this.rowAmount = addRow;
                }
            }

//-------------------------------------------------------------------------------------------------------

            String selectedDate = request.getParameter(PARAMETER_DATE);
            String selectedCustomer = request.getParameter(PARAMETER_CUSTOMER);
            String selectedWarehouse = request.getParameter(PARAMETER_WAREHOUSE);

            Date date = null;
            if (selectedDate != null) {
                try {
                    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    date = formatter.parse(selectedDate);
                } catch (Exception e) {
                }
            }

            if (request.getServletPath().equals(SERVLET_PATH_ADD_EXPENSE)) {
                try {
                    for (int i = 1; i <= rowAmount; i++) {
                        boolean checkProductAvailability = incomingDocument.checkAvailabilityProductInIncomingFromAllShipper(date,
                                selectedWarehouse,
                                request.getParameter(PARAMETER_PRODUCT + i),
                                Double.parseDouble(request.getParameter(PARAMETER_PRICE + i)));
                        if (checkProductAvailability) {
                            if (expenseDocument.checkAvailabilityProductInExpenseAndUpdate(date,
                                    selectedCustomer,
                                    selectedWarehouse,
                                    request.getParameter(PARAMETER_PRODUCT + i),
                                    Double.parseDouble(request.getParameter(PARAMETER_PRICE + i)),
                                    Double.parseDouble(request.getParameter(PARAMETER_AMOUNT_TO_BE_PAID + i)),
                                    Integer.parseInt(request.getParameter(PARAMETER_AMOUNT + i)))) {
                                if (statusErrorPage) {
                                } else {
                                    mv.setViewName(CUSTOMER_SUCCESS_PAGE_VIEW_NAME);
                                }
                            } else {
                                expenseDocument.saveExpense(new ExpenseDocument(date, selectedCustomer, selectedWarehouse,
                                        request.getParameter(PARAMETER_PRODUCT + i),
                                        Integer.parseInt(request.getParameter(PARAMETER_AMOUNT + i)),
                                        Double.parseDouble(request.getParameter(PARAMETER_PRICE + i)),
                                        Double.parseDouble(request.getParameter(PARAMETER_AMOUNT_TO_BE_PAID + i))));
                                if (statusErrorPage) {
                                } else {
                                    mv.setViewName(CUSTOMER_SUCCESS_PAGE_VIEW_NAME);
                                }
                            }
                        } else {                            
                            prodErr.add(new ProductError(request.getParameter(PARAMETER_PRODUCT + i),
                                    selectedWarehouse,
                                    selectedDate));
                            mv.addObject(ERR_MSG_NOT_AVAILABLE_PRODUCT, prodErr);
                            mv.addObject(ERR_MSG_WAREHOUSE, selectedWarehouse);
                            mv.addObject(ERR_MSG_DATE, selectedDate);
                            mv.setViewName(CUSTOMER_ERROR_PAGE_VIEW_NAME);
                            statusErrorPage = true;
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

    public void setCustomer(CustomerDAO customer) {
        this.customer = customer;
    }

    public void setExpenseDocument(ExpenseDocumentDAO expenseDocument) {
        this.expenseDocument = expenseDocument;
    }

    public void setProduct(ProductDAO product) {
        this.product = product;
    }

    public void setIncomingDocument(IncomingDocumentDAO incomingDocument) {
        this.incomingDocument = incomingDocument;
    }
}