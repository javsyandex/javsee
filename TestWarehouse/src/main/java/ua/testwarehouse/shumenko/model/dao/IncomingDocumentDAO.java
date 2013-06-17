/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.testwarehouse.shumenko.model.dao;

import java.util.Date;
import java.util.List;
import ua.testwarehouse.shumenko.model.entity.IncomingDocument;

/**
 *
 * @author Michael Shumenko
 */
public interface IncomingDocumentDAO {
    public List<IncomingDocument> getInfoToIncomingDocument(Date fromDeliveryDate,
            Date byDeliveryDate,String shipper,String warehouse);
    public List<IncomingDocument> getInfoToRemainderDocument(Date deliveryDate, String warehouse,String product);
    
    public void saveIncoming(IncomingDocument incdoc);
    public boolean checkAvailabilityProductInIncoming(Date date,String shipper,String warehouse,
            String product, Double price, Double AmountToBePaid, Integer amount);
    public void updateIncoming(Double amountToBePaid, Integer amount, IncomingDocument incdoc);
}
