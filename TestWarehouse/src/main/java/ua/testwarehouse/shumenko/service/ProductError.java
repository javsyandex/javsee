/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.testwarehouse.shumenko.service;

import java.io.Serializable;

/**
 *
 * @author miha
 */
public class ProductError implements Serializable{

    private String product;
    private String warehouse;
    private String date;

    public ProductError(String product, String warehouse, String date) {
        this.product = product;
        this.warehouse = warehouse;
        this.date = date;
    }

    public ProductError() {
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
