package com.rlgino.calculadora.controller;

import com.rlgino.calculadora.bussiness.Currency;
import com.rlgino.calculadora.dto.CurrencyConverter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CurrencyConverterControllerTest {
    @MockBean
    private Currency currencyBean;
    @Autowired
    private CurrencyConverterController controller;

    @Test
    public void convertFromTest(){
        CurrencyConverter body = new CurrencyConverter(BigDecimal.TEN,"ARS", "USD");
        when(currencyBean.convert(body)).thenReturn(BigDecimal.TEN);

        final ResponseEntity<Object> response = controller.convertFrom(body);

        assertThat(HttpStatus.OK).isEqualTo(response.getStatusCode());
        assertThat("Total 10.00").isEqualTo(response.getBody());
    }

    @Test
    public void convertFromFailTest(){
        CurrencyConverter body = new CurrencyConverter(BigDecimal.TEN,"ARS", "USD");
        when(currencyBean.convert(body)).thenThrow(new RuntimeException("mocked for test"));

        final ResponseEntity<Object> response = controller.convertFrom(body);

        assertThat(HttpStatus.BAD_REQUEST).isEqualTo(response.getStatusCode());
        assertThat("mocked for test").isEqualTo(response.getBody());
    }
}
