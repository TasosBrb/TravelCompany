package com.travelcompany.eshop.model;

import com.travelcompany.eshop.enums.PaymentMethod;

/**
 *
 * Class for handling the Ordered Tickets
 */
public class OrderedTickets extends PersistentClass {

    private int customerId;
    private int itineraryId;
    private PaymentMethod paymentMethod;
    private double paymentAmount;

    public OrderedTickets() {
    }

    public OrderedTickets(int customerId, int itineraryId, PaymentMethod paymentMethod, double paymentAmount) {
        this.customerId = customerId;
        this.itineraryId = itineraryId;
        this.paymentMethod = paymentMethod;
        this.paymentAmount = paymentAmount;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getItineraryId() {
        return itineraryId;
    }

    public void setItineraryId(int itineraryId) {
        this.itineraryId = itineraryId;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    @Override
    public String toString() {
        return "OrderedTickets{ " + "customerId=" + customerId + ", itineraryId=" + itineraryId + ", paymentMethod=" + paymentMethod + ", paymentAmount=" + paymentAmount + '}';
    }

}
