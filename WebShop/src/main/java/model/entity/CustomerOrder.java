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
public class CustomerOrder implements Serializable {

    private Integer id;
    private Integer idCustomer;
    private String nameItem;
    private Integer priceItem;

    public CustomerOrder() {
    }

    public CustomerOrder(Integer idCustomer, String nameItem, Integer priceItem) {
        this.idCustomer = idCustomer;
        this.nameItem = nameItem;
        this.priceItem = priceItem;
    }
    
    @Id
    @TableGenerator(name = "orderid", table = "orderpktb", pkColumnName = "orderkey",
            pkColumnValue = "ordervalue", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "orderid")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public Integer getPriceItem() {
        return priceItem;
    }

    public void setPriceItem(Integer priceItem) {
        this.priceItem = priceItem;
    }
}
