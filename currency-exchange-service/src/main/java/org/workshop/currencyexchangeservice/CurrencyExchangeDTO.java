package org.workshop.currencyexchangeservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CurrencyExchangeDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "currency_from")
    private String from;
    @Column(name = "currency_to")
    private String to;
    private int port;
    private BigDecimal multiplier;

    public CurrencyExchangeDTO(String from, String to, int port, BigDecimal multiplier) {
        this.from = from;
        this.to = to;
        this.port = port;
        this.multiplier = multiplier;
    }
}
