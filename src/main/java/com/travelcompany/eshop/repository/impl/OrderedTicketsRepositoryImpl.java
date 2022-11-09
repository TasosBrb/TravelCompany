/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.repository.impl;

import com.travelcompany.eshop.model.OrderedTickets;
import com.travelcompany.eshop.repository.OrderedTicketsRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class OrderedTicketsRepositoryImpl extends RepositoryImpl<OrderedTickets> implements OrderedTicketsRepository{

    @Override
    public List<OrderedTickets> read(String orderedTicket) {
      List<OrderedTickets> ticket = new ArrayList<>();  
      return ticket;
    }
    
}
