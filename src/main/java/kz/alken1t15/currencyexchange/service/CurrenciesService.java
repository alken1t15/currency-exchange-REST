package kz.alken1t15.currencyexchange.service;

import kz.alken1t15.currencyexchange.entity.Currencies;
import kz.alken1t15.currencyexchange.repository.CurrenciesRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@AllArgsConstructor
public class CurrenciesService {
    private final CurrenciesRepository currenciesRepository;

    public List<Currencies> findAll() {
        return currenciesRepository.findAll();
    }

    public Currencies findByCode(String name) {
        return currenciesRepository.findByCode(name);
    }

    public HttpStatus save(String name, String code, String sign) {
        if (name == null || code == null || sign == null) {
            return HttpStatus.BAD_REQUEST;
        }
        Currencies currencies = currenciesRepository.findByFullNameAndCodeAndSign(name, code, sign);
        if (currencies == null) {
            Currencies currencies1 = new Currencies(code, name, sign);
            currenciesRepository.save(currencies1);
            return HttpStatus.OK;
        } else {
            return HttpStatus.CONFLICT;
        }

    }
}