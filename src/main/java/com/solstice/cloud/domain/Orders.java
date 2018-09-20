package com.solstice.cloud.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Orders {

    @Id
    @GeneratedValue
    private Long ordersId;
    private Long accountId;
    private int orderNumber;
    private Timestamp orderDate;
    @OneToMany
    @JoinColumn(name="ordersId")
    List<OrderLine> orderLineItems;
    private Long addressId;
    @Transient
    private double totalPriceOrder;

    public Orders() {
    }

    public Orders(Long ordersId, Long accountId, int orderNumber, Timestamp orderDate, List<OrderLine> orderLineItems,  Long addressId, double totalPriceOrder) {
        this.ordersId = ordersId;
        this.accountId = accountId;
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.orderLineItems = orderLineItems;
        this.addressId = addressId;
        this.totalPriceOrder = totalPriceOrder;
    }

    public Long getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(Long ordersId) {
        this.ordersId = ordersId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public double getTotalPriceOrder() {
        return totalPriceOrder;
    }

    public void setTotalPriceOrder(double totalPriceOrder) {
        this.totalPriceOrder = totalPriceOrder;
    }

    public List<OrderLine> getOrderLineItems() {
        return orderLineItems;
    }

    public void setOrderLineItems(List<OrderLine> orderLineItems) {
        this.orderLineItems = orderLineItems;
    }
}
