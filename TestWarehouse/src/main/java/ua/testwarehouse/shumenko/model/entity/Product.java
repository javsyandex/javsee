/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.testwarehouse.shumenko.model.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 *
 * @author miha
 */
@Entity
public class Product implements Serializable {

    private Integer id;
    private String product;

    public Product() {
    }

    public Product(String product) {
        this.product = product;
    }

    @Id
    @TableGenerator(name = "productid", table = "productpktb", pkColumnName = "productkey",
            pkColumnValue = "productvalue", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "productid")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

  
}
