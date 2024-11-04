package com.globant.job.services;

import com.globant.job.model.CurrencyConversionResponse;

import reactor.core.publisher.Mono;

public interface ICurrencyService {
	public Mono<CurrencyConversionResponse> convert(double amount, String sourceCurrency, String targetCurrency);
}
