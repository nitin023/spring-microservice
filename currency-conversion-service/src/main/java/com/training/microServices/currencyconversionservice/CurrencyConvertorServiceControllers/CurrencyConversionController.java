package com.training.microServices.currencyconversionservice.CurrencyConvertorServiceControllers;

import com.training.microServices.currencyconversionservice.CurrencyConversionBeans.CurrencyConversionBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {

    @GetMapping("/currency-convertor/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrency(@PathVariable String from ,
                                                  @PathVariable String to ,
                                                  @PathVariable BigDecimal quantity)
    {
        String url = "http://localhost:8000/currency-exchange/from/{from}/to/{to}";
        Map<String,String> uriVariables = new HashMap<>();
        uriVariables.put("from",from);
        uriVariables.put("to",to);
        ResponseEntity<CurrencyConversionBean> currencyConversionBeanResponseEntity =
                new RestTemplate().getForEntity(url,
                CurrencyConversionBean.class,
                        uriVariables);

        CurrencyConversionBean currencyConversionBean = currencyConversionBeanResponseEntity.getBody();
        return new CurrencyConversionBean(currencyConversionBean.getId(),
                from,to,currencyConversionBean.getConversionMultiple(),
                quantity,quantity.multiply(currencyConversionBean.getConversionMultiple()),
                currencyConversionBean.getPort());
    }
}
