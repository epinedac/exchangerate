package com.globant.job.model;


public class CurrencyConversionResponse {

    private double originalAmount;        // Monto ingresado por el usuario
    private double convertedAmount;       // Monto después de aplicar el tipo de cambio
    private String sourceCurrency;        // Moneda de origen
    private String targetCurrency;        // Moneda de destino
    private double exchangeRate;          // Tipo de cambio aplicado

    // Constructor
    public CurrencyConversionResponse(double originalAmount, double convertedAmount, String sourceCurrency, String targetCurrency, double exchangeRate) {
        this.originalAmount = originalAmount;
        this.convertedAmount = convertedAmount;
        this.sourceCurrency = sourceCurrency;
        this.targetCurrency = targetCurrency;
        this.exchangeRate = exchangeRate;
    }

    // Getters y Setters
    public double getOriginalAmount() {
        return originalAmount;
    }

    public void setOriginalAmount(double originalAmount) {
        this.originalAmount = originalAmount;
    }

    public double getConvertedAmount() {
        return convertedAmount;
    }

    public void setConvertedAmount(double convertedAmount) {
        this.convertedAmount = convertedAmount;
    }

    public String getSourceCurrency() {
        return sourceCurrency;
    }

    public void setSourceCurrency(String sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    // Método toString() para facilitar el logging y depuración
    @Override
    public String toString() {
        return "CurrencyConversionResponse{" +
                "originalAmount=" + originalAmount +
                ", convertedAmount=" + convertedAmount +
                ", sourceCurrency='" + sourceCurrency + '\'' +
                ", targetCurrency='" + targetCurrency + '\'' +
                ", exchangeRate=" + exchangeRate +
                '}';
    }
}

