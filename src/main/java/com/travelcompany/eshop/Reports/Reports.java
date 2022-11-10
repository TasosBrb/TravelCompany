/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.Reports;

import com.travelcompany.eshop.repository.CustomerRepository;
import com.travelcompany.eshop.repository.ItineraryRepository;
import com.travelcompany.eshop.repository.OrderedTicketsRepository;
import com.travelcompany.eshop.repository.impl.CustomerRepositoryImpl;
import com.travelcompany.eshop.repository.impl.ItineraryRepositoryImpl;
import com.travelcompany.eshop.repository.impl.OrderedTicketsRepositoryImpl;
import com.travelcompany.eshop.services.BusinessServices;
import com.travelcompany.eshop.services.BusinessServicesImpl;
import com.travelcompany.eshop.util.DataImport;

/**
 *
 * @author User
 */
public class Reports {

    CustomerRepository customerRepository = new CustomerRepositoryImpl();
    OrderedTicketsRepository orderedTicketsRepository = new OrderedTicketsRepositoryImpl();
    ItineraryRepository itineraryRepository = new ItineraryRepositoryImpl();
    DataImport dataImport = new DataImport(customerRepository, itineraryRepository, orderedTicketsRepository);
    BusinessServices service = new BusinessServicesImpl(customerRepository, itineraryRepository, orderedTicketsRepository);

    public void firstReport() {
        dataImport.insertCustomers();
        dataImport.insertOrederedTickets();
        dataImport.insertItineraries();

        System.out.println("Welcome to Travel Company ");
        System.out.println("/////////////////////////////////////////////////////////////");
        System.out.println("The list of the total number and list of the cost of tickets for all customers (discounts included)");
        System.out.println("Total Number of ticket : " + service.totalNumberOfOrderedTickets());
        System.out.println("Total cost of all tickets : " + service.allTicketsCostAfterDiscount());

        System.out.println("/////////////////////////////////////////////////////////////");

    }

    public void secondReport() {

        System.out.println("List of the total offered itineraries (no discounts) : ");
        service.itinerariesPerAirportCode();

        System.out.println("/////////////////////////////////////////////////////////////");

    }

    public void thirdReport() {

        service.mostTicketsAndMaxCostCustomer();

        System.out.println("/////////////////////////////////////////////////////////////");
    }

    public void fourthReport() {

        System.out.println("The customers who have not purchased any tickets are: ");
        service.customersWhithNoTicket();

        System.out.println("/////////////////////////////////////////////////////////////");
    }

}
