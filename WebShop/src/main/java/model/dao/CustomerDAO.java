/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.entity.Customer;
import model.entity.CustomerOrder;

/**
 *
 * @author Michael Shumenko
 */
public interface CustomerDAO {
   public List getAll();
   public void addCustomer(Customer customer); 
   public List getItemsByIdCustomer(Integer customerId);
   public void addCustomerOrder(CustomerOrder order);
}
