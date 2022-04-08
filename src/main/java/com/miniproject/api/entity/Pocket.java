package com.miniproject.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "mst_pocket")
public class Pocket {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "pocket_id")
    private String id;
    @Column(name = "pocket_qty")
    private Double pocketQty;
    @Column(name = "pocket_name")
    private String pocketName;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnoreProperties("pockets")
    private Customer customer;


    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Pocket() {
    }

    public Pocket(Double pocketQty) {
        this.pocketQty = pocketQty;
    }

    public Pocket(double v, Customer customer) {
        this.pocketQty = v;
        this.customer = customer;
    }

    public Pocket(Double pocketQty, String pocketName, Customer customer, Product product) {
        this.pocketQty = pocketQty;
        this.customer = customer;
        this.product = product;
        this.pocketName = pocketName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getPocketQty() {
        return pocketQty;
    }

    public void setPocketQty(Double pocketQty) {
        this.pocketQty = pocketQty;
    }

    public String getPocketName() {
        return pocketName;
    }

    public void setPocketName(String pocketName) {
        this.pocketName = pocketName;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
