package com.globant.job.services;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ApiExchangeRate {

    private final WebClient webClient;

    private String exchangeServiceUrl = "http://localhost:8082";

    public ApiExchangeRate(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(exchangeServiceUrl).build();
    }

    @Retry(name = "exchangeRateRetry")
    @CircuitBreaker(name = "exchangeRateCircuitBreaker", fallbackMethod = "fallbackExchangeRate")
    public Mono<Double> getExchangeRate(String from, String to) {
        return webClient.get()
                .uri("/api/v1/exchange-rate?from={from}&to={to}", from, to)
                .retrieve()
                .bodyToMono(Double.class);
    }
    
}

