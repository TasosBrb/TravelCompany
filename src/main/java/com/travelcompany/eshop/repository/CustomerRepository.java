package com.travelcompany.eshop.repository;

import com.travelcompany.eshop.model.Customer;

/**
 *
 * Interface for the Repository of Customerss
 */
public interface CustomerRepository extends Repository<Customer> {

    void updateAll(int customerId, Customer newData);

}
