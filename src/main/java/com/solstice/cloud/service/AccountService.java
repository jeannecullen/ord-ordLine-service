package com.solstice.cloud.service;

import com.solstice.cloud.domain.AccountResult;
import com.solstice.cloud.domain.AddressResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.ws.rs.Path;
import java.util.List;

@Component
@FeignClient(name="account-address-service")
public interface AccountService {

    @RequestMapping(method=RequestMethod.GET, value="accounts/{accountId}")
    AccountResult getAccount(@PathVariable("accountId") Long accountId);

    @RequestMapping(path = "/addresses/{addressId}", method = RequestMethod.GET)
    AddressResult getAddressByAddressId(@PathVariable("addressId") long addressId);

    @RequestMapping(method=RequestMethod.GET, value="/accounts/{account}/address")
    AddressResult listAccountAddress(@PathVariable("account") Long account);
}
