package com.globant.job.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.globant.job.model.CurrencyConversionResponse;
import com.globant.job.services.ICurrencyService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/currency")
public class CurrencyController {
	
	private final ICurrencyService currencyService;

    CurrencyController(ICurrencyService currencyService) {
        this.currencyService = currencyService;
    }
	
    @GetMapping("/convert")
    public Mono<CurrencyConversionResponse> convertCurrency(
        @RequestParam double amount, // monto
        @RequestParam String sourceCurrency, // moneda origen
        @RequestParam String targetCurrency) { // moneda destino
    	
    	return currencyService.convert(amount, sourceCurrency, targetCurrency);
    	  
    }
}

