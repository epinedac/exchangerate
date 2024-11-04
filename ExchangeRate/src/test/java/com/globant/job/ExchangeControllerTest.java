package com.globant.job;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Map;

class ExchangeControllerTest {

    @Mock
    private ExchangeRateConfig exchangeRateConfig; 

    @InjectMocks
    private ExchangeController exchangeController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getExchangeRate_shouldReturnRate_whenRateExists() {
        // Arrange
        String fromCurrency = "PEN";
        String toCurrency = "USD";
        String key = fromCurrency.toUpperCase() + "_TO_" + toCurrency.toUpperCase();
        Double expectedRate = 3.78;

        when(exchangeRateConfig.getRates()).thenReturn(Map.of(key, expectedRate));

        // Act
        Mono<Double> result = exchangeController.getExchangeRate(fromCurrency, toCurrency);

        // Assert
        result.subscribe(rate -> {
            assertEquals(expectedRate, rate);
        });
    }

    @Test
    void getExchangeRate_shouldThrowError_whenRateDoesNotExist() {
        // Arrange
        String fromCurrency = "PEN";
        String toCurrency = "USD";
        String key = fromCurrency.toUpperCase() + "_TO_" + toCurrency.toUpperCase();

        when(exchangeRateConfig.getRates()).thenReturn(Map.of());

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            exchangeController.getExchangeRate(fromCurrency, toCurrency).block();
        });
    }
}
