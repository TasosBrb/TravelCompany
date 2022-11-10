/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.util;

import com.travelcompany.eshop.enums.CustomerCategory;
import com.travelcompany.eshop.enums.PaymentMethod;
import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.Itineraries;
import com.travelcompany.eshop.model.OrderedTickets;
import com.travelcompany.eshop.repository.CustomerRepository;
import com.travelcompany.eshop.repository.ItineraryRepository;
import com.travelcompany.eshop.repository.OrderedTicketsRepository;
import java.util.Date;

/**
 *
 * @author User
 */
public class DataImport {

    private final CustomerRepository customerRepository;
    private final ItineraryRepository itineraryRepository;
    private final OrderedTicketsRepository orderedTicketRepository;

    public DataImport(CustomerRepository customerRepository, ItineraryRepository itineraryRepository, OrderedTicketsRepository orderedTicketRepository) {
        this.customerRepository = customerRepository;
        this.itineraryRepository = itineraryRepository;
        this.orderedTicketRepository = orderedTicketRepository;
    }

    private final static String[] CUSTOMERS = {
        "Maria Iordanou, miordanou@mail.com, Athens, Greek, INDIVIDUAL",
        "Dimitrios Dimitriou, ddimitriou@mail.com, Athens, Greek, INDIVIDUAL",
        "Ioannis Ioannou, iioannou@mail.com, Athens, Greek, BUSINESS",
        "Antonio Molinari, amolinari@mail.com, Milan, Italian, INDIVIDUAL",
        "Frederico Rossi, frossi@mail.com, Milan, Itlian, INDIVIDUAL",
        "Mario Conti, mconti@mail.com, Rome, Italian, BUSINESS",
        "Nathan Martin, nmartin@mail.com, Lyon, French, BUSINESS",
        "Enzo Colin, ecolin@mail.com, Lyon, French, INDIVIDUAL",
        "Frederic Michel, fmichel@mail.com, Athens, French, INDIVIDUAL"
    };

    private final static String[] ITINERARIES = {
        "ATH, PAR, 2022-02-22-13-35, SkyLines, 300",
        "ATH, LON, 2022-02-22-13-40, SkyLines, 420",
        "ATH, AMS, 2022-02-22-13-45, SkyLines, 280",
        "ATH, PAR, 2022-02-22-14-20, SkyLines, 310",
        "ATH, DUB, 2022-02-22-14-35, SkyLines, 880",
        "ATH, FRA, 2022-02-22-14-55, SkyLines, 380",
        "ATH, FRA, 2022-02-22-15-35, SkyLines, 350",
        "ATH, MEX, 2022-02-22-16-00, SkyLines, 1020",
        "ATH, DUB, 2022-02-22-16-35, SkyLines, 770"
    };
    
    private final static String[] ORDERED_TICKETS = {
        "1,2, CASH,420",
        "2,3, CASH,280",
        "3,3, CREDIT_CARD,280",
        "2,4, CREDIT_CARD,310",
        "3,4, CASH,310",
        "4,7, CREDIT_CARD,350",
        "5,7, CREDIT_CARD,350",
        "2,10, CASH,0",
        "1,3, CASH,280"
        
    };
    
    public void insertCustomers(){
         for (String customerString : CUSTOMERS){
            String[] words = customerString.split(",");
            Customer customer = new Customer();
            customer.setName(words[0].trim());
            customer.setEmail(words[1].trim());
            customer.setAddress(words[2].trim());
            customer.setNationality(words[3].trim());
            customer.setCustomerCategory(CustomerCategory.valueOf(words[4].trim()));
            customerRepository.create(customer);
        }
    }
    public void insertItineraries(){
            for (String itineraryString : ITINERARIES){
                String[] words = itineraryString.split(",");
                Itineraries itinerary = new Itineraries();
                itinerary.setDepartAirportCode(words[0].trim());
                itinerary.setDestAirportCode(words[1].trim());
                itinerary.setDepartDate(words[2].trim());
                itinerary.setAirline(words[3].trim());
                itinerary.setBasicPrice(Double.parseDouble(words[4].trim()));
                itineraryRepository.create(itinerary);
        }
         
    }
    
    
    public void insertOrederedTickets(){
            for (String ticketString: ORDERED_TICKETS){
                String[] words = ticketString.split(",");
                OrderedTickets ticket = new OrderedTickets();
                ticket.setCustomerId(Integer.parseInt(words[0].trim()));
                ticket.setItineraryId(Integer.parseInt(words[1].trim()));
                ticket.setPaymentMethod(PaymentMethod.valueOf(words[2].trim()));
                ticket.setPaymentAmount(Double.parseDouble(words[3].trim()));
                orderedTicketRepository.create(ticket);

        }
        
        
    }

}
