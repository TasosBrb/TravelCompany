package com.travelcompany.eshop.repository;

import com.travelcompany.eshop.model.OrderedTickets;
import java.util.List;

/**
 *
 * Interface for the Repository of Ordered Tickets
 */
public interface OrderedTicketsRepository extends Repository<OrderedTickets> {

    List<OrderedTickets> read(String orderedTicketName);

}
