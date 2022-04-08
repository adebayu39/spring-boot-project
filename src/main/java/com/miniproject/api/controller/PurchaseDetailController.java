package com.miniproject.api.controller;

import com.miniproject.api.entity.PurchaseDetail;
import com.miniproject.api.service.PurchaseDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PurchaseDetailController {
    @Autowired
    PurchaseDetailService purchaseDetailService;

    @PostMapping("/purchaseDetails")
    public void savePurchaseDetail(@RequestBody PurchaseDetail purchaseDetail) {
        purchaseDetailService.registerPurchaseDetail(purchaseDetail);
    }

    @PostMapping("/purchaseDetails/list")
    public void saveAllPurchaseDetail(@RequestBody List<PurchaseDetail> purchaseDetailList) {
        purchaseDetailService.saveAllPurchaseDetail(purchaseDetailList);
    }

    @GetMapping("purchaseDetails/{id}")
    public PurchaseDetail getPurchaseDetailById(@PathVariable String id) {
        return purchaseDetailService.getPurchaseDetailById(id);
    }


}
