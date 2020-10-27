package com.rlgino.calculadora.bussiness;

import com.rlgino.calculadora.dto.CurrencyConverter;
import com.rlgino.calculadora.dto.CurrencyExchangeResponse;
import com.rlgino.calculadora.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class Currency {
    @Autowired
    CurrencyService currencyService;

    public BigDecimal convert(CurrencyConverter currency){
        final CurrencyExchangeResponse currencyValue = currencyService.getCurrencyValue();
        if (!currencyValue.getRates().containsKey(currency.getCurrencyFrom())) {
            throw new RuntimeException(String.format("Error in process %s currency",currency.getCurrencyFrom() ));
        }
        if (!currencyValue.getRates().containsKey(currency.getCurrencyTo())) {
            throw new RuntimeException(String.format("Error in process %s currency",currency.getCurrencyTo() ));
        }
        final BigDecimal currencyFrom = currencyValue.getRates().get(currency.getCurrencyFrom());
        final BigDecimal dollarConverted = currencyFrom.divide(currency.getValue(), RoundingMode.UNNECESSARY);
        final BigDecimal currencyTo = currencyValue.getRates().get(currency.getCurrencyTo());

        return currencyTo.multiply(dollarConverted);
    }
}
