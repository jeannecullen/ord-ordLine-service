package com.solstice.cloud.repo;

import com.solstice.cloud.domain.OrderLine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderLineRepository extends CrudRepository<OrderLine, Long> {

    Long getOrdersIdIdByOrderLineId(Long orderLineId);


}
