package com.miniproject.api.dto;

import java.util.Date;

public class CustomerSearchDTO {
    private String searchCustomerFirstName;
    private String searchCustomerEmail;
    private String searchCustomerAddress;
    private Date searchCustomerDateOfBirth;

    public CustomerSearchDTO(String searchCustomerFirstName, String searchCustomerEmail, String searchCustomerAddress, Date searchCustomerDateOfBirth) {
        this.searchCustomerFirstName = searchCustomerFirstName;
        this.searchCustomerEmail = searchCustomerEmail;
        this.searchCustomerAddress = searchCustomerAddress;
        this.searchCustomerDateOfBirth = searchCustomerDateOfBirth;
    }

    public String getSearchCustomerFirstName() {
        return searchCustomerFirstName;
    }

    public String getSearchCustomerEmail() {
        return searchCustomerEmail;
    }

    public String getSearchCustomerAddress() {
        return searchCustomerAddress;
    }

    public Date getSearchCustomerDateOfBirth() {
        return searchCustomerDateOfBirth;
    }
}

