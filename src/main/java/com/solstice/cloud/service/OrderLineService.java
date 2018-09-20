package com.solstice.cloud.service;

import com.solstice.cloud.domain.*;
import com.solstice.cloud.repo.OrderLineRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderLineService {

    Logger logger = LoggerFactory.getLogger("OrderLineService");

    @Autowired AccountService accountService;

    OrderLineRepository orderLineRepository;

    public OrderLineService(OrderLineRepository orderLineRepository) {
        super();
        this.orderLineRepository = orderLineRepository;
    }

    public OrderLine save(OrderLine orderLine) {
        if(orderLine.getOrders() == null) {
            logger.info("Order is null");
        } else {
            logger.info("Order is not null");
        }
        OrderLine orderLineSaved = orderLineRepository.save(orderLine);
        return orderLineSaved;
    }

    public Iterable<OrderLine> findAllOrderLine() {
        return orderLineRepository.findAll();
    }

    public Optional<OrderLine> getOrderLine(Long orderLineId) {
        return orderLineRepository.findById(orderLineId);
    }

    public OrderLine addOrderLine(OrderLine orderLine) {
        return orderLineRepository.save(orderLine);
    }

    public OrderLine updateOrderLine(Long orderLineId, OrderLine orderLine) {
        return orderLineRepository.save(orderLine);
    }

    public void deleteOrderLine(Long orderLineId) {
        orderLineRepository.deleteById(orderLineId);
    }

    public AccountResult getAccount(Long accountId) {
        return accountService.getAccount(accountId);
    }

    public AddressResult getAddress(Long addressId) {
        return accountService.listAccountAddress(addressId);
    }


    public Long getOrderLineItemsForOrder(Long orderLineId) {
        return orderLineRepository.getOrdersIdIdByOrderLineId(orderLineId);
    }

}
