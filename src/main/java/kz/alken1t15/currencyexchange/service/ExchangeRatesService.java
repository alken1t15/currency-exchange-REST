package kz.alken1t15.currencyexchange.service;

import kz.alken1t15.currencyexchange.entity.ExchangeRates;
import kz.alken1t15.currencyexchange.repository.ExchangeRatesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ExchangeRatesService {
    private final ExchangeRatesRepository exchangeRatesRepository;

    public List<ExchangeRates> findAll() {
        return exchangeRatesRepository.findAll();
    }

    public ExchangeRates findByName(String firstName, String secondName){
        return exchangeRatesRepository.findByName(firstName,secondName);
    }
}