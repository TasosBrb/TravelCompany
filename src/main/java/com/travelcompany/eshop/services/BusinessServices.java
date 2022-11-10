/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.services;

import com.travelcompany.eshop.exceptions.CustomerException;
import com.travelcompany.eshop.exceptions.ItinerariesException;
import com.travelcompany.eshop.exceptions.OrderedTicketsException;
import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.Itineraries;
import com.travelcompany.eshop.model.OrderedTickets;

/**
 *
 * @author User
 */
public interface BusinessServices {

    void CustomerRegister(Customer customer) throws CustomerException;

    void ItineraryRegister(Itineraries itineraries) throws ItinerariesException;
    
    void OrderedTicketRegister(OrderedTickets ticket) throws OrderedTicketsException;

    double discountCalculation(double initialPaymentAmount, OrderedTickets orderedTickets, Customer customer);
    
    double allTicketsCostAfterDiscount();
    
    int totalNumberOfOrderedTickets();
    
    

}
