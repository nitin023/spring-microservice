package com.training.microServices.currencyexchangeservice.Controller;

import com.training.microServices.currencyexchangeservice.Domain.ExchangeValue;
import com.training.microServices.currencyexchangeservice.Service.CurrencyExchangeService;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    CurrencyExchangeService currencyExchangeService;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from , @PathVariable String to)
    {
        ExchangeValue exchangeValue = currencyExchangeService.getExchangeValueUsingFromAndToCurrency(from,to);
        if(exchangeValue!=null) {
            exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
            return exchangeValue;
        }
        else
        {
            return new ExchangeValue();
        }
    }
}
