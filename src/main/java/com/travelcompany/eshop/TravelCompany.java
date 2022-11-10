/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.travelcompany.eshop;

import com.travelcompany.eshop.Reports.Reports;


/**
 *
 * @author User
 */
public class TravelCompany {

    public static void main(String[] args) {
        
        Reports report = new Reports();
        report.finalReports();

//        BusinessServices businessServices = new BusinessServicesImpl(custRepo, itinRepo, ticketRepo);
//        businessServices.discountCalculation();
//        List<Customer> customers = custRepo.read();  
//        for (Customer customer : customers){
//            System.out.println(
//                        customer.getId()
//                        + "," + customer.getName()
//                        + "," + customer.getAddress()
//                        + "," + customer.getEmail()
//                        + "," + customer.getNationality()
//                        + "," + customer.getCustomerCategory()
//                    
//            );
//        }
    }
}
