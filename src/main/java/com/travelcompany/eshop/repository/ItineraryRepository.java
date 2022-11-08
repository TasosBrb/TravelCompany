/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.repository;

import com.travelcompany.eshop.model.Itineraries;

/**
 *
 * @author User
 */
public interface ItineraryRepository extends Repository<Itineraries>{
    void update(int itineararieId, double price);
    
}
