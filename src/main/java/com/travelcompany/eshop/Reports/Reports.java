package com.travelcompany.eshop.Reports;

import com.travelcompany.eshop.enums.CustomerCategory;
import com.travelcompany.eshop.enums.PaymentMethod;
import com.travelcompany.eshop.exceptions.CustomerException;
import com.travelcompany.eshop.exceptions.ItinerariesException;
import com.travelcompany.eshop.exceptions.OrderedTicketsException;
import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.Itineraries;
import com.travelcompany.eshop.model.OrderedTickets;
import com.travelcompany.eshop.repository.CustomerRepository;
import com.travelcompany.eshop.repository.ItineraryRepository;
import com.travelcompany.eshop.repository.OrderedTicketsRepository;
import com.travelcompany.eshop.repository.impl.CustomerRepositoryImpl;
import com.travelcompany.eshop.repository.impl.ItineraryRepositoryImpl;
import com.travelcompany.eshop.repository.impl.OrderedTicketsRepositoryImpl;
import com.travelcompany.eshop.services.BusinessServices;
import com.travelcompany.eshop.services.BusinessServicesImpl;
import com.travelcompany.eshop.util.DataImport;
import java.util.Scanner;

/**
 *
 * Pirnts a Menu where the user can have access to the reports
 */
public class Reports {

    CustomerRepository customerRepository = new CustomerRepositoryImpl();
    OrderedTicketsRepository orderedTicketsRepository = new OrderedTicketsRepositoryImpl();
    ItineraryRepository itineraryRepository = new ItineraryRepositoryImpl();
    DataImport dataImport = new DataImport(customerRepository, itineraryRepository, orderedTicketsRepository);
    BusinessServices service = new BusinessServicesImpl(customerRepository, itineraryRepository, orderedTicketsRepository);

    /**
     * Creates the Menu of the reports
     */
    public void menu() {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("Please select an option (1 - 6) from the table below : ");
        System.out.println("1 --> The list of the total number and list of the cost of tickets for all customers (discounts included) : ");
        System.out.println("2 --> List of the total offered itineraries (no discounts) : ");
        System.out.println("3 --> List of the customers with the most tickets and with the largest cost of purchases : ");
        System.out.println("4 --> List of the customers who have not purchased any tickets : ");
        System.out.println("5 --> The Custome Exceptions as requested");
        System.out.println("6 --> Exit the program");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("");
    }

    /**
     * Handles the choices of the report menu
     */
    public void reportChoices() {
        dataImport.insertCustomers();
        dataImport.insertOrederedTickets();
        dataImport.insertItineraries();
        Scanner scaner = new Scanner(System.in);

        System.out.println("!!!___Welcome to Travel Company___!!!");

        menu();
        int option = scaner.nextInt();

        while (option != 6) {
            if (option == 1) {
                System.out.println("Total Number of ticket : " + service.totalNumberOfOrderedTickets());
                System.out.println("Total cost of all tickets : " + service.allTicketsCostAfterDiscount());
                System.out.println("");
                menu();
                option = scaner.nextInt();
            } else if (option == 2) {
                System.out.println("List of the total offered itineraries (no discounts) : ");
                service.itinerariesPerAirportCode();
                System.out.println("");
                menu();
                option = scaner.nextInt();
            } else if (option == 3) {
                service.mostTicketsAndMaxCostCustomer();
                System.out.println("");
                menu();
                option = scaner.nextInt();
            } else if (option == 4) {
                System.out.println("The customers who have not purchased any tickets are: ");
                service.customersWhithNoTicket();
                System.out.println("");
                menu();
                option = scaner.nextInt();
            } else if (option == 5) {
                customException();
                System.out.println("");
                menu();
                option = scaner.nextInt();
            } else {
                System.out.println("Invalid input. Please try again");
                System.out.println("");
                menu();
                option = scaner.nextInt();
            }
        }

    }

    /**
     * Creates the requested Custom Exceptions
     */
    public void customException() {
        try {
            Customer customer = new Customer("Giorgos Papadopoulos", "georgepap@travelcompany.com", "Athens", "Greek", CustomerCategory.BUSINESS);
            service.customerRegister(customer);
        } catch (CustomerException e) {
            System.out.println(e.getMessage());
        }
        try {
            Itineraries itinerary = new Itineraries(null, null, "2022-11-11-13-30", "Skylines", 230.00);
            service.itineraryRegister(itinerary);
        } catch (ItinerariesException e) {
            System.out.println(e.getMessage());
        }
        try {
            OrderedTickets ticket = new OrderedTickets(12, 12, PaymentMethod.CASH, 280.00);
            service.orderedTicketRegister(ticket);
        } catch (OrderedTicketsException e) {
            System.out.println(e.getMessage());
        }

    }

}
