/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.repository.impl;

import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.repository.CustomerRepository;

/**
 *
 * @author User
 */
public class CustomerRepositoryImpl extends RepositoryImpl<Customer> implements CustomerRepository {

    @Override
    public void updateAll(int customerId, Customer newData) {
        Customer customer = read(customerId);
        if (customer != null) {
            customer.setName(newData.getName());
            customer.setEmail(newData.getEmail());
            customer.setAddress(newData.getAddress());
            customer.setNationality(newData.getNationality());
            customer.setCustomerCategory(newData.getCustomerCategory());
        }
    }

}
