package com.rlgino.calculadora.bussiness;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CalculadoraTest {
    @Autowired
    private Calculadora calculadoraComponent;

    @Test
    public void sumarTest(){
        Integer result = calculadoraComponent.sumar(10, 20);
        assertThat(result).isEqualTo(30);
    }

    @Test
    public void restartTest(){
        Integer result = calculadoraComponent.restar(10, 20);
        assertThat(result).isEqualTo(-10);
    }
}
