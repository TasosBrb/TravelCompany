package com.travelcompany.eshop.services;

import com.travelcompany.eshop.exceptions.CustomerException;
import com.travelcompany.eshop.exceptions.ItinerariesException;
import com.travelcompany.eshop.exceptions.OrderedTicketsException;
import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.Itineraries;
import com.travelcompany.eshop.model.OrderedTickets;

/**
 *
 * This interface contains all the appropriate methods needed for the services
 */
public interface BusinessServices {

    /**
     * Makes the registration of a Customer
     *
     * @param customer
     * @throws CustomerException
     */
    void customerRegister(Customer customer) throws CustomerException;

    /**
     * Makes the registration of an itinerary
     *
     * @param itineraries
     * @throws ItinerariesException
     */
    void itineraryRegister(Itineraries itineraries) throws ItinerariesException;

    /**
     * Makes the registration of an Ordered Ticket
     *
     * @param ticket
     * @throws OrderedTicketsException
     */
    void orderedTicketRegister(OrderedTickets ticket) throws OrderedTicketsException;

    /**
     * Calculates the total discount a Customer will have based on the Customer
     * Category and the Payment Method
     *
     * @param initialPaymentAmount
     * @param orderedTickets
     * @param customer
     * @return
     */
    double discountCalculation(double initialPaymentAmount, OrderedTickets orderedTickets, Customer customer);

    /**
     *
     * @return The total cost of all Ordered Tickets after the application of
     * the discount policy
     */
    double allTicketsCostAfterDiscount();

    /**
     *
     * @return The total number of tickets ordered
     */
    int totalNumberOfOrderedTickets();

    /**
     * Prints the List of the total offered itineraries per destination and
     * offered itineraries per departure
     */
    public void itinerariesPerAirportCode();

    /**
     * Prints the list of the Customer with the most tickets and the Customer
     * with the largest cost of purchases
     */
    public void mostTicketsAndMaxCostCustomer();

    /**
     * Prints the list of Customers who have not purchased any tickets
     */
    public void customersWhithNoTicket();

}
