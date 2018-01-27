package org.workshop.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchangeDTO, Long>{

    CurrencyExchangeDTO findByFromAndTo(String from, String to);
}
