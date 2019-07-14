package com.training.microServices.currencyexchangeservice.Service;

import com.training.microServices.currencyexchangeservice.Domain.ExchangeValue;
import com.training.microServices.currencyexchangeservice.Repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CurrencyExchangeService {

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    public ExchangeValue getExchangeValueUsingFromAndToCurrency(String from ,String to)
    {
       return currencyExchangeRepository.findByFromAndTo(from,to);
    }
}
