package com.miniproject.api.service;

import com.miniproject.api.entity.HistoryPrice;

import java.util.List;

public interface HistoryPriceService {
    public void saveHistoryPrice(HistoryPrice historyPrice);

    public List<HistoryPrice> getAllHistoryPrice();

    public List<HistoryPrice> getHistoryPriceByProduct(Integer productId);
}
