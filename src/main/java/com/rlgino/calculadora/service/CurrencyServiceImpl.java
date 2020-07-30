package com.rlgino.calculadora.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    public final String currencyURL = "https://api.exchangeratesapi.io/latest?base=USD";

    @Autowired
    RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Override
    public BigDecimal getCurrencyValue() {
        CurrencyExchange currency = restTemplate.getForObject(
                currencyURL, CurrencyExchange.class);
        if (currency != null) {
            System.out.println(currency.getBase());
            System.out.println(currency.getRates().get("EUR"));
        } else {
            System.err.println("Hubo un error");
        }
        return null;
    }
}
