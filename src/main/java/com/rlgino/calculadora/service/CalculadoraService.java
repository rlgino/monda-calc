package com.rlgino.calculadora.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CalculadoraService {

    public Integer sumar(Integer n1, Integer n2) {
        return n1 + n2;
    }

    public Integer restar(Integer n1, Integer n2) {
        return n1 - n2;
    }

    public Integer multiplicar(Integer n1, Integer n2) {
        return n1 * n2;
    }

    public BigDecimal dividir(BigDecimal n1, BigDecimal n2) {
        return n1.divide(n2, 2, RoundingMode.UP);
    }
}
