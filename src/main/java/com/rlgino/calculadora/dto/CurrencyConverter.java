package com.rlgino.calculadora.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class CurrencyConverter {
    private BigDecimal value;
    @JsonProperty("currency_from")
    private String currencyFrom;
    @JsonProperty("currency_to")
    private String currencyTo;

    public CurrencyConverter(BigDecimal value, String currencyFrom, String currencyTo) {
        this.value = value;
        this.currencyFrom = currencyFrom;
        this.currencyTo = currencyTo;
    }

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
