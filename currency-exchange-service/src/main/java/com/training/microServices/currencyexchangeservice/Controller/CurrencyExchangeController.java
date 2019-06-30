package com.training.microServices.currencyexchangeservice.Controller;

import com.training.microServices.currencyexchangeservice.DTO.ExchangeValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from , @PathVariable String to)
    {
        return new ExchangeValue(1000L,"USD","INR", BigDecimal.valueOf(65));
    }
}
