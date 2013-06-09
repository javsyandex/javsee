/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.testwarehouse.shumenko.model.dao;

import java.util.List;
import ua.testwarehouse.shumenko.model.entity.Customer;

/**
 *
 * @author miha
 */
public interface CustomerDAO {
    public List<Customer> getAllCustomer();
}
