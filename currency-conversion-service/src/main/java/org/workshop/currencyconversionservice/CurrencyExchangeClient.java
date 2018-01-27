package org.workshop.currencyconversionservice;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RibbonClient(name = "currency-exchange-service")
@FeignClient(name = "gateway-server")
public interface CurrencyExchangeClient {
    @GetMapping(value = "/currency-exchange-service/currency-exchange/from/{from}/to/{to}/", produces = "application/json")
    CurrencyConvertDTO exchangeCurrency(@PathVariable(name = "from") String from, @PathVariable(name = "to") String to);
}
