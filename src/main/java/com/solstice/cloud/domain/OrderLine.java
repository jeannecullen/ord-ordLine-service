package com.solstice.cloud.domain;

import javax.persistence.*;

@Entity
public class OrderLine {

    @Id
    @GeneratedValue
    private Long orderLineId;
    private Long productResultId;
    private int quantity;
    private double price;
    @Transient
    private double totalPriceOrderLine;
    @ManyToOne
    private Orders orders;
    private Long shipmentId;

    public OrderLine() { super(); }

    public OrderLine(Long orderLineId, Long productResultId, int quantity, double price, double totalPriceOrderLine, Orders orders, Long shipmentId) {
        this.orderLineId = orderLineId;
        this.productResultId = productResultId;
        this.quantity = quantity;
        this.price = price;
        this.totalPriceOrderLine = totalPriceOrderLine;
        this.orders = orders;
        this.shipmentId = shipmentId;
    }

    public Long getOrderLineId() {
        return orderLineId;
    }

    public void setOrderLineId(Long orderLineId) {
        this.orderLineId = orderLineId;
    }

    public Long getProductResultId() {
        return productResultId;
    }

    public void setProductResultId(Long productResultId) {
        this.productResultId = productResultId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPriceOrderLine() {
        return totalPriceOrderLine;
    }

    public void setTotalPriceOrderLine(double totalPriceOrderLine) {
        this.totalPriceOrderLine = totalPriceOrderLine;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Long getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(Long shipmentId) {
        this.shipmentId = shipmentId;
    }
}
