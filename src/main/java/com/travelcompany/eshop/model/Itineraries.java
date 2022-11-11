package com.travelcompany.eshop.model;

/**
 *
 * Class for handling itineraries
 */
public class Itineraries extends PersistentClass {

    private String departAirportCode;
    private String destAirportCode;
    private String departDate;
    private String airline;
    private double basicPrice;

    public Itineraries() {
    }

    public Itineraries(String departAirportCode, String destAirportCode, String departDate, String airline, double basicPrice) {
        this.departAirportCode = departAirportCode;
        this.destAirportCode = destAirportCode;
        this.departDate = departDate;
        this.airline = airline;
        this.basicPrice = basicPrice;
    }

    public String getDepartAirportCode() {
        return departAirportCode;
    }

    public void setDepartAirportCode(String departAirportCode) {
        this.departAirportCode = departAirportCode;
    }

    public String getDestAirportCode() {
        return destAirportCode;
    }

    public void setDestAirportCode(String destAirportCode) {
        this.destAirportCode = destAirportCode;
    }

    public String getDepartDate() {
        return departDate;
    }

    public void setDepartDate(String departDate) {
        this.departDate = departDate;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String Airline) {
        this.airline = Airline;
    }

    public double getBasicPrice() {
        return basicPrice;
    }

    public void setBasicPrice(double basicPrice) {
        this.basicPrice = basicPrice;
    }

    @Override
    public String toString() {
        return "Itineraries{" + "departAirportCode=" + departAirportCode + ", destAirportCode=" + destAirportCode + ", departDate=" + departDate + ", airline=" + airline + ", basicPrice=" + basicPrice + '}';
    }

}
