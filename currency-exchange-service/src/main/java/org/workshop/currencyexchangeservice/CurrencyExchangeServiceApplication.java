package org.workshop.currencyexchangeservice;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@EnableDiscoveryClient
@SpringBootApplication
@AllArgsConstructor
public class CurrencyExchangeServiceApplication {

	private CurrencyExchangeRepository currencyExchangeRepository;
	private Environment environment;

	@PostConstruct
	private void init() {
		currencyExchangeRepository
				.save(new CurrencyExchangeDTO("USD", "EUR", Integer.valueOf(environment.getProperty("server.port")), new BigDecimal(10)));
		currencyExchangeRepository
				.save(new CurrencyExchangeDTO("USD", "AAA", Integer.valueOf(environment.getProperty("server.port")), new BigDecimal(20)));
		currencyExchangeRepository
				.save(new CurrencyExchangeDTO("USD", "BBB", Integer.valueOf(environment.getProperty("server.port")), new BigDecimal(30)));
	}

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeServiceApplication.class, args);
	}

	@Bean
    public AlwaysSampler alwaysSampler() {
	    return new AlwaysSampler();
    }
}
