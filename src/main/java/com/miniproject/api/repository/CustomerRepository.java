package com.miniproject.api.repository;

import com.miniproject.api.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, String>, JpaSpecificationExecutor<Customer> {
    public List<Customer> findCustomerByFirstNameContainingAndEmailContaining(String name, String email);

    public List<Customer> findCustomerByFirstNameIsLikeAndEmailIsLike(String name, String Email);

    List<Customer> findByOrderByFirstNameDesc();

    Optional<Customer> findByUserName(String username);

    Boolean existsByUserName(String username);

    Boolean existsByEmail(String email);
}
