/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.util;

import com.travelcompany.eshop.repository.CustomerRepository;
import com.travelcompany.eshop.repository.ItineraryRepository;

/**
 *
 * @author User
 */
public class DataImport {

    private final CustomerRepository customerRepository;
    private final ItineraryRepository itineraryRepository;

    public DataImport(CustomerRepository customerRepository, ItineraryRepository itineraryRepository) {
        this.customerRepository = customerRepository;
        this.itineraryRepository = itineraryRepository;
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
        "1, ATH, PAR, 2022-02-22 13:35, SkyLines, 300",
        "2, ATH, LON, 2022-02-22 13:40, SkyLines, 420",
        "3, ATH, AMS, 2022-02-22 13:45, SkyLines, 280",
        "4, ATH, PAR, 2022-02-22 14:20, SkyLines, 310",
        "5, ATH, DUB, 2022-02-22 14:35, SkyLines, 880",
        "6, ATH, FRA, 2022-02-22 14:55, SkyLines, 380",
        "7, ATH, FRA, 2022-02-22 15:35, SkyLines, 350",
        "8, ATH, MEX, 2022-02-22 16:00, SkyLines, 1020",
        "9, ATH, DUB, 2022-02-22 16:35, SkyLines, 770"
    };

}
