package com.miniproject.api.repository;

import com.miniproject.api.entity.PurchaseDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseDetailRepository extends JpaRepository<PurchaseDetail, String> {
}
