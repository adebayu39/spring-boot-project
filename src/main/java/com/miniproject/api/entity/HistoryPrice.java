package com.miniproject.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "history_price")
public class HistoryPrice {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "history_price_id")
    private String id;
    private Date date;
    @Column(name = "price_buy")
    private Integer priceBuy;
    @Column(name = "price_sell")
    private Integer priceSell;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "product_id")
    private Product product;

    public HistoryPrice() {
    }

    public HistoryPrice(String id, Date date, Integer priceBuy, Integer priceSell, Product product) {
        this.id = id;
        this.date = date;
        this.priceBuy = priceBuy;
        this.priceSell = priceSell;
        this.product = product;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getPriceBuy() {
        return priceBuy;
    }

    public void setPriceBuy(Integer price) {
        this.priceBuy = price;
    }

    public Integer getPriceSell() {
        return priceSell;
    }

    public void setPriceSell(Integer priceSell) {
        this.priceSell = priceSell;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product_id) {
        this.product = product_id;
    }
}
