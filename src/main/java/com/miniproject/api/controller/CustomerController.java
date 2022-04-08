package com.miniproject.api.controller;

import com.miniproject.api.constant.ApiUrlConstant;
import com.miniproject.api.dto.CustomerFileDTO;
import com.miniproject.api.dto.CustomerSearchDTO;
import com.miniproject.api.entity.Customer;
import com.miniproject.api.security.payload.response.MessageResponse;
import com.miniproject.api.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Date;

@RestController
@RequestMapping(ApiUrlConstant.CUSTOMER)
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/{id}")
    public CustomerFileDTO getCustomerById(@PathVariable String id) {
        String fileDownloadUri = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/customers/files/")
                .path(id)
                .toUriString();
        Customer customer = customerService.getCustomerById(id);

        return new CustomerFileDTO(customer.getFirstName(), customer.getLastName(), customer.getDateOfBirth(),
                customer.getAddress(), customer.getStatus(), customer.getUserName(), customer.getEmail(), fileDownloadUri);
    }

    @PostMapping
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Page<Customer> searchCustomerPerPage(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                                @RequestParam(name = "size", defaultValue = "10") Integer sizePerPage,
                                                @RequestParam(name = "sortBy", defaultValue = "firstName") String sortBy,
                                                @RequestParam(name = "direction", defaultValue = "ASC") String direction,
                                                @RequestParam(name = "firstName", required = false) String firstName,
                                                @RequestParam(name = "email", required = false) String email,
                                                @RequestParam(name = "address", required = false) String address,
                                                @RequestParam(name = "dateOfBirth", required = false) Date dateOfBirth) {
        if (sortBy != null) {
            Sort sort = Sort.by(Sort.Direction.fromString(direction), sortBy);
            Pageable pageable = PageRequest.of(page, sizePerPage, sort);
            CustomerSearchDTO customerSearchDTO = new CustomerSearchDTO(firstName, email, address, dateOfBirth);
            return customerService.getCustomerPerPage(pageable, customerSearchDTO);
        } else {
            Pageable pageable = PageRequest.of(page, sizePerPage);
            CustomerSearchDTO customerSearchDTO = new CustomerSearchDTO(firstName, email, address, dateOfBirth);
            return customerService.getCustomerPerPage(pageable, customerSearchDTO);
        }

    }

    @GetMapping("/cust")
    public void coba(@RequestParam String[] names) {
        for (String name :
                names) {
            System.out.println(name);
        }
    }

//    @GetMapping("/customers")
//    public List<Customer> searchCustomerByName(@RequestParam(name = "name", defaultValue = "") String name,
//                                               @RequestParam(name = "email", defaultValue = "") String email){
//        return customerService.getCustomerByName(name, email);
//    }

//    @GetMapping("/customers")
//    public List<Customer> searchCustomerByName(){
//        return customerService.sortAsc();
//    }

//    @PutMapping
//    public Customer editCustomer(@RequestPart(name = "picture", required = false) MultipartFile file,
//                                 @RequestParam(name = "id") String id,
//                                 @RequestParam(name = "firstName") String firstName,
//                                 @RequestParam(name = "lastName") String lastName,
//                                 @RequestParam(name = "dateOfBirth") Date dateOfBirth,
//                                 @RequestParam(name = "address") String address,
//                                 @RequestParam(name = "status") Integer status,
//                                 @RequestParam(name = "userName") String userName,
//                                 @RequestParam(name = "email") String email) {
//        System.out.println("ini firstname: " + firstName);
//
//        Customer customer = new Customer(id, firstName, lastName, dateOfBirth, address, status, userName, email);
//
//        return customerService.editCustomer(customer, file);
//    }

    @PutMapping()
    public ResponseEntity<MessageResponse> editCustomer(@RequestParam(name = "photoProfile", required = false) MultipartFile photoProfile,
                                                        @RequestParam(name = "id") String id,
                                                        @RequestParam(name = "firstName") String firstName,
                                                        @RequestParam(name = "lastName") String lastName,
                                                        @RequestParam(name = "dateOfBirth") Date dateOfBirth,
                                                        @RequestParam(name = "address") String address,
                                                        @RequestParam(name = "status") Integer status,
                                                        @RequestParam(name = "userName") String userName,
                                                        @RequestParam(name = "email") String email) {
        String message = "";
        try {
            customerService.uploadProfile(id, photoProfile, firstName, lastName, dateOfBirth, address, status, userName, email);
            message = "Uploaded succeccfully " + photoProfile.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
        }catch (Exception e){
            message = "Could not upload file "+ photoProfile.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
        }
    }


    @DeleteMapping
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteCustomer(@RequestParam(name = "id") String id) {
        customerService.deleteCustomer(id);
    }


    @PutMapping("/photo")
    public void saveProfilePhoto(@RequestPart(name = "picture", required = false) MultipartFile file) {
        customerService.uploadFoto(file);
    }

    @GetMapping("/photo")
    public String getPhoto() {
        String fileDownloadUri = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("src/image/download.png/donwload.png.png")
                .toUriString();

        return fileDownloadUri;
    }

    @GetMapping("/password/{id}")
    public String getPw(@PathVariable String id){
       return customerService.getPassword(id);
    }

    @GetMapping("/files/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable String id){
        Customer fileDB = customerService.getCustomerById(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+ fileDB.getPhotoProfile() + "\"")
                .body(fileDB.getPhotoData());
    }

}
