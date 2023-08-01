package kz.alken1t15.currencyexchange.repository;

import kz.alken1t15.currencyexchange.entity.ExchangeRates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRatesRepository extends JpaRepository<ExchangeRates,Long> {
}