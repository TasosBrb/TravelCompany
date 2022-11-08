/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.repository;

import com.travelcompany.eshop.model.Customer;

/**
 *
 * @author User
 */
public interface CustomerRepository extends Repository<Customer>{
    
    void updateAll (int customerId,  Customer newData);
    
}
