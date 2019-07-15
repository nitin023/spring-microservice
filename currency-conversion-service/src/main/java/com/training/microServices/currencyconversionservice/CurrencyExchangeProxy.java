package com.training.microServices.currencyconversionservice;

import org.springframework.cloud.openfeign.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange-service",url = "localhost:8000")
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
     CurrencyConversionBean retrieveExchangeValue(@PathVariable ("from") String from , @PathVariable ("to") String to);
}
