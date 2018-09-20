package com.solstice.cloud.service;

import com.solstice.cloud.domain.ShipmentResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Component
@FeignClient("shipment-service")
public interface ShipmentService {

    @RequestMapping(method=RequestMethod.GET, value="shipments/{shipmentId}")
    ShipmentResult getShipment(@PathVariable("shipmentId") Long shipmentId);
}
