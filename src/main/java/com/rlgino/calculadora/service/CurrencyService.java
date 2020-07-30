package com.rlgino.calculadora.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public interface CurrencyService {
    public BigDecimal getCurrencyValue();
}
