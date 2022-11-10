/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.services;

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
    public void CustomerRegister(Customer customer) throws CustomerException {
        if (customer.getEmail().contains("travelcompany")) {
            throw new CustomerException(ExceptionsCodes.CUSTOMER_EMAIL_NOT_VALID);
        }
    }

    @Override
    public void ItineraryRegister(Itineraries itineraries) throws ItinerariesException {
        if ((itineraries.getDepartAirportCode() == null) && (itineraries.getDestAirportCode() == null)) {
            throw new ItinerariesException(ExceptionsCodes.AIRPORT_CODE_IS_NOT_EXISTING);
        }
    }

    @Override
    public void OrderedTicketRegister(OrderedTickets ticket) throws OrderedTicketsException {
        if ((ticket.getItineraryId() >= 10 || ticket.getItineraryId() < 0)
                && (ticket.getCustomerId() >= 10 || ticket.getCustomerId() < 0)) {
            throw new OrderedTicketsException(ExceptionsCodes.ITINERARY_AND_CUSTOMER_DOES_NOT_EXIST);
        }

    }

    @Override
    public double discountCalculation(double initialPaymentAmount, OrderedTickets orderedTickets, Customer customer) {
        double discount;
        //Αll discounts apply only to customers who have made purchases with a Credit Card
        if (orderedTickets.getPaymentMethod().toString() == "CREDIT_CARD") {
            if (customer.getCustomerCategory().toString() == "INDIVIDUAL") {
                //20% surcharge as individual - 10% discount from the Credit Card = 10% surcharge
                discount = initialPaymentAmount * 0.10;
                return initialPaymentAmount + discount;
            } else if (customer.getCustomerCategory().toString() == "BUSINESS") {
                // 10% discount as Business + 10% discount from the Credit Card = 20%
                discount = initialPaymentAmount * 0.20;
                return initialPaymentAmount - discount;
            }
        }
        return 0;
    }

    @Override
    public double allTicketsCostAfterDiscount() {
        double totalSum = 0;

        List<Customer> customers = customerRepository.read();
        List<OrderedTickets> orderedTickets = orderedTicketsRepository.read();

        for (OrderedTickets ticket : orderedTickets) {
            for (Customer customer : customers) {
                if (ticket.getCustomerId() == customer.getId()) {
                    totalSum = totalSum + discountCalculation(ticket.getPaymentAmount(), ticket, customer);
                }
            }
        }
        return totalSum;

    }

    @Override
    public int totalNumberOfOrderedTickets() {
        
        List<OrderedTickets> orderedTickets = orderedTicketsRepository.read();
        int sum = 0;
        for (int i = 0; i < orderedTickets.size(); i++) {
            sum++;
        }
        return sum;
    }

}
