/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.travelcompany.eshop;

import com.travelcompany.eshop.repository.CustomerRepository;
import com.travelcompany.eshop.repository.ItineraryRepository;
import com.travelcompany.eshop.repository.OrderedTicketsRepository;
import com.travelcompany.eshop.repository.impl.CustomerRepositoryImpl;
import com.travelcompany.eshop.repository.impl.ItineraryRepositoryImpl;
import com.travelcompany.eshop.repository.impl.OrderedTicketsRepositoryImpl;
import com.travelcompany.eshop.util.DataImport;

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
    }
}
