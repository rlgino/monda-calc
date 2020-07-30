package com.rlgino.calculadora.bussiness;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class Calculadora {

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
