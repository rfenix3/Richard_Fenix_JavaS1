package com.trilogyed.tasker.util.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// Marks this as a feign client and names the service that this app will interact with.
@FeignClient(name = "adserver-service")
public interface AdClient {
    @RequestMapping(value = "/ad", method = RequestMethod.GET)
    public String getAd();

}
