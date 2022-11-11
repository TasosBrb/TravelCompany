package com.travelcompany.eshop.repository.impl;

import com.travelcompany.eshop.model.OrderedTickets;
import com.travelcompany.eshop.repository.OrderedTicketsRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Implemetns the OrderedTicketsRepository Interface methods
 */
public class OrderedTicketsRepositoryImpl extends RepositoryImpl<OrderedTickets> implements OrderedTicketsRepository {

    @Override
    public List<OrderedTickets> read(String orderedTicket) {
        List<OrderedTickets> ticket = new ArrayList<>();
        return ticket;
    }

}
