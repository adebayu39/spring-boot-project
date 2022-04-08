package com.miniproject.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import java.util.Date;

public class CustomerFileDTO {
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String address;
    private Integer status;
    private String userName;
    private String userPassword;
    private String email;
    private String photoProfile;

    public CustomerFileDTO(String firstName, String lastName, Date dateOfBirth, String address, Integer status, String userName, String userPassword, String email, String photoProfile) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.status = status;
        this.userName = userName;
        this.userPassword = userPassword;
        this.email = email;
        this.photoProfile = photoProfile;
    }
    public CustomerFileDTO(String firstName, String lastName, Date dateOfBirth, String address, Integer status, String userName,String email, String photoProfile) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.status = status;
        this.userName = userName;
        this.email = email;
        this.photoProfile = photoProfile;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhotoProfile() {
        return photoProfile;
    }

    public void setPhotoProfile(String photoProfile) {
        this.photoProfile = photoProfile;
    }
}
