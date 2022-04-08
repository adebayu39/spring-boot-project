package com.miniproject.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "t_purchase")
public class Purchase {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "transaction_id")
    private String id;
    @Column(name = "transaction_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date transactionDate;
    @Column(name = "purchase_type")
    private Integer purchaseType;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "purchase", cascade = CascadeType.PERSIST)
    private List<PurchaseDetail> purchaseDetailList = new ArrayList<>();

    public Purchase() {
    }

    public Purchase(String id, Date transactionDate, Integer purchaseType, Customer customer, List<PurchaseDetail> purchaseDetailList) {
        this.id = id;
        this.transactionDate = transactionDate;
        this.customer = customer;
        this.purchaseType = purchaseType;
        this.purchaseDetailList = purchaseDetailList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customerId) {
        this.customer = customerId;
    }

    public Integer getPurchaseType() {
        return purchaseType;
    }

    public void setPurchaseType(Integer puchaseType) {
        this.purchaseType = puchaseType;
    }

    public List<PurchaseDetail> getPurchaseDetailList() {
        return purchaseDetailList;
    }

    public void setPurchaseDetailList(List<PurchaseDetail> purchaseDetailList) {
        this.purchaseDetailList = purchaseDetailList;
    }
}
