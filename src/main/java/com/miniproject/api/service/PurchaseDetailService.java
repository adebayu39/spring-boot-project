package com.miniproject.api.service;

import com.miniproject.api.entity.Pocket;
import com.miniproject.api.entity.Purchase;
import com.miniproject.api.entity.PurchaseDetail;

import java.util.List;

public interface PurchaseDetailService {
    public void registerPurchaseDetail(PurchaseDetail purchaseDetail);

    public void saveAllPurchaseDetail(List<PurchaseDetail> purchaseDetailList);

    public PurchaseDetail getPurchaseDetailById(String id);

    public void transaction(Pocket balance, Purchase purchase, PurchaseDetail purchaseDetail);
}
