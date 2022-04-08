package com.miniproject.api.dto;

public class ProductSearchDTO {
    private String searchProductName;

    public ProductSearchDTO(String searchProductName) {
        this.searchProductName = searchProductName;
    }

    public String getSearchProductName() {
        return searchProductName;
    }
}
