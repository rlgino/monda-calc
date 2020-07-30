package com.rlgino.calculadora.dto;

import java.math.BigDecimal;

public class CurrencyConverter {
    private BigDecimal value;
    private String currencyFrom;
    private String currencyTo;

    public BigDecimal getValue() {
        return value;
    }

    public String getCurrencyFrom() {
        return currencyFrom;
    }

    public String getCurrencyTo() {
        return currencyTo;
    }
}
