package com.miniproject.api.service;

import com.miniproject.api.constant.ApiUrlConstant;
import com.miniproject.api.dto.CustomerSearchDTO;
import com.miniproject.api.entity.Customer;
import com.miniproject.api.exception.DataNotFoundException;
import com.miniproject.api.repository.CustomerRepository;
import com.miniproject.api.spesification.CustomerSpesification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer getCustomerById(String id) {
        if (!customerRepository.existsById(id)) {
            String message = String.format(DataNotFoundException.NOT_FOUND_MESSAGE, "customer", id);
            throw new DataNotFoundException(message);
        }
        return customerRepository.findById(id).get();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Page<Customer> getCustomerPerPage(Pageable pageable, CustomerSearchDTO customerSearchDTO) {
        Specification<Customer> customerSpecification = CustomerSpesification.getSpesification(customerSearchDTO);
        return customerRepository.findAll(customerSpecification, pageable);
    }

    @Override
    public Customer editCustomer(Customer customer, MultipartFile file) {
        String pathFolderString = ApiUrlConstant.PATH_FOLDER_STRING;
        Path pathFolder = Paths.get(pathFolderString + customer.getId());
        Path pathFile = Paths.get(pathFolder.toString() + "/" + customer.getId() + ".png");
        try {
            Files.createDirectory(pathFolder);
            file.transferTo(pathFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        customer.setPhotoProfile(file.getOriginalFilename());
        return customerRepository.save(customer);
    }

    @Override
    public void uploadFoto(MultipartFile file) {
        String pathFolderString = ApiUrlConstant.PATH_FOLDER_STRING;
        Path pathFolder = Paths.get(pathFolderString + file.getOriginalFilename());
        Path pathFile = Paths.get(pathFolder.toString() + "/" + file.getOriginalFilename() + ".png");
        try {
            Files.createDirectory(pathFolder);
            file.transferTo(pathFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer uploadProfile(String id, MultipartFile photoProfile, String firstName, String lastName, Date dateOfBirth, String address, Integer status, String userName, String email) throws  IOException{
        String fileName = StringUtils.cleanPath(photoProfile.getOriginalFilename());
        Customer customer = new Customer(id, fileName, firstName, lastName, dateOfBirth, address, status, userName, email, photoProfile.getContentType(), photoProfile.getBytes());
        if(!getPassword(id).isEmpty()) {
            customer.setUserPassword(getPassword(id));
        }
        return  customerRepository.save(customer);
    }

    @Override
    public String getPassword(String id) {
        return customerRepository.findById(id).get().getUserPassword();
    }


    @Override
    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> getCustomerByName(String nameCriterias, String email) {
        return customerRepository.findCustomerByFirstNameContainingAndEmailContaining(nameCriterias, email);
//        return customerRepository.findCustomerByFirstNameIsLikeAndEmailIsLike("%"+nameCriterias+"%", "%"+email+"%");
    }

    public List<Customer> sortAsc() {
        return customerRepository.findByOrderByFirstNameDesc();
    }


}
