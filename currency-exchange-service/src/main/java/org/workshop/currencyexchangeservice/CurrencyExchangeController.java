package org.workshop.currencyexchangeservice;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CurrencyExchangeController {

    private static final Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

    private CurrencyExchangeRepository currencyExchangeRepository;

    @GetMapping(value = "/currency-exchange/from/{from}/to/{to}/", produces = "application/json")
    public CurrencyExchangeDTO exchangeCurrency(@PathVariable String from, @PathVariable String to) {
        logger.info("convertCurrency from {} to {}", from, to);
        return currencyExchangeRepository.findByFromAndTo(from, to);
    }
}
