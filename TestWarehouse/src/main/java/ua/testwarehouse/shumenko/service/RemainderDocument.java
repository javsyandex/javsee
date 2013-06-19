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
public class RemainderDocument implements Serializable {

    private String product;
    private Double priceWH1;
    private Integer amountWH1;
    private Double priceWH2;
    private Integer amountWH2;
    private Double priceWH3;
    private Integer amountWH3;
    private Double priceWH4;
    private Integer amountWH4;
    private Double priceWH5;

    public RemainderDocument(String product, Double priceWH1, Integer amountWH1, Double priceWH2, Integer amountWH2, Double priceWH3, Integer amountWH3, Double priceWH4, Integer amountWH4, Double priceWH5, Integer amountWH5) {
        this.product = product;
        this.priceWH1 = priceWH1;
        this.amountWH1 = amountWH1;
        this.priceWH2 = priceWH2;
        this.amountWH2 = amountWH2;
        this.priceWH3 = priceWH3;
        this.amountWH3 = amountWH3;
        this.priceWH4 = priceWH4;
        this.amountWH4 = amountWH4;
        this.priceWH5 = priceWH5;
        this.amountWH5 = amountWH5;
    }
    private Integer amountWH5;

    public RemainderDocument() {
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Double getPriceWH1() {
        return priceWH1;
    }

    public void setPriceWH1(Double priceWH1) {
        this.priceWH1 = priceWH1;
    }

    public Integer getAmountWH1() {
        return amountWH1;
    }

    public void setAmountWH1(Integer amountWH1) {
        this.amountWH1 = amountWH1;
    }

    public Double getPriceWH2() {
        return priceWH2;
    }

    public void setPriceWH2(Double priceWH2) {
        this.priceWH2 = priceWH2;
    }

    public Integer getAmountWH2() {
        return amountWH2;
    }

    public void setAmountWH2(Integer amountWH2) {
        this.amountWH2 = amountWH2;
    }

    public Double getPriceWH3() {
        return priceWH3;
    }

    public void setPriceWH3(Double priceWH3) {
        this.priceWH3 = priceWH3;
    }

    public Integer getAmountWH3() {
        return amountWH3;
    }

    public void setAmountWH3(Integer amountWH3) {
        this.amountWH3 = amountWH3;
    }

    public Double getPriceWH4() {
        return priceWH4;
    }

    public void setPriceWH4(Double priceWH4) {
        this.priceWH4 = priceWH4;
    }

    public Integer getAmountWH4() {
        return amountWH4;
    }

    public void setAmountWH4(Integer amountWH4) {
        this.amountWH4 = amountWH4;
    }

    public Double getPriceWH5() {
        return priceWH5;
    }

    public void setPriceWH5(Double priceWH5) {
        this.priceWH5 = priceWH5;
    }

    public Integer getAmountWH5() {
        return amountWH5;
    }

    public void setAmountWH5(Integer amountWH5) {
        this.amountWH5 = amountWH5;
    }
    
}
