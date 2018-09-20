package com.solstice.cloud.Controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.solstice.cloud.domain.OrderLine;
import com.solstice.cloud.domain.Orders;
import com.solstice.cloud.service.OrderLineService;
import com.solstice.cloud.service.OrdersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orderline")
public class OrderLineController {

    Logger logger = LoggerFactory.getLogger("OrderLineController");

    OrderLineService orderLineService;

    public OrderLineController(OrderLineService orderLineService) {
        this.orderLineService = orderLineService;
    }

//    @PostMapping("/{ordersLineId}")
//    @HystrixCommand(fallbackMethod = "createOrderLineFallback")
//    @ResponseBody
//    public OrderLine createOrderLine(@RequestBody OrderLine orderLine, @PathVariable Orders orders) {
//        orderLine.setOrders(orders);
//        if (orderLine.getOrders() == null) {
//            logger.info("Order is null");
//        } else {
//            logger.info("Order is not null");
//        }
//        OrderLine orderLineSaved = orderLineService.save(orderLine);
//        logger.info("Order Line saved : " + orderLineSaved.toString());
//        return orderLine;
//    }

    @PostMapping()
    public OrderLine addOrderLineItems(@RequestBody OrderLine orderLine) {
        return orderLineService.addOrderLine(orderLine);
    }
    @GetMapping()
    public Iterable<OrderLine> retrieveOrderLine() {
        return orderLineService.findAllOrderLine();
    }

    @GetMapping("/{orderLineId}")
   // @HystrixCommand(fallbackMethod = "listOrderLineItemsFallback")
    public Optional<OrderLine> listOrderLineItems(@PathVariable("orderLineId") Long orderLineId) {
        return orderLineService.getOrderLine(orderLineId);
    }

    @GetMapping("{orderLineId}/order")
    public Long getOrderByOrderLine(@PathVariable("orderLineId") Long orderLineId){
        return orderLineService.getOrderLineItemsForOrder(orderLineId);
    }

    @PutMapping("/{orderLineId}")
    @HystrixCommand(fallbackMethod = "updateOrderLineFallback")
    public OrderLine updateOrderLine(@PathVariable("orderLineId") Long orderLineId, @RequestBody OrderLine orderLine) {
        OrderLine chanedOrderLine = orderLineService.updateOrderLine(orderLineId, orderLine);
        logger.info("OrderLine saved: " + chanedOrderLine.toString());
        return orderLine;
    }

    @DeleteMapping("/{orderLineId}")
    @HystrixCommand(fallbackMethod = "deleteFallback")
    public ResponseEntity<?> delete(@PathVariable("ordersId") Long ordersId) {
        orderLineService.deleteOrderLine(ordersId);
        return ResponseEntity.ok().body("Order Line has been deleted.");
    }

    public OrderLine createOrderLineFallback(OrderLine orderLine, Orders orders) {
        logger.info("Error creating orderline " +orderLine +orders);
        return new OrderLine();
    }

//    public void listOrderLineItemsFallback (Long orderLineId) {
//        logger.info("Error getting items for order line " +orderLineId);
//    }

    public OrderLine updateOrderLineFallback(OrderLine orderLine) {
        logger.info("Error updating Order line " +orderLine);
        return new OrderLine();
    }

    public void deleteFallback() {
        logger.info("Error deleting order lines");
    }
}

