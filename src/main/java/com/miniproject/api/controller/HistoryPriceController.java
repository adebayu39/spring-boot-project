package com.miniproject.api.controller;

import com.miniproject.api.entity.HistoryPrice;
import com.miniproject.api.service.HistoryPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HistoryPriceController {
    @Autowired
    HistoryPriceService historyPriceService;

    @GetMapping("/historyPrices")
    public List<HistoryPrice> getAllHistoryPrice() {
        return historyPriceService.getAllHistoryPrice();
    }

    @GetMapping("/historyPrices/{productId}")
    public List<HistoryPrice> getHistoryPriceByProdId(@PathVariable Integer productId) {
        return historyPriceService.getHistoryPriceByProduct(productId);
    }
}
