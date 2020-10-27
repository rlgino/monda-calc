package com.rlgino.calculadora.controller;

import com.rlgino.calculadora.bussiness.Calculadora;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CalculadoraController {

    @Autowired
    private Calculadora calculadora;

    @GetMapping(path = "/sumar")
    @ResponseStatus(HttpStatus.OK)
    public Integer sumarHandler(@RequestParam("n1") Integer n1, @RequestParam("n2") Integer n2) {
        if(n1 == null){
            throw new CustomException();
        } else if(n2 == null){
            throw new CustomException();
        }
        return calculadora.sumar(n1, n2);
    }

    @GetMapping(path = "/restar")
    public Integer restarHandler(@RequestParam("n1") Integer n1, @RequestParam("n2") Integer n2) {
        if(n1 == null){
            throw new CustomException();
        } else if(n2 == null){
            throw new CustomException();
        }
        return calculadora.restar(n1, n2);
    }

    @GetMapping(path = "/multiplicar")
    public Integer multiplicarHandler(@RequestParam("n1") Integer n1, @RequestParam("n2") Integer n2) {
        if(n1 == null){
            throw new CustomException();
        } else if(n2 == null){
            throw new CustomException();
        }
        return calculadora.multiplicar(n1, n2);
    }

    @GetMapping(path = "/dividir")
    public Double dividirHandler(@RequestParam("n1") Integer n1, @RequestParam("n2") Integer n2) {
        if(n1 == null){
            throw new CustomException();
        } else if(n2 == null){
            throw new CustomException();
        }
        BigDecimal n1bd = new BigDecimal(n1);
        BigDecimal n2bd = new BigDecimal(n2);
        return calculadora.dividir(n1bd, n2bd).doubleValue();
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    static class CustomException extends RuntimeException {}
}
