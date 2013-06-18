/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.testwarehouse.shumenko.model.dao;

import java.util.Date;
import java.util.List;
import ua.testwarehouse.shumenko.model.entity.ExpenseDocument;

/**
 *
 * @author Michael Shumenko
 */
public interface ExpenseDocumentDAO {

    public List<ExpenseDocument> getInfoToExpenseDocument(Date fromDeliveryDate,
            Date byDeliveryDate, String customer, String warehouse);

    public List<ExpenseDocument> getInfoToRemainderDocument(Date deliveryDate, String warehouse, String Product);

    public void saveExpense(ExpenseDocument exdoc);

    public boolean checkAvailabilityProductInExpenseAndUpdate(Date date, String shipper, String warehouse,
            String product, Double price, Double AmountToBePaid, Integer amount);

    public void updateExpense(Double amountToBePaid, Integer amount, Integer id);
}
