package kz.alken1t15.currencyexchange.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExchangeRatesDTO {
    private String baseCurrencyCode;
    private String targetCurrencyCode;
    private Double rate;
}