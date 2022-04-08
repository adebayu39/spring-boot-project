package com.miniproject.api.service;

import com.miniproject.api.dto.TransactionDTO;
import com.miniproject.api.entity.Pocket;
import com.miniproject.api.entity.Purchase;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PurchaseService {
    public void registerPurchase(Purchase purchase);

    public Purchase getPurchaseById(String id);

    public Pocket transaction(TransactionDTO transactionDTO) throws JsonProcessingException;

    public Page<Purchase> getPurchaseByCustomerId(String customerId, Pageable pageable);
}
