package com.travelcompany.eshop.services;

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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * Implements all the methods from the Business Service Interface
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
    public void customerRegister(Customer customer) throws CustomerException {
        if (customer.getEmail().contains("travelcompany")) {
            throw new CustomerException(ExceptionsCodes.CUSTOMER_EMAIL_NOT_VALID);
        }
        if (customer == null) {
            throw new CustomerException(ExceptionsCodes.CUSTOMER_INFORMATION_MISSING);
        }
        if (customer.getName() == null) {
            throw new CustomerException(ExceptionsCodes.CUSTOMER_INFORMATION_MISSING);
        }
    }

    @Override
    public void itineraryRegister(Itineraries itineraries) throws ItinerariesException {
        if ((itineraries.getDepartAirportCode() == null) && (itineraries.getDestAirportCode() == null)) {
            throw new ItinerariesException(ExceptionsCodes.AIRPORT_CODE_IS_NOT_EXISTING);
        }
    }

    @Override
    public void orderedTicketRegister(OrderedTickets ticket) throws OrderedTicketsException {
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

    @Override
    public void itinerariesPerAirportCode() {
        List<Itineraries> itinerariesDeparture = itineraryRepository.read();
        List<Itineraries> itinerariesDestination = itineraryRepository.read();

        Collections.sort(itinerariesDeparture, Comparator.comparing(Itineraries::getDepartAirportCode));
        Collections.sort(itinerariesDestination, Comparator.comparing(Itineraries::getDestAirportCode));

        String codeDepart = "";
        String codeDest = "";

        System.out.println("Based on Departure AiportCode");
        for (Itineraries itinerary : itinerariesDeparture) {
            //Printing only once the Departure Code 
            if ((codeDepart.equals(itinerary.getDepartAirportCode())) == false) {
                codeDepart = itinerary.getDepartAirportCode();
                System.out.println("The Itineraries for departure  Airport Code " + codeDepart + " are: ");
            }
            System.out.println(itinerary.getId() + " " + itinerary.getDepartAirportCode()
                    + " " + itinerary.getDestAirportCode() + " "
                    + itinerary.getAirline() + " " + itinerary.getBasicPrice());
        }

        System.out.println("--------------------------------------");
        System.out.println("Based on Destination AiportCode");
        for (Itineraries itinerary : itinerariesDestination) {
            //Printing only once the Destination Code 
            if ((codeDest.equals(itinerary.getDestAirportCode())) == false) {
                codeDest = itinerary.getDestAirportCode();
                System.out.println("The Itineraries for destination  Airport Code " + codeDest + " are: ");
            }
            System.out.println(itinerary.getId() + " " + itinerary.getDepartAirportCode()
                    + " " + itinerary.getDestAirportCode() + " "
                    + itinerary.getAirline() + " " + itinerary.getBasicPrice());
        }

    }

    @Override
    public void mostTicketsAndMaxCostCustomer() {
        List<OrderedTickets> orderedTickets = orderedTicketsRepository.read();
        List<Customer> customers = customerRepository.read();
        List<Itineraries> itinerary = itineraryRepository.read();

        int maxCount = 0;
        int maxTicketsId = 1;
        double maxSpend = 0;
        int maxSpendId = 1;
        for (Customer customer : customers) {
            int custCount = 0;
            double custSpend = 0;
            for (OrderedTickets ticket : orderedTickets) {
                if (ticket.getCustomerId() == customer.getId()) {
                    custCount++;
                    for (Itineraries itineraries : itinerary) {
                        if (ticket.getId() == itineraries.getId()) {
                            custSpend += itineraries.getBasicPrice();
                        }
                    }
                }

            }
            if (custCount > maxCount) {
                maxCount = custCount;
                maxTicketsId = customer.getId();
            }
            if (custSpend > maxSpend) {
                maxSpend = custSpend;
                maxSpendId = customer.getId();
            }
        }

        System.out.println("The customer with the most tickets is : ");
        for (Customer customer : customers) {
            if (customer.getId() == maxTicketsId) {
                System.out.println(customer.getId() + " " + customer.getName()
                        + " " + customer.getEmail() + " " + customer.getAddress()
                        + " " + customer.getNationality() + " " + customer.getCustomerCategory().toString());
            }

        }
        System.out.println("--------------------------------------");
        System.out.println("The Customer with the larges cost of purchases is : ");
        for (Customer customer : customers) {
            if (customer.getId() == maxSpendId) {
                System.out.println(customer.getId() + " " + customer.getName()
                        + " " + customer.getEmail() + " " + customer.getAddress()
                        + " " + customer.getNationality() + " " + customer.getCustomerCategory().toString());
            }

        }

    }

    @Override
    public void customersWhithNoTicket() {
        List<Customer> customers = customerRepository.read();
        List<OrderedTickets> orderedTickets = orderedTicketsRepository.read();

        for (Customer customer : customers) {
            int flag = 0;
            for (OrderedTickets ticket : orderedTickets) {
                if (ticket.getCustomerId() == customer.getId()) {
                    flag++;
                }
            }
            if (flag == 0) {
                System.out.println(customer.getId() + " " + customer.getName()
                        + " " + customer.getEmail() + " " + customer.getAddress()
                        + " " + customer.getNationality() + " " + customer.getCustomerCategory().toString());
            }
        }

    }

}
