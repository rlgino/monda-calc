package com.rlgino.calculadora.controller;

import com.rlgino.calculadora.bussiness.Currency;
import com.rlgino.calculadora.dto.CurrencyConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class CurrencyConverterController {
    @Autowired
    public Currency currencyBussiness;

    @PostMapping(path = "/convert", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> convertFrom(@RequestBody CurrencyConverter body) {
        currencyBussiness.convert();
        return new ResponseEntity("Response " + body.getCurrencyFrom(),HttpStatus.OK);
    }
}
