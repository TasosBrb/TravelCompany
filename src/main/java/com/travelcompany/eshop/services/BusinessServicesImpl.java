/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.services;

import com.travelcompany.eshop.services.BusinessServices;
import com.travelcompany.eshop.enums.CustomerCategory;
import com.travelcompany.eshop.enums.PaymentMethod;
import com.travelcompany.eshop.exceptions.CustomerException;
import com.travelcompany.eshop.exceptions.ExceptionsCodes;
import com.travelcompany.eshop.exceptions.ItinerariesException;
import com.travelcompany.eshop.exceptions.OrderedTicketsException;
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
 
    }

    @Override
    public void CustomerRegister(Customer customer) throws CustomerException {
        if (customer.getEmail().contains("travelcompany")){
            throw new CustomerException(ExceptionsCodes.CUSTOMER_EMAIL_NOT_VALID);
        }
    }

    @Override
    public void ItineraryRegister(Itineraries itineraries) throws ItinerariesException {
        if ( (itineraries.getDepartAirportCode() == null) && (itineraries.getDestAirportCode() == null)){
            throw new ItinerariesException(ExceptionsCodes.AIRPORT_CODE_IS_NOT_EXISTING);
        }
    }

    @Override
    public void OrderedTicketRegister(OrderedTickets ticket) throws OrderedTicketsException {
        if( (ticket.getItineraryId() >= 10 || ticket.getItineraryId() < 0) && 
            (ticket.getCustomerId() >= 10 || ticket.getCustomerId() < 0)) {
                throw new OrderedTicketsException(ExceptionsCodes.ITINERARY_AND_CUSTOMER_DOES_NOT_EXIST);
        }

    }

}
