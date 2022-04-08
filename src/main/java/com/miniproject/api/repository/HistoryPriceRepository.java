package com.miniproject.api.repository;

import com.miniproject.api.entity.HistoryPrice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryPriceRepository extends JpaRepository<HistoryPrice, String> {
    public List<HistoryPrice> findAllByProductId(Integer productId);
}
