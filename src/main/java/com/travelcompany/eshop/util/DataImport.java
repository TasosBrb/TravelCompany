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
        "1, Maria Iordanou, miordanou@mail.com, Athens, Greek, INDIVIDUAL",
        "2, Dimitrios Dimitriou, ddimitriou@mail.com, Athens, Greek, INDIVIDUAL",
        "3, Ioannis Ioannou, iioannou@mail.com, Athens, Greek, BUSINESS",
        "4, Antonio Molinari, amolinari@mail.com, Milan, Italian, INDIVIDUAL",
        "5, Frederico Rossi, frossi@mail.com, Milan, Itlian, INDIVIDUAL",
        "6, Mario Conti, mconti@mail.com, Rome, Italian, BUSINESS",
        "7, Nathan Martin, nmartin@mail.com, Lyon, French, BUSINESS",
        "8, Enzo Colin, ecolin@mail.com, Lyon, French, INDIVIDUAL",
        "9, Frederic Michel, fmichel@mail.com, Athens, French, INDIVIDUAL"
    };

    private final static String[] ITINERARIES = {
        "1, ATH, PAR, 2022-02-22-13-35, SkyLines, 300.0",
        "2, ATH, LON, 2022-02-22-13-40, SkyLines, 420.0",
        "3, ATH, AMS, 2022-02-22-13-45, SkyLines, 280.0",
        "4, ATH, PAR, 2022-02-22-14-20, SkyLines, 310.0",
        "5, ATH, DUB, 2022-02-22-14-35, SkyLines, 880.0",
        "6, ATH, FRA, 2022-02-22-14-55, SkyLines, 380.0",
        "7, ATH, FRA, 2022-02-22-15-35, SkyLines, 350.0",
        "8, ATH, MEX, 2022-02-22-16-00, SkyLines, 1020.0",
        "9, ATH, DUB, 2022-02-22-16-35, SkyLines, 770.0"
    };
    
    private final static String[] ORDERED_TICKETS = {
        "1,1,2, CASH",
        "2,2,3, CASH",
        "3,3,3, CREDIT_CARD",
        "4,2,4, CREDIT_CARD",
        "5,3,4, CASH",
        "6,4,7, CREDIT_CARD",
        "7,5,7, CREDIT_CARD",
        "8,2,10, CASH",
        "9,1,3, CASH"
        
    };
    
    public void insertCustomers(){
        for (String customerString : CUSTOMERS){
            try{
                String[] words = customerString.split(",");
                Customer customer = new Customer();
                customer.setId(Integer.parseInt(words[0]));
                customer.setName(words[1].trim());
                customer.setEmail(words[2].trim());
                customer.setAddress(words[3].trim());
                customer.setNationality(words[4].trim());
                customer.setCustomerCategory(CustomerCategory.valueOf(words[5].trim())); 
                customerRepository.create(customer);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
    public void insertItineraries(){
        try{
            for(String itinerarisString : ITINERARIES){
                String[] words = itinerarisString.split(",");
                Itineraries itinerary = new Itineraries();
                itinerary.setId(Integer.parseInt(words[0]));
                itinerary.setDepartAirportCode(words[1].trim());
                itinerary.setDestAirportCode(words[2].trim());
                String[] dateParts = words[3].trim().split("-");
                itinerary.setDepartDate(new Date(
                        Integer.parseInt(dateParts[0]) - 1900,
                        Integer.parseInt(dateParts[1]) - 1,
                        Integer.parseInt(dateParts[2]),
                        Integer.parseInt(dateParts[3]),
                        Integer.parseInt(dateParts[4])
                ));
                itinerary.setAirline(words[4].trim());
                itinerary.setBasicPrice(Double.parseDouble(words[5]));
                itineraryRepository.create(itinerary);
            }
        } 
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    
    public void insertOrederedTickets(){
        try{
            for (String orderdTicketsString : ORDERED_TICKETS){
                String[] words = orderdTicketsString.split(",");
                OrderedTickets tickets = new OrderedTickets();
                tickets.setId(Integer.parseInt(words[0]));
                tickets.setCustomerId(Integer.parseInt(words[1]));
                tickets.setItineraryId(Integer.parseInt(words[2]));
                tickets.setPaymentMethod(PaymentMethod.valueOf(words[3].trim()));
                orderedTicketRepository.create(tickets);

            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
