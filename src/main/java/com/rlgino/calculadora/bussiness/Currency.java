package com.rlgino.calculadora.bussiness;

import com.rlgino.calculadora.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Currency {
    @Autowired
    CurrencyService currencyService;

    public BigDecimal convert(){
        currencyService.getCurrencyValue();
        return BigDecimal.ZERO;
    }
}
