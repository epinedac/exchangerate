package com.globant.job;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class ExchangeController {

    private final ExchangeRateConfig exchangeRateConfig;

    public ExchangeController(ExchangeRateConfig exchangeRateConfig) {
        this.exchangeRateConfig = exchangeRateConfig;
    }

    @GetMapping("/api/v1/exchange-rate")
    public Mono<Double> getExchangeRate(
            @RequestParam String from,
            @RequestParam String to) {

        String key = from.toUpperCase() + "_TO_" + to.toUpperCase();
        Double rate = exchangeRateConfig.getRates().get(key);

        if (rate == null) {
            return Mono.error(new IllegalArgumentException("Tipo de cambio no encontrado"));
        }

        return Mono.just(rate);
    }
}


