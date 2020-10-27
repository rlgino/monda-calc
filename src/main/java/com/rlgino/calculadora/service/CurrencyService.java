package com.rlgino.calculadora.service;

import com.rlgino.calculadora.dto.CurrencyExchangeResponse;
import org.springframework.stereotype.Service;

@Service
public interface CurrencyService {
    public CurrencyExchangeResponse getCurrencyValue();
}
