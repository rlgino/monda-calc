package com.rlgino.calculadora.bussiness;

import com.rlgino.calculadora.dto.CurrencyConverter;
import com.rlgino.calculadora.dto.CurrencyExchangeResponse;
import com.rlgino.calculadora.service.CurrencyServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CurrencyTest {

    @MockBean
    CurrencyServiceImpl currencyService;

    @Autowired
    private Currency currency;

    @Test
    public void converterTest(){
        CurrencyExchangeResponse exchange = new CurrencyExchangeResponse();
        final Map<String, BigDecimal> ratesMap = new HashMap<>();
        ratesMap.put("USD", BigDecimal.ONE);
        ratesMap.put("EUR", BigDecimal.ONE);
        exchange.setRates(ratesMap);
        when(currencyService.getCurrencyValue()).thenReturn(exchange);

        CurrencyConverter body = new CurrencyConverter(BigDecimal.ONE, "USD", "EUR");

        final BigDecimal result = currency.convert(body);

        assertThat(result).isEqualTo(BigDecimal.ONE);
    }

    @Test
    public void converterFailTest(){
        CurrencyExchangeResponse exchange = new CurrencyExchangeResponse();
        final Map<String, BigDecimal> ratesMap = new HashMap<>();
        ratesMap.put("USD", BigDecimal.ONE);
        ratesMap.put("EUR", BigDecimal.ONE);
        exchange.setRates(ratesMap);
        when(currencyService.getCurrencyValue()).thenReturn(exchange);

        CurrencyConverter body = new CurrencyConverter(BigDecimal.ONE, "ARS", "EUR");

        assertThrows(RuntimeException.class, ()-> currency.convert(body));
    }
}
