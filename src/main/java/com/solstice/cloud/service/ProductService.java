package com.solstice.cloud.service;

import com.solstice.cloud.domain.ProductResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient("product-service")
public interface ProductService {

    @RequestMapping(method=RequestMethod.GET, value="products/{productId}")
    ProductResult getProduct(@PathVariable("productId") Long productId);
}
