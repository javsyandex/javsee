/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author miha
 */
@Entity
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String AVAILABLE_TRUE = "Есть в наличии: ";
    public static final String AVAILABLE_FALSE = "Нет в наличии";
    private Integer id;
    private String nameProducts;
    private boolean available;
    private Integer amount;
    private String urlForController;
    
    public Category() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameProducts() {
        return nameProducts;
    }

    public void setNameProducts(String nameProducts) {
        this.nameProducts = nameProducts;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getUrlForController() {
        return urlForController;
    }

    public void setUrlForController(String urlForController) {
        this.urlForController = urlForController;
    }
    
     public String viewAmountProduct() {
        String amountProduct = AVAILABLE_FALSE;
        try {
            if (isAvailable()) {
                amountProduct=AVAILABLE_TRUE+getAmount();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return amountProduct;

    }
}
