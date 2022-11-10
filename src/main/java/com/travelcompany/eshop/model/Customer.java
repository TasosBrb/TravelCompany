/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.model;

import com.travelcompany.eshop.enums.CustomerCategory;

/**
 *
 * @author User
 */
public class Customer extends PersistentClass {

    private String name;
    private String email;
    private String address;
    private String nationality;
    private CustomerCategory customerCategory;

    public Customer() {
    }

    public Customer(String name, String email, String address, String nationality) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public CustomerCategory getCustomerCategory() {
        return customerCategory;
    }

    public void setCustomerCategory(CustomerCategory customerCategory) {
        this.customerCategory = customerCategory;
    }

}
