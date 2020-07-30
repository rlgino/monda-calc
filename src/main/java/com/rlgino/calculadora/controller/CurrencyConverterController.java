package com.rlgino.calculadora.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CurrencyConverterController {

    @GetMapping(path = "/convert")
    public ResponseEntity<Object> convertFrom() {

        return new ResponseEntity("Response",HttpStatus.OK);
    }
}
