package com.miniproject.api.controller;

import com.miniproject.api.entity.Store;
import com.miniproject.api.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class StoreController {
    @Autowired
    StoreService storeService;

    @Autowired
    RestTemplate restTemplate;

    final String URI = "http://localhost:8081/store";

    @RequestMapping(value = "/template/stores")
    public String getStoreList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange(URI + "s", HttpMethod.GET, entity, String.class).getBody();
    }

    @RequestMapping(value = "/template/store/{id}", method = RequestMethod.GET)
    public String getStoreById(@PathVariable("id") String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange(URI + "/" + id, HttpMethod.GET, entity, String.class).getBody();
    }

    @RequestMapping(value = "/template/store", method = RequestMethod.POST)
    public String saveStore(@RequestBody Store store) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Store> entity = new HttpEntity<Store>(store, headers);

        return restTemplate.exchange(URI, HttpMethod.POST, entity, String.class).getBody();
    }

    @RequestMapping(value = "/template/store", method = RequestMethod.PUT)
    public String updateStore(@RequestBody Store store) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Store> entity = new HttpEntity<Store>(store, headers);

        return restTemplate.exchange(URI, HttpMethod.PUT, entity, String.class).getBody();
    }

    @RequestMapping(value = "/template/store", method = RequestMethod.DELETE)
    public String updateStore(@RequestParam String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange(URI + "/", HttpMethod.DELETE, entity, String.class).getBody();
    }


    @GetMapping("/stores")
    public List<Store> getStores() {
        return storeService.getStores();
    }

    @GetMapping("/store/{id}")
    public Store getStoreId(@PathVariable String id) {
        return storeService.getStoreId(id);
    }


//    @GetMapping("/stores")
//    public List<String> getStore(){
//        return storeService.getAllStore();
//    }
//
//    @GetMapping("/store/{id}")
//    public String getStoreById(@PathVariable String id){
//        return storeService.getStoreById(id);
//    }
}
