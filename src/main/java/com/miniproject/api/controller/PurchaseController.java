package com.miniproject.api.controller;

import com.miniproject.api.dto.TransactionDTO;
import com.miniproject.api.entity.Pocket;
import com.miniproject.api.entity.Purchase;
import com.miniproject.api.service.PurchaseService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
public class PurchaseController {
    @Autowired
    PurchaseService purchaseService;

//    @PostMapping("/purchases")
//    public void savePurchase(@RequestBody Purchase purchase) {
//        purchaseService.registerPurchase(purchase);
//    }

    @GetMapping("/purchases/{id}")
    public Purchase getPurchaseById(@PathVariable String id) {
        return purchaseService.getPurchaseById(id);
    }


    @PostMapping("/purchases")
    //@PreAuthorize("hasRole('USER')")
    public Pocket transaction(@RequestBody TransactionDTO transactionDTO) throws JsonProcessingException {
        return purchaseService.transaction(transactionDTO);
    }

    @GetMapping("/purchases/customer/{customerId}")
    public Page<Purchase> getPurchaseByCustomerId(@PathVariable String customerId,
                                                  @RequestParam(name = "page", defaultValue = "0") Integer page,
                                                  @RequestParam(name = "size", defaultValue = "10") Integer sizePerPage,
                                                  @RequestParam(name = "sortBy", defaultValue = "transactionDate") String sortBy,
                                                  @RequestParam(name = "direction", defaultValue = "DESC") String direction) {

        if (sortBy != null) {
            Sort sort = Sort.by(Sort.Direction.fromString(direction), sortBy);
            Pageable pageable = PageRequest.of(page, sizePerPage, sort);
            return purchaseService.getPurchaseByCustomerId(customerId, pageable);
        } else {
            Pageable pageable = PageRequest.of(page, sizePerPage);
            return purchaseService.getPurchaseByCustomerId(customerId, pageable);
        }
    }
}
