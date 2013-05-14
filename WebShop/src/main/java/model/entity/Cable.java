/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import javax.persistence.*;

/**
 *
 * @author miha
 */
@Entity
public class Cable {

    private static final long serialVersionUID = 1L;
    public static final String AVAILABLE_TRUE = "Есть в наличии: ";
    public static final String AVAILABLE_FALSE = "Нет в наличии";
    private Integer id;
    private String nameCable;
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

    public String getNameCable() {
        return nameCable;
    }

    public void setNameCable(String nameCable) {
        this.nameCable = nameCable;
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
    
    public String viewAmountCable() {
        String amountProduct = AVAILABLE_FALSE;
        try {
            if (isAvailable()) {
                amountProduct = AVAILABLE_TRUE + getAmount();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return amountProduct;

    }
}
