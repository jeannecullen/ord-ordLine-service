package com.solstice.cloud.Controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.solstice.cloud.domain.*;
import com.solstice.cloud.repo.OrdersRepository;
import com.solstice.cloud.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    Logger logger = LoggerFactory.getLogger("OrderLineController");

    @Autowired OrdersRepository ordersRepository;
    @Autowired OrderLineService orderLineService;
    @Autowired OrdersService ordersService;

    public OrdersController(OrdersRepository ordersRepository, OrderLineService orderLineService) {
        this.ordersRepository = ordersRepository;
        this.orderLineService = orderLineService;
    }

    @PostMapping()
    @HystrixCommand(fallbackMethod = "createOrderFallback")
    @ResponseBody
    public Orders createOrder(@RequestBody Orders orders) {
        return ordersService.addOrder(orders);
    }

    @PostMapping("/{ordersId}/orderLine")
    public OrderLine addOrderLineItemsToOrder(@PathVariable("ordersId") Long ordersId, @RequestBody OrderLine orderLine ) {
        return ordersService.addOrderLineItems(ordersId, orderLine);
    }

    @GetMapping("/{ordersId}")
    //@HystrixCommand(fallbackMethod = "getOrdersFallback")
    public Orders getOrders(@PathVariable("ordersId") Long ordersId) {
        Optional <Orders> ordersRetrieved = ordersService.getOrder(ordersId);
        Orders orders = ordersRetrieved.get();
        return orders;
    }

    @GetMapping()
    public Iterable<Orders> getOrders() {
        return ordersService.getAllOrders();
    }

    @GetMapping("/account/{accountId}")
    @HystrixCommand(fallbackMethod = "getOrdersForAnAccountFallback")
    public Iterable<Orders> getAllOrdersForAnAccount(@PathVariable Long accountId) {
        return ordersService.getOrdersByAccount(accountId);
    }

    @GetMapping("/orders/account/{accountId}")
    @HystrixCommand(fallbackMethod = "orderSummaryFallback")
    public OrderSummary orderSummary(@PathVariable("accountId") Long accountId) {

        Orders orders = ordersService.getOrder(accountId).get();
        AddressResult address = orderLineService.getAddress(orders.getAddressId());

        List<OrderLine> orderLine = orders.getOrderLineItems();
        List<OrderLineItems> orderLineItems = new ArrayList<>();

        for(OrderLine ol : orderLine) {

            Long productId = ol.getProductResultId();
            ProductResult product = ordersService.getProduct(productId);
            String productName = product.getProductName();

            int quantity = ol.getQuantity();

            Long shipmentId = ol.getShipmentId();
            ShipmentResult shipmentResult = ordersService.getShipment(shipmentId);

            OrderLineItems items = new OrderLineItems(productName, quantity, shipmentResult.getShipDate(), shipmentResult.getDeliverDate());
            orderLineItems.add(items);

            }

        OrderSummary summary = new OrderSummary (orders.getOrdersId(), address, orders.getTotalPriceOrder(), orderLineItems);
        return summary;
    }

    @PutMapping("/{ordersId}")
    @HystrixCommand(fallbackMethod = "updateOrdersFallback")
    public Orders changeOrder(@PathVariable Long ordersId, @RequestBody Orders orders) {
        Orders changedOrder = ordersService.updateOrder(ordersId, orders);
        logger.info("Order saved: " +changedOrder.toString());
        return orders;
    }

    @DeleteMapping("/{ordersId}")
    @HystrixCommand(fallbackMethod = "deleteFallback")
    public ResponseEntity<?> delete(@PathVariable("ordersId") Long ordersId) {
        ordersService.delete(ordersId);
        return ResponseEntity.ok().body("Order has been deleted.");
    }

    public Orders createOrderFallback(Orders orders) {
        logger.info("Error creating Order " +orders);
        return new Orders();
    }

    public Optional<Orders> getOrdersFallback(Orders ordersId) {
        logger.info("Error getting order " +ordersId);
        return Optional.of(new Orders());
    }

    public OrderSummary orderSummaryFallback(Long accountId) {
        logger.info("Error creating summary data for account " +accountId);
        return new OrderSummary();
    }

    public Orders updateOrdersFallback(Orders orders) {
        logger.info("Error updating order " +orders);
        return new Orders();
    }

    public void deleteFallback(Long ordersId) {
        logger.info("Error deleting order");
    }

}
