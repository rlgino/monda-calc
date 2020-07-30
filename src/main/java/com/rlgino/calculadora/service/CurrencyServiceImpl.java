package com.rlgino.calculadora.service;

import com.rlgino.calculadora.dto.CurrencyExchangeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    public final String currencyURL = "https://api.exchangeratesapi.io";
    public final String baseUSD = "/latest?base=USD";

    @Autowired
    RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.rootUri(currencyURL).build();
    }

    @Override
    public CurrencyExchangeResponse getCurrencyValue() {
        HttpEntity<Void> requestEntity = new HttpEntity<>(new HttpHeaders());

        return this.restTemplate
                .exchange("/latest?base=USD", HttpMethod.GET, requestEntity, CurrencyExchangeResponse.class)
                .getBody();
    }
}
