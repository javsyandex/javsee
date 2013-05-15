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
public class Notebook implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String AVAILABLE_TRUE = "Есть в наличии: ";
    public static final String AVAILABLE_FALSE = "Нет в наличии";
    private Integer id;
    private String nameNotebook;
    private String modelNotebook;
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

    public String getNameNotebook() {
        return nameNotebook;
    }

    public void setNameNotebook(String nameNotebook) {
        this.nameNotebook = nameNotebook;
    }

    public String getModelNotebook() {
        return modelNotebook;
    }

    public void setModelNotebook(String modelNotebook) {
        this.modelNotebook = modelNotebook;
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

     public String viewAmountNotebook() {
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
