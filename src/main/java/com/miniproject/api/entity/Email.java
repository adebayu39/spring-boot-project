package com.miniproject.api.entity;

public class Email {
    private String customerId;
    private String transactionType;
    private Integer price;
    private String message;

    public Email() {
    }

    public Email(String customerId, String transactionType, Integer price, String message) {
        this.customerId = customerId;
        this.transactionType = transactionType;
        this.price = price;
        this.message = message;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
