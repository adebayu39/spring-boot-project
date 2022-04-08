package com.miniproject.api.service;

import com.miniproject.api.entity.Store;
import com.miniproject.api.entity.StoreList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;


@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    RestTemplate restTemplate;

    final String ROOT_URI = "http://localhost:8081/stores";

    @Override
    public List<Store> getStores() {
        ResponseEntity<StoreList> responseEntity = restTemplate.getForEntity(ROOT_URI, StoreList.class);
        return Objects.requireNonNull(responseEntity.getBody()).getContent();
    }

    final String URI = "http://localhost:8081/store";

    @Override
    public Store getStoreId(String id) {
        ResponseEntity<Store> res = restTemplate.getForEntity(URI + "/" + id, Store.class);
        return res.getBody();
    }

    @Override
    public List<String> getAllStore() {
        ResponseEntity<String> response = restTemplate.getForEntity(ROOT_URI, String.class);
        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }

    @Override
    public String getStoreById(String id) {
        ResponseEntity<String> response = restTemplate.getForEntity(URI + "/" + id, String.class);
        return response.toString();
    }

}
