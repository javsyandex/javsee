/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.testwarehouse.shumenko.model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Michael Shumenko
 */
@Entity
public class IncomingDocument implements Serializable{

    private Integer id;
    private Date deliveryDate;
    private String shipper;
    private String warehouse;
    private String product;
    private Integer amount;
    private Double price;
    private Double amountToBePaid;
    
    public IncomingDocument() {
    }

    public IncomingDocument(Date deliveryDate, String shipper, String warehouse, 
            String product, Integer amount, Double price, Double amountToBePaid) {
        this.deliveryDate = deliveryDate;
        this.shipper = shipper;
        this.warehouse = warehouse;
        this.product = product;
        this.amount = amount;
        this.price = price;
        this.amountToBePaid = amountToBePaid;
    }
    

    @Id
    @TableGenerator(name = "incomingid", table = "incomingpktb", pkColumnName = "incomingkey",
            pkColumnValue = "incomingvalue", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "incomingid")
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

    public String getShipper() {
        return shipper;
    }

    public void setShipper(String shipper) {
        this.shipper = shipper;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAmountToBePaid() {
        return amountToBePaid;
    }

    public void setAmountToBePaid(Double amountToBePaid) {
        this.amountToBePaid = amountToBePaid;
    }
}
