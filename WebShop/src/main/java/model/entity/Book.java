/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

/**
 *
 * @author Michael Shumenko
 */
import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String AVAILABLE_TRUE = "Есть в наличии: ";
    public static final String AVAILABLE_FALSE = "Нет в наличии";
    private Integer id;
    private String nameBook;
    private String author;
    private Integer price;
    private Integer numberOfPages;
    private Integer yearOfPublication;
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

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Integer getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(Integer yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
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

    public String viewAmountBook() {
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
