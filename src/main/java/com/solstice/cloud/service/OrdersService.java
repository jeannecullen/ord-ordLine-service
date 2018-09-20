package com.solstice.cloud.service;

import com.solstice.cloud.domain.OrderLine;
import com.solstice.cloud.domain.Orders;
import com.solstice.cloud.domain.ProductResult;
import com.solstice.cloud.domain.ShipmentResult;
import com.solstice.cloud.repo.OrderLineRepository;
import com.solstice.cloud.repo.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrdersService {

    //Logger logger = LoggerFactory.getLogger("OrdersService");

    OrdersRepository ordersRepository;
    OrderLineRepository orderLineRepository;

    @Autowired ProductService productService;
    @Autowired ShipmentService shipmentService;
    @Autowired AccountService accountService;


    public OrdersService(OrdersRepository ordersRepository) {
        super();
        this.ordersRepository = ordersRepository;
    }

    public Orders save(Orders orders) {
        Orders ordersSaved = ordersRepository.save(orders);
        return ordersSaved;
    }

    public Iterable<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }
    public Optional<Orders> getOrder(Long ordersId) {
        return ordersRepository.findById(ordersId);
    }

    public Orders addOrder(Orders orders) {
        return ordersRepository.save(orders);
    }

    public Orders updateOrder(Long ordersId, Orders orders) { return ordersRepository.save(orders);}

    public void delete(Long ordersId) {
        ordersRepository.deleteById(ordersId);
    }

    public Iterable<Orders> getOrdersByAccount(Long accountId) {
        return ordersRepository.findAllOrdersOrderByAccountId(accountId);
    }

    public OrderLine addOrderLineItems(Long ordersId, OrderLine orderLine) {
        Orders orders = ordersRepository.findById(ordersId).get();
        orderLine.setOrders(orders);
        return orderLineRepository.save(orderLine);
    }

    public ProductResult getProduct(Long productId) { return productService.getProduct(productId);}

    public ShipmentResult getShipment(Long shipmentId) { return shipmentService.getShipment(shipmentId);}
}
