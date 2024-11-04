package com.globant.job;

import com.globant.job.model.CurrencyConversionResponse;
import com.globant.job.services.ApiExchangeRate;
import com.globant.job.services.impl.CurrencyServiceImpl;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class CurrencyServiceImplTest {

    @Mock
    private ApiExchangeRate currencyConversionService;

    @InjectMocks
    private CurrencyServiceImpl currencyService;

    public CurrencyServiceImplTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void convert_shouldReturnCurrencyConversionResponse() {
        // Arrange
        double amount = 100;
        String sourceCurrency = "USD";
        String targetCurrency = "PEN";
        double exchangeRate = 0.85; // Tipo de cambio

        when(currencyConversionService.getExchangeRate(sourceCurrency, targetCurrency))
                .thenReturn(Mono.just(exchangeRate));

        // Act
        Mono<CurrencyConversionResponse> responseMono = currencyService.convert(amount, sourceCurrency, targetCurrency);

        // Assert
        responseMono.subscribe(response -> {
            assertEquals(amount, response.getOriginalAmount());
            assertEquals(amount * exchangeRate, response.getConvertedAmount());
            assertEquals(sourceCurrency, response.getSourceCurrency());
            assertEquals(targetCurrency, response.getTargetCurrency());
            assertEquals(exchangeRate, response.getExchangeRate());
        });
    }
}

