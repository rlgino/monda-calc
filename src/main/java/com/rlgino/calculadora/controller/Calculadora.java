package com.rlgino.calculadora.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Calculadora {

    @GetMapping(path = "/sumar")
    public Integer sumar(@RequestParam("n1") Integer n1, @RequestParam("n2") Integer n2) {
        if(n1 == null){
            System.out.println("El n1 no está definido");
            return null;
        } else if(n2 == null){
            System.out.println("El n2 no está definido");
            return null;
        } else {
            System.out.println("N1 " + n1 + " n2 " + n2);
        }
        return n1 + n2;
    }
}
