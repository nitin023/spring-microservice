package com.training.microServices.currencyexchangeservice.Repository;

import com.training.microServices.currencyexchangeservice.Domain.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<ExchangeValue,Long> {

    ExchangeValue findByFromAndTo(String from,String to);
}
