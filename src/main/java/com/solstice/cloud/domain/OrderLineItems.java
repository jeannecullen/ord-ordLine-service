package com.solstice.cloud.domain;

import java.sql.Timestamp;

public class OrderLineItems {

    private String productName;
    private int quantity;
    private Timestamp shipDate;
    private Timestamp deliverDate;

    public OrderLineItems() {
    }

    public OrderLineItems(String productName, int quantity, Timestamp shipDate, Timestamp deliverDate) {
        this.productName = productName;
        this.quantity = quantity;
        this.shipDate = shipDate;
        this.deliverDate = deliverDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Timestamp getShipDate() {
        return shipDate;
    }

    public void setShipDate(Timestamp shipDate) {
        this.shipDate = shipDate;
    }

    public Timestamp getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(Timestamp deliverDate) {
        this.deliverDate = deliverDate;
    }
}
