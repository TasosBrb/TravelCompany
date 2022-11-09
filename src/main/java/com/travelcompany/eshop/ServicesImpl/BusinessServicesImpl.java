/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.ServicesImpl;

import com.travelcompany.eshop.Services.BusinessServices;
import com.travelcompany.eshop.enums.CustomerCategory;
import com.travelcompany.eshop.enums.PaymentMethod;
import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.Itineraries;
import com.travelcompany.eshop.model.OrderedTickets;
import com.travelcompany.eshop.repository.CustomerRepository;
import com.travelcompany.eshop.repository.ItineraryRepository;
import com.travelcompany.eshop.repository.OrderedTicketsRepository;
import java.util.List;

/**
 *
 * @author User
 */
public class BusinessServicesImpl implements BusinessServices {

    private final CustomerRepository customerRepository;
    private final ItineraryRepository itineraryRepository;
    private final OrderedTicketsRepository orderedTicketsRepository;

    public BusinessServicesImpl(CustomerRepository customerRepository, ItineraryRepository itineraryRepository, OrderedTicketsRepository orderedTicketsRepository) {
        this.customerRepository = customerRepository;
        this.itineraryRepository = itineraryRepository;
        this.orderedTicketsRepository = orderedTicketsRepository;
    }

    @Override
    public void discountCalculation() {
        Customer customer = new Customer();
        OrderedTickets orderedTickets = new OrderedTickets();
        Itineraries itineraries = new Itineraries();

       

    
    }

}
