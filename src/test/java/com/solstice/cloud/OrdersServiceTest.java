//package com.solstice.cloud;
//
//import com.solstice.cloud.domain.Orders;
//import com.solstice.cloud.service.OrdersService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
//public class OrdersServiceTest {
//
//    @Autowired
//    OrdersService ordersService;
//
//    @Test
//    public void testAddOrder() {
//        Orders newOrder = new Orders();
//       // newOrder.setOrderDate(2018-09-17);
//       // newOrder.setOrderLineItems("Coffee");
//        newOrder.setTotalPriceOrder(5.00);
//
//        Orders test = ordersService.save(newOrder);
//        assertNotNull(test);
//        assertNotNull(test.getOrdersId());
//        assertEquals(5.00, test.getTotalPriceOrder(),0);
//
//
//        ;
//    }
//}
