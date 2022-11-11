package com.travelcompany.eshop.repository;

import com.travelcompany.eshop.model.Itineraries;
import java.util.List;

/**
 *
 * Interface for the Repository of itineraries
 */
public interface ItineraryRepository extends Repository<Itineraries> {

    List<Itineraries> read(String itineraryName);

    void update(int itineraryId, double price);

}
