package com.miniproject.api.repository;

import com.miniproject.api.entity.Purchase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, String> {
    public Page<Purchase> findAllByCustomerId(String customerId, Pageable page);
}
