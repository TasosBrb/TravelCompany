/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.travelcompany.eshop;

import com.travelcompany.eshop.Services.BusinessServices;
import com.travelcompany.eshop.ServicesImpl.BusinessServicesImpl;
import com.travelcompany.eshop.enums.CustomerCategory;
import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.OrderedTickets;
import com.travelcompany.eshop.repository.CustomerRepository;
import com.travelcompany.eshop.repository.ItineraryRepository;
import com.travelcompany.eshop.repository.OrderedTicketsRepository;
import com.travelcompany.eshop.repository.impl.CustomerRepositoryImpl;
import com.travelcompany.eshop.repository.impl.ItineraryRepositoryImpl;
import com.travelcompany.eshop.repository.impl.OrderedTicketsRepositoryImpl;
import com.travelcompany.eshop.util.DataImport;
import java.util.List;

/**
 *
 * @author User
 */
public class TravelCompany {

    public static void main(String[] args) {
        CustomerRepository custRepo = new CustomerRepositoryImpl();
        ItineraryRepository itinRepo = new ItineraryRepositoryImpl();
        OrderedTicketsRepository ticketRepo = new OrderedTicketsRepositoryImpl();
        
        DataImport dataImport = new DataImport(custRepo, itinRepo, ticketRepo);
        
        dataImport.insertCustomers();
        dataImport.insertItineraries();
        dataImport.insertOrederedTickets();
        
        BusinessServices businessServices = new BusinessServicesImpl(custRepo, itinRepo, ticketRepo);
        businessServices.discountCalculation();
        List<Customer> customers = custRepo.read();  
        for (Customer customer : customers){
            System.out.println(
                        customer.getId()
                        + "," + customer.getName()
                        + "," + customer.getAddress()
                        + "," + customer.getEmail()
                        + "," + customer.getNationality()
                        + "," + customer.getCustomerCategory()
                    
            );
        }

            
    }
}
