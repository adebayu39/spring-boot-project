package com.miniproject.api;

import com.miniproject.api.repository.PocketRepository;
import com.miniproject.api.repository.CustomerRepository;
import com.miniproject.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DataRunner implements CommandLineRunner {

    @Autowired
    PocketRepository pocketRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    RestTemplate restTemplate;


    @Override
    public void run(String... args) throws Exception {


    }
}
