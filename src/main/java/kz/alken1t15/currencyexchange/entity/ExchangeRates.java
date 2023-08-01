package kz.alken1t15.currencyexchange.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "exchangeRates")
@Getter
@Setter
public class ExchangeRates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "base_currency_id")
    private Currencies baseCurrencyId;

    @ManyToOne
    @JoinColumn(name = "target_currency_id")
    private Currencies targetCurrencyId;

    private Double rate;
}