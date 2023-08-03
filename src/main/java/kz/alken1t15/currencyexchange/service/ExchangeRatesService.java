package kz.alken1t15.currencyexchange.service;

import kz.alken1t15.currencyexchange.dto.ExchangeDTO;
import kz.alken1t15.currencyexchange.dto.ExchangeRatesDTO;
import kz.alken1t15.currencyexchange.entity.Currencies;
import kz.alken1t15.currencyexchange.entity.ExchangeRates;
import kz.alken1t15.currencyexchange.repository.ExchangeRatesRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ExchangeRatesService {
    private final ExchangeRatesRepository exchangeRatesRepository;
    private final CurrenciesService currenciesService;

    public List<ExchangeRates> findAll() {
        return exchangeRatesRepository.findAll();
    }

    public ExchangeRates findByName(String firstName, String secondName) {
        return exchangeRatesRepository.findByName(firstName, secondName);
    }

    public HttpStatus addNew(ExchangeRatesDTO exchangeRatesDTO) {
        ExchangeRates exchangeRates = exchangeRatesRepository.findByName(exchangeRatesDTO.getBaseCurrencyCode(), exchangeRatesDTO.getTargetCurrencyCode());
        if (exchangeRates != null) {
            if (exchangeRates.getRate() != exchangeRatesDTO.getRate()) {
                exchangeRates.setRate(exchangeRatesDTO.getRate());
                exchangeRatesRepository.save(exchangeRates);
                return HttpStatus.OK;
            }
            return HttpStatus.CONFLICT;
        }
        Currencies currencies = currenciesService.findByCode(exchangeRatesDTO.getBaseCurrencyCode());
        Currencies currencies2 = currenciesService.findByCode(exchangeRatesDTO.getTargetCurrencyCode());
        if (currencies == null || currencies2 == null) {
            return HttpStatus.BAD_REQUEST;
        }
        ExchangeRates exchangeRates1 = new ExchangeRates(currencies, currencies2, exchangeRatesDTO.getRate());
        exchangeRatesRepository.save(exchangeRates1);
        return HttpStatus.OK;
    }

    public HttpStatus update(Double rate) {
        return null;
    }

    public ResponseEntity<ExchangeDTO> exchange(String from, String to, Double amount) {
        ExchangeRates exchangeRates = exchangeRatesRepository.findByName(from, to);
        if (exchangeRates == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            double convertedAmount = amount * exchangeRates.getRate();
            ExchangeDTO exchangeDTO = new ExchangeDTO(exchangeRates.getBaseCurrencyId(), exchangeRates.getTargetCurrencyId(), exchangeRates.getRate(), amount, convertedAmount);
            return new ResponseEntity<>(exchangeDTO, HttpStatus.OK);
        }
    }
}