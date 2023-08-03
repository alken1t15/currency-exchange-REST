package kz.alken1t15.currencyexchange.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import kz.alken1t15.currencyexchange.entity.Currencies;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeDTO {
    private Currencies baseCurrencyId;

    private Currencies targetCurrencyId;

    private Double rate;

    private Double amount;

    private Double convertedAmount;
}