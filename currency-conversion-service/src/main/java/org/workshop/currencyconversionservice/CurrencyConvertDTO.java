package org.workshop.currencyconversionservice;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CurrencyConvertDTO {

    private long id;
    private String from;
    private String to;
    private BigDecimal multiplier;
    private int port;
    private BigDecimal quantity;
    private BigDecimal totalCalculation;
}
