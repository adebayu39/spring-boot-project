package com.miniproject.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "t_purchase_detail")
public class PurchaseDetail {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "transaction_detail_id")
    private String id;
    @Column(name = "quantity_in_gram")
    private Double quantityInGram;
    private Integer price;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "transaction_id")
    @JsonIgnore
    private Purchase purchase;

    public PurchaseDetail() {
    }

    public PurchaseDetail(String id, Double quantityInGram, Integer price, Product product, Purchase purchase) {
        this.id = id;
        this.quantityInGram = quantityInGram;
        this.price = price;
        this.product = product;
        this.purchase = purchase;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getQuantityInGram() {
        return quantityInGram;
    }

    public void setQuantityInGram(Double quantityInGram) {
        this.quantityInGram = quantityInGram;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }
}
