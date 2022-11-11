package com.travelcompany.eshop.repository.impl;

import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.repository.CustomerRepository;

/**
 *
 * Implemetns the CustomerRepository Interface methods
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
