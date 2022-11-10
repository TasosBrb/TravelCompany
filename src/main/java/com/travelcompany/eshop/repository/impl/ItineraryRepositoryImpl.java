/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.repository.impl;

import com.travelcompany.eshop.model.Itineraries;
import com.travelcompany.eshop.repository.ItineraryRepository;
import java.util.ArrayList;
import java.util.List;


public class ItineraryRepositoryImpl extends RepositoryImpl<Itineraries> implements ItineraryRepository {

    @Override
    public List<Itineraries> read(String itinerary) {
        List<Itineraries> itineraries = new ArrayList<>();
        return itineraries;

    }

    @Override
    public void update(int itineraryId, double price) {
       Itineraries itinerary =  read(itineraryId);
        if(itinerary !=null){
            itinerary.setBasicPrice(price);
        }
    }
}


