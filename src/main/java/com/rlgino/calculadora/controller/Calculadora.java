package com.rlgino.calculadora.controller;

import com.rlgino.calculadora.service.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;

@RestController
public class Calculadora {

    @Autowired
    private CalculadoraService calculadoraService;

    @GetMapping(path = "/sumar")
    public Integer sumarHandler(@RequestParam("n1") Integer n1, @RequestParam("n2") Integer n2) {
        if(n1 == null){
            System.out.println("El n1 no está definido");
            return null;
        } else if(n2 == null){
            System.out.println("El n2 no está definido");
            return null;
        }
        return calculadoraService.sumar(n1, n2);
    }

    @GetMapping(path = "/restar")
    public Integer restarHandler(@RequestParam("n1") Integer n1, @RequestParam("n2") Integer n2) {
        if(n1 == null){
            System.out.println("El n1 no está definido");
            return null;
        } else if(n2 == null){
            System.out.println("El n2 no está definido");
            return null;
        }
        return calculadoraService.restar(n1, n2);
    }

    @GetMapping(path = "/multiplicar")
    public Integer multiplicarHandler(@RequestParam("n1") Integer n1, @RequestParam("n2") Integer n2) {
        if(n1 == null){
            System.out.println("El n1 no está definido");
            return null;
        } else if(n2 == null){
            System.out.println("El n2 no está definido");
            return null;
        }
        return calculadoraService.multiplicar(n1, n2);
    }

    @GetMapping(path = "/dividir")
    public Double dividirHandler(@RequestParam("n1") Integer n1, @RequestParam("n2") Integer n2) {
        if(n1 == null){
            System.out.println("El n1 no está definido");
            return null;
        } else if(n2 == null){
            System.out.println("El n2 no está definido");
            return null;
        }
        BigDecimal n1bd = new BigDecimal(n1);
        BigDecimal n2bd = new BigDecimal(n2);
        return calculadoraService.dividir(n1bd, n2bd).doubleValue();
    }
}
