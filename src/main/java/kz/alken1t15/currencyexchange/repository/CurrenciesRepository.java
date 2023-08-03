package kz.alken1t15.currencyexchange.repository;

import kz.alken1t15.currencyexchange.entity.Currencies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrenciesRepository extends JpaRepository<Currencies, Long> {
    Currencies findByCode(String code);

    Currencies findByFullNameAndCodeAndSign(String fullName, String code, String sign);
}