/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import service.RemainderDocument;
import ua.testwarehouse.shumenko.model.dao.ExpenseDocumentDAO;
import ua.testwarehouse.shumenko.model.dao.IncomingDocumentDAO;
import ua.testwarehouse.shumenko.model.dao.ProductDAO;
import ua.testwarehouse.shumenko.model.dao.WarehouseDAO;
import ua.testwarehouse.shumenko.model.daoImpl.ExpenseDocumentDAOImpl;
import ua.testwarehouse.shumenko.model.daoImpl.IncomingDocumentDAOImpl;
import ua.testwarehouse.shumenko.model.daoImpl.ProductDAOImpl;
import ua.testwarehouse.shumenko.model.daoImpl.WarehouseDAOImpl;
import ua.testwarehouse.shumenko.model.entity.ExpenseDocument;
import ua.testwarehouse.shumenko.model.entity.IncomingDocument;
import ua.testwarehouse.shumenko.model.entity.Product;
import ua.testwarehouse.shumenko.model.entity.Warehouse;

/**
 *
 * @author miha
 */
public class Test {

    public static void main(String[] args) {

        WarehouseDAO warehouseDao = new WarehouseDAOImpl();
        ProductDAO productDao = new ProductDAOImpl();
        IncomingDocumentDAO incomingDocumentDao = new IncomingDocumentDAOImpl();
        ExpenseDocumentDAO expenseDocumentDao = new ExpenseDocumentDAOImpl();
        RemainderDocument remainderDoc;

        List<Warehouse> allWarehouse = warehouseDao.getAllWarehouse();
        List<Product> allProduct = productDao.getAllProduct();

        System.out.println("Hello  mazafaka");

        String selectedDate = "2013-06-01";
        Date date1 = null;
        if (selectedDate != null) {
            try {
                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                date1 = formatter.parse(selectedDate);
            } catch (Exception e) {
            }
        }

        List<RemainderDocument> remList = new ArrayList();

        for (Product prod : allProduct) {
            List<Integer> incListAmount = new ArrayList();
            List<Integer> exListAmount = new ArrayList();
            List<Integer> resultAmount = new ArrayList();
            for (Warehouse whouse : allWarehouse) {
                System.out.println();
                System.out.print(whouse.getWarehouse());

//                for (Product prod : allProduct) {
                List<IncomingDocument> incomingDoc = incomingDocumentDao.getInfoToRemainderDocument(date1,
                        whouse.getWarehouse(), prod.getProduct());
                List<ExpenseDocument> expenseDoc = expenseDocumentDao.getInfoToRemainderDocument(date1,
                        whouse.getWarehouse(), prod.getProduct());
                System.out.print(" " + prod.getProduct() + " " + incomingDoc.size() + " "
                        + expenseDoc.size());
//---------------------------------------------------------------------------------------                  
                if (incomingDoc.size() > 0) {
                    for (IncomingDocument id : incomingDoc) {
                        incListAmount.add(Integer.valueOf(id.getAmount()));
                    }
                } else {
                    incListAmount.add(Integer.valueOf(0));
                }
//---------------------------------------------------------------------------------------- 
                if (expenseDoc.size() > 0) {
                    for (ExpenseDocument ed : expenseDoc) {
                        exListAmount.add(Integer.valueOf(ed.getAmount()));
                    }
                } else {
                    exListAmount.add(Integer.valueOf(0));
                }
//-----------------------------------------------------------------------------------------   

//                }
//-----------------------------------------------------------------------------------------   
//                System.out.println();
//                System.out.println(" Ex Lis Size " + exListAmount.size());
//                System.out.println(" Inc List Size" + incListAmount.size());
//-----------------------------------------------------------------------------------------                
            }
//-----------------------------------------------------------------------------------------
            for(int i=0;i<incListAmount.size();i++){
                resultAmount.add(incListAmount.get(i)-exListAmount.get(i));
            }
            remainderDoc = new RemainderDocument(prod.getProduct(),
                    Double.NaN, Integer.valueOf(resultAmount.get(0)),
                    Double.NaN, Integer.valueOf(resultAmount.get(1)),
                    Double.NaN, Integer.valueOf(resultAmount.get(2)),
                    Double.NaN, Integer.valueOf(resultAmount.get(3)),
                    Double.NaN, Integer.valueOf(resultAmount.get(4)));
            remList.add(remainderDoc);
            System.out.println();
            System.out.println(remList.size());
        }

        for (RemainderDocument rd : remList) {
            System.out.println(rd.getProduct() + " " + rd.getAmountWH1() + " " + rd.getAmountWH2()
                    + " " + rd.getAmountWH3() + " " + rd.getAmountWH4() + " " + rd.getAmountWH5());
        }
    }
}