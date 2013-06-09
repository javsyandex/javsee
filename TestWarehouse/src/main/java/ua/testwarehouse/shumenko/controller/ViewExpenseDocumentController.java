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
import ua.testwarehouse.shumenko.model.dao.CustomerDAO;
import ua.testwarehouse.shumenko.model.dao.ExpenseDocumentDAO;
import ua.testwarehouse.shumenko.model.dao.WarehouseDAO;
import ua.testwarehouse.shumenko.model.entity.Customer;
import ua.testwarehouse.shumenko.model.entity.ExpenseDocument;
import ua.testwarehouse.shumenko.model.entity.Warehouse;

/**
 *
 * @author Michael Shumenko
 */
public class ViewExpenseDocumentController extends AbstractController {

    private static final String ERROR_VIEW_NAME = "error";
    private static final String EXPENSE_DOCUMENT_VIEW_NAME = "expense";
    private static final String WAREHOUSE_MODEL_NAME = "warehouse";
    private static final String CUSTOMER_MODEL_NAME = "customer";
    private static final String EXPENSE_MODEL_NAME = "expense";
    private static final String PARAMETER_DATE = "date";
    private static final String PARAMETER_CUSTOMER = "customer";
    private static final String PARAMETER_WAREHOUSE = "warehouse";
    private CustomerDAO customer;
    private WarehouseDAO warehouse;
    private ExpenseDocumentDAO expenseDocument;

    public ViewExpenseDocumentController() {
    }

    @Override
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView result = null;
        try {
            ModelAndView mv = new ModelAndView(EXPENSE_DOCUMENT_VIEW_NAME);
            List<Customer> allCustomer = customer.getAllCustomer();
            List<Warehouse> allWarehouse = warehouse.getAllWarehouse();
            mv.addObject(WAREHOUSE_MODEL_NAME, allWarehouse);
            mv.addObject(CUSTOMER_MODEL_NAME, allCustomer);

            String selectedDate = request.getParameter(PARAMETER_DATE);
            String selectedCustomer = request.getParameter(PARAMETER_CUSTOMER);
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
            List<ExpenseDocument> infoToExpenseDocument = expenseDocument.getInfoToExpenseDocument(date2, date2,
                    selectedCustomer, selectedWarehouse);
            mv.addObject(EXPENSE_MODEL_NAME, infoToExpenseDocument);
            result = mv;
        } catch (Exception ex) {
            
        }
        return result;
    }

    public void setCustomer(CustomerDAO customer) {
        this.customer = customer;
    }

    public void setWarehouse(WarehouseDAO warehouse) {
        this.warehouse = warehouse;
    }

    public void setExpenseDocument(ExpenseDocumentDAO expenseDocument) {
        this.expenseDocument = expenseDocument;
    }
}