package com.miniproject.api.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mst_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id", columnDefinition = "serial")
    private Integer id;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_desc")
    private String productDesc;
    @Column(name = "product_status")
    private Integer productStatus;
    @Column(name = "product_price_buy")
    private Integer productPriceBuy;
    @Column(name = "product_price_sell")
    private Integer productPriceSell;
    @Column(name = "product_image")
    private String productImage;
    @OneToMany(mappedBy = "product")
    List<HistoryPrice> historyPrices = new ArrayList<>();

    public Product() {
    }

    public Product(String productName, String productDesc, Integer productStatus, Integer productPriceBuy, Integer productPriceSell, String productImage) {
        this.productName = productName;
        this.productDesc = productDesc;
        this.productStatus = productStatus;
        this.productPriceBuy = productPriceBuy;
        this.productPriceSell = productPriceSell;
        this.productImage = productImage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public Integer getProductPriceBuy() {
        return productPriceBuy;
    }

    public void setProductPriceBuy(Integer productPriceBuy) {
        this.productPriceBuy = productPriceBuy;
    }

    public Integer getProductPriceSell() {
        return productPriceSell;
    }

    public void setProductPriceSell(Integer productPriceSell) {
        this.productPriceSell = productPriceSell;
    }

    public String getProductImage() {
        return productImage;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public List<HistoryPrice> getHistoryPrices() {
        return historyPrices;
    }

    public void setHistoryPrices(List<HistoryPrice> historyPrices) {
        this.historyPrices = historyPrices;
    }
}
