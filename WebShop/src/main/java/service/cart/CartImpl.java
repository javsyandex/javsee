/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.cart;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Michael Shumenko
 */
public class CartImpl implements Cart {

    private List<String> allNameItem=new ArrayList();
    private List<Integer> allPriceItem=new ArrayList();
    private String lastItemFromCart = "Вы еще не добавили ни одной вещи";
    private Integer summaryPrice = 0;
    
    @Override
    public List<String> getAllNameItem() {
        return allNameItem;
    }

    @Override
    public List<Integer> getAllPriceItem() {
        return allPriceItem;
    }

    @Override
    public String getLastItemFromCart() {
        return lastItemFromCart;
    }

    @Override
    public void setLastItemFromCart(String lastItemFromCart) {
        this.lastItemFromCart = lastItemFromCart;
    }

    @Override
    public Integer getSummaryPrice() {
        return summaryPrice;
    }

    @Override
    public void setSummaryPrice(Integer summaryPrice) {
        if (summaryPrice == 0) {
            this.summaryPrice = 0;
        } else {
            this.summaryPrice = this.summaryPrice + summaryPrice;
        }
    }

    @Override
    public void addItemToCart(String name, Integer price) {
        this.allNameItem.add(name);
        this.allPriceItem.add(price);
    }

    @Override
    public void deleteItemFromCart(String name, Integer price) {
        allNameItem.remove(name);
        allPriceItem.remove(price);
    }
    
    @Override
    public Integer getCurrentId(String item){
       Integer result = null;
        for(int i = 0; i < allNameItem.size(); i++){
           String s = allNameItem.get(i);
           if(s.equals(item)){
               result=i;
           }
        }
        
        return result;
    }
    @Override
     public void deleteAll(){
       allNameItem.removeAll(allNameItem);
       allPriceItem.removeAll(allPriceItem);
     }   
    
}
