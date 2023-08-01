package kz.alken1t15.currencyexchange.service;

import kz.alken1t15.currencyexchange.repository.ExchangeRatesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ExchangeRatesService {
    private final ExchangeRatesRepository exchangeRatesRepository;
}