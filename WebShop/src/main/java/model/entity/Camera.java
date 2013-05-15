/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Michael Shumenko
 */
@Entity
public class Camera implements Serializable{
    
    private static final long serialVersionUID = 1L;
    public static final String AVAILABLE_TRUE = "Есть в наличии: ";
    public static final String AVAILABLE_FALSE = "Нет в наличии";
    private Integer id;
    private String nameCamera;
    private String modelCamera;
    private Integer price;
    private boolean available;
    private Integer amount;
   

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameCamera() {
        return nameCamera;
    }

    public void setNameCamera(String nameCamera) {
        this.nameCamera = nameCamera;
    }

    public String getModelCamera() {
        return modelCamera;
    }

    public void setModelCamera(String modelCamera) {
        this.modelCamera = modelCamera;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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

    
     public String viewAmountCamera() {
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
