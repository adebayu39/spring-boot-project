package com.miniproject.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "mst_customer")
public class Customer {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "customer_id")
    private String id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "date_of_birth")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    private String address;
    private Integer status;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_password")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String userPassword;
    private String email;
    private String photoProfile;
    private String photoType;
    @Lob
    private byte[] photoData;

    @OneToMany(fetch = FetchType.EAGER,
            mappedBy = "customer", orphanRemoval = true)
    private List<Pocket> pockets = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();


    public Customer() {
    }


    public Customer(String firstName, String lastName, Date dateOfBirth, String address, Integer status, String userName, String email, String userPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.status = status;
        this.userName = userName;
        this.email = email;
        this.userPassword = userPassword;
    }

    public Customer(String id, String photoProfile, String firstName, String lastName, Date dateOfBirth, String address, Integer status, String userName, String email) {
        this.id = id;
        this.photoProfile = photoProfile;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.status = status;
        this.userName = userName;
        this.email = email;
    }

    public Customer(String id, String photoProfile, String firstName, String lastName, Date dateOfBirth, String address, Integer status, String userName, String email, String photoType, byte[] photoData) {
        this.id = id;
        this.photoProfile = photoProfile;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.status = status;
        this.userName = userName;
        this.email = email;
        this.photoType = photoType;
        this.photoData = photoData;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<Pocket> getPockets() {
        return pockets;
    }

    public void setPockets(List<Pocket> balances) {
        this.pockets = balances;
    }

    public void addBalances(Pocket balance) {
        balance.setCustomer(this);
        this.pockets.add(balance);
    }

    public void removeBalance(String id) {
        this.pockets.removeIf(e -> e.getId().equals(id));
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getPhotoProfile() {
        return photoProfile;
    }

    public void setPhotoProfile(String photoProfile) {
        this.photoProfile = photoProfile;
    }

    public String getPhotoType() {
        return photoType;
    }

    public void setPhotoType(String photoType) {
        this.photoType = photoType;
    }

    public byte[] getPhotoData() {
        return photoData;
    }

    public void setPhotoData(byte[] photoData) {
        this.photoData = photoData;
    }
}
