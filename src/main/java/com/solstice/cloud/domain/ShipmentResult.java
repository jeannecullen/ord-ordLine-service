package com.solstice.cloud.domain;

import java.sql.Timestamp;

public class ShipmentResult {

    private Long shipmentId;
    private Long accountResultId;
    private Long addressResultId;
    private Long orderLineId;
    private Timestamp shipDate;
    private Timestamp deliverDate;

    public ShipmentResult() {}

    public ShipmentResult(Long shipmentId, Long accountResultId, Long addressResultId, Long orderLineId, Timestamp shipDate, Timestamp deliverDate) {
        this.shipmentId = shipmentId;
        this.accountResultId = accountResultId;
        this.addressResultId = addressResultId;
        this.orderLineId = orderLineId;
        this.shipDate = shipDate;
        this.deliverDate = deliverDate;
    }

    public Long getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(Long shipmentId) {
        this.shipmentId = shipmentId;
    }

    public Long getAccountResultId() {
        return accountResultId;
    }

    public void setAccountResultId(Long accountResultId) {
        this.accountResultId = accountResultId;
    }

    public Long getAddressResultId() {
        return addressResultId;
    }

    public void setAddressResultId(Long addressResultId) {
        this.addressResultId = addressResultId;
    }

    public Long getOrderLineId() {
        return orderLineId;
    }

    public void setOrderLineId(Long orderLineId) {
        this.orderLineId = orderLineId;
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
