/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.testwarehouse.shumenko.model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

/**
 *
 * @author Michael Shumenko
 */
@Entity
public class ExpenseDocument implements Serializable{
        
    private Integer id;
    private Date deliveryDate;
    private String customer;
    private String warehouse;
    private String product;
    private Integer amount;
    private Double notionalPrice;
    private Double notionalAmount;

    public ExpenseDocument() {
    }

    public ExpenseDocument(Date deliveryDate, String customer, String warehouse,
            String product, Integer amount, Double notionalPrice, Double notionalAmount) {
        this.deliveryDate = deliveryDate;
        this.customer = customer;
        this.warehouse = warehouse;
        this.product = product;
        this.amount = amount;
        this.notionalPrice = notionalPrice;
        this.notionalAmount = notionalAmount;
    }

    @Id
    @TableGenerator(name = "expenseid", table = "expensepktb", pkColumnName = "expensekey",
            pkColumnValue = "expensevalue", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "expenseid")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Temporal(TemporalType.DATE)
    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getNotionalPrice() {
        return notionalPrice;
    }

    public void setNotionalPrice(Double notionalPrice) {
        this.notionalPrice = notionalPrice;
    }

    public Double getNotionalAmount() {
        return notionalAmount;
    }

    public void setNotionalAmount(Double notionalAmount) {
        this.notionalAmount = notionalAmount;
    }
}
