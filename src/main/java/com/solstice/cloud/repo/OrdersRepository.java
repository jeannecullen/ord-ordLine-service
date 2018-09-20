package com.solstice.cloud.repo;

import com.solstice.cloud.domain.OrderLine;
import com.solstice.cloud.domain.Orders;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends CrudRepository<Orders,Long> {

    List<OrderLine> findOrderLineByOrdersId(long ordersId);

    @Query(value="SELECT o " +
            " FROM Orders o " +
            " WHERE accountId=:accnt" +
            " ORDER BY orderDate")
    List<Orders> findAllOrdersOrderByDate(@Param("accnt") long accountId);

    List<Orders> findAllOrdersOrderByAccountId(long accountId);
}
