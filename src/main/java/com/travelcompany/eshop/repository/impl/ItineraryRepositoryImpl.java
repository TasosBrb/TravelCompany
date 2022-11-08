/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.repository.impl;

import com.travelcompany.eshop.model.Itineraries;
import com.travelcompany.eshop.repository.ItineraryRepository;

/**
 *
 * @author User
 */
public class ItineraryRepositoryImpl extends RepositoryImpl<Itineraries> implements ItineraryRepository{

    @Override
    public void update(int itineararieId, double price) {
        Itineraries itinerary = read(itineararieId);
        if (itinerary != null){
            itinerary.setBasicPrice(price);
        }
    }
    
}
