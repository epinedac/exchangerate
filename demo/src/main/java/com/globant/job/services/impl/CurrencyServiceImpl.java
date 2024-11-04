package com.globant.job.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.globant.job.model.CurrencyConversionResponse;
import com.globant.job.services.ApiExchangeRate;
import com.globant.job.services.ICurrencyService;

import reactor.core.publisher.Mono;

@Service
public class CurrencyServiceImpl implements ICurrencyService{

	@Autowired
	private ApiExchangeRate currencyConversionService;
	
    @Cacheable(value = "currencyConversionCache", key = "#sourceCurrency + '-' + #targetCurrency + '-' + #amount")
    public Mono<CurrencyConversionResponse> convert(double amount, String sourceCurrency, String targetCurrency) {
    	
        // Lógica para obtener el tipo de cambio (puede ser llamada a un servicio externo)
    	return currencyConversionService.getExchangeRate(sourceCurrency, targetCurrency)
        .map(rate -> new CurrencyConversionResponse(amount, amount * rate, sourceCurrency, targetCurrency, rate));
    	
    }

}

