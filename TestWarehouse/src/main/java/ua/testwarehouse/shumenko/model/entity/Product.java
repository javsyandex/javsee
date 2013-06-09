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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
