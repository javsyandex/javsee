/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;
/**
 *
 * @author Michael Shumenko
 */
@Entity
public class Customer implements Serializable {

    private Integer customerId;
    private String customerName;
    private String customerEmeilAdress;
    private Integer creditCart;
    private Integer sumPayment;

    public Customer() {
    }

    public Customer(String nameCustomer, String emeil, Integer cartNumber, Integer sumPrice) {
        this.creditCart = cartNumber;
        this.customerEmeilAdress = emeil;
        this.customerName = nameCustomer;
        this.sumPayment = sumPrice;
    }

    @Id
    @TableGenerator(name = "customerid", table = "customerpktb", pkColumnName = "customerkey",
            pkColumnValue = "customervalue", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "customerid")
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmeilAdress() {
        return customerEmeilAdress;
    }

    public void setCustomerEmeilAdress(String customerEmeilAdress) {
        this.customerEmeilAdress = customerEmeilAdress;
    }
    @Size(max=25)
    public Integer getCreditCart() {
        return creditCart;
    }

    public void setCreditCart(Integer creditCart) {
        this.creditCart = creditCart;
    }

    public Integer getSumPayment() {
        return sumPayment;
    }

    public void setSumPayment(Integer sumPayment) {
        this.sumPayment = sumPayment;
    }
}
