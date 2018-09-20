package com.solstice.cloud.domain;

import java.util.List;

public class OrderSummary {

    private Long orderNumber;
    private AddressResult addressResults;
    private double totalPrice;
    private List<OrderLineItems> orderLineList;

    public OrderSummary() {
    }

    public OrderSummary(Long orderNumber, AddressResult addressResults, double totalPrice, List<OrderLineItems> orderLineList) {
        this.orderNumber = orderNumber;
        this.addressResults = addressResults;
        this.totalPrice = totalPrice;
        this.orderLineList = orderLineList;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public AddressResult getAddressResults() {
        return addressResults;
    }

    public void setAddressResults(AddressResult addressResults) {
        this.addressResults = addressResults;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<OrderLineItems> getOrderLineList() {
        return orderLineList;
    }

    public void setOrderLineList(List<OrderLineItems> orderLineList) {
        this.orderLineList = orderLineList;
    }
}