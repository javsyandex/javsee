/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.testwarehouse.shumenko.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import ua.testwarehouse.shumenko.model.dao.ExpenseDocumentDAO;
import ua.testwarehouse.shumenko.model.dao.IncomingDocumentDAO;
import ua.testwarehouse.shumenko.model.dao.ProductDAO;
import ua.testwarehouse.shumenko.model.dao.WarehouseDAO;
import ua.testwarehouse.shumenko.model.entity.ExpenseDocument;
import ua.testwarehouse.shumenko.model.entity.IncomingDocument;
import ua.testwarehouse.shumenko.model.entity.Product;
import ua.testwarehouse.shumenko.model.entity.Warehouse;

/**
 *
 * @author miha
 */
public class GetRemainderList implements Remainder {

    private WarehouseDAO warehouseDao;
    private ProductDAO productDao;
    private IncomingDocumentDAO incomingDocumentDao;
    private ExpenseDocumentDAO expenseDocumentDao;
    private RemainderDocument remainderDoc;

    private List<RemainderDocument> CreateRemainderList(Date date) {
        List<RemainderDocument> result = new ArrayList();
        List<Warehouse> allWarehouse = warehouseDao.getAllWarehouse();
        List<Product> allProduct = productDao.getAllProduct();
        for (Product prod : allProduct) {
            
            List<Integer> incListAmount = new ArrayList();
            List<Integer> exListAmount = new ArrayList();
            List<Double> incListPrice = new ArrayList();
            List<Double> exListPrice = new ArrayList();
            List<Integer> resultAmount = new ArrayList();
            List<Double> resultPrice = new ArrayList();
            
            for (Warehouse whouse : allWarehouse) {

                List<IncomingDocument> incomingDoc = incomingDocumentDao.getInfoToRemainderDocument(date,
                        whouse.getWarehouse(), prod.getProduct());
                List<ExpenseDocument> expenseDoc = expenseDocumentDao.getInfoToRemainderDocument(date,
                        whouse.getWarehouse(), prod.getProduct());
//---------------------------------------------------------------------------------------                  
                if (incomingDoc.size() > 0) {
                    for (IncomingDocument id : incomingDoc) {
                        incListAmount.add(Integer.valueOf(id.getAmount()));
                        incListPrice.add(Double.valueOf(id.getAmountToBePaid()));
                    }
                } else {
                    incListAmount.add(Integer.valueOf(0));
                    incListPrice.add(Double.valueOf(0.0));
                }
//---------------------------------------------------------------------------------------- 
                if (expenseDoc.size() > 0) {
                    for (ExpenseDocument ed : expenseDoc) {
                        exListAmount.add(Integer.valueOf(ed.getAmount()));
                        exListPrice.add(Double.valueOf(ed.getNotionalAmount()));
                    }
                } else {
                    exListAmount.add(Integer.valueOf(0));
                    exListPrice.add(Double.valueOf(0.0));
                }
            }
            for (int i = 0; i < incListAmount.size(); i++) {
                resultAmount.add(incListAmount.get(i) - exListAmount.get(i));
                resultPrice.add(incListPrice.get(i)-exListPrice.get(i));
            }
            remainderDoc = new RemainderDocument(prod.getProduct(),
                    Double.valueOf(resultPrice.get(0)), Integer.valueOf(resultAmount.get(0)),
                    Double.valueOf(resultPrice.get(1)), Integer.valueOf(resultAmount.get(1)),
                    Double.valueOf(resultPrice.get(2)), Integer.valueOf(resultAmount.get(2)),
                    Double.valueOf(resultPrice.get(3)), Integer.valueOf(resultAmount.get(3)),
                    Double.valueOf(resultPrice.get(4)), Integer.valueOf(resultAmount.get(4)));
            result.add(remainderDoc);
        }
        return result;
    }
    
    @Override
    public List<RemainderDocument> getRemainderList(Date date){
        return CreateRemainderList(date);
    }

    public void setWarehouseDao(WarehouseDAO warehouseDao) {
        this.warehouseDao = warehouseDao;
    }

    public void setProductDao(ProductDAO productDao) {
        this.productDao = productDao;
    }

    public void setIncomingDocumentDao(IncomingDocumentDAO incomingDocumentDao) {
        this.incomingDocumentDao = incomingDocumentDao;
    }

    public void setExpenseDocumentDao(ExpenseDocumentDAO expenseDocumentDao) {
        this.expenseDocumentDao = expenseDocumentDao;
    }

    public void setRemainderDoc(RemainderDocument remainderDoc) {
        this.remainderDoc = remainderDoc;
    }
}
