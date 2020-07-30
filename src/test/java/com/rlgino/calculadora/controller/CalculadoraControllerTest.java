package com.rlgino.calculadora.controller;

import com.rlgino.calculadora.bussiness.Calculadora;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CalculadoraControllerTest {

    @MockBean
    private Calculadora calculadoraService;

    @Autowired
    private CalculadoraController calculadora;

    @Test
    public void sumarTest() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Integer n1 = 10;
        Integer n2 = 20;

        when(calculadoraService.sumar(n1,n2)).thenReturn(30);

        Integer result = calculadora.sumarHandler(n1, n2);

        assertThat(result).isEqualTo(30);
    }

    @Test
    public void restarTest() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Integer n1 = 10;
        Integer n2 = 20;

        when(calculadoraService.restar(n1,n2)).thenReturn(-10);

        Integer result = calculadora.restarHandler(n1, n2);

        assertThat(result).isEqualTo(-10);
    }
}
