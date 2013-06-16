/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.testwarehouse.shumenko.model.dao;

import java.util.List;
import ua.testwarehouse.shumenko.model.entity.Product;

/**
 *
 * @author miha
 */
public interface ProductDAO {
    public List<Product> getAllProduct();
    public boolean checkProductAvailability(String product);
    public void saveProduct(Product product);
}
