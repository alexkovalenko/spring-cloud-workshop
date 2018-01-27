package org.workshop.currencyconversionservice;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@AllArgsConstructor
public class CurrencyConversionController {

    private static final Logger logger = LoggerFactory.getLogger(CurrencyConversionController.class);

    private CurrencyExchangeClient currencyExchangeClient;

    @GetMapping(value = "/currency-convert/from/{from}/to/{to}/quantity/{quantity}", produces = "application/json")
    public CurrencyConvertDTO convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        logger.info("convertCurrency from {} to {}", from, to);
        CurrencyConvertDTO convertDTO = currencyExchangeClient.exchangeCurrency(from, to);
        convertDTO.setQuantity(quantity);
        convertDTO.setTotalCalculation(quantity.multiply(convertDTO.getMultiplier()));
        return convertDTO;
    }
}
