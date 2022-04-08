package com.miniproject.api.service;

import com.miniproject.api.entity.Store;

import java.util.List;

public interface StoreService {
    List<Store> getStores();

    Store getStoreId(String id);

    List<String> getAllStore();

    String getStoreById(String id);
}
