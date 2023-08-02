package kz.alken1t15.currencyexchange.repository;

import kz.alken1t15.currencyexchange.entity.ExchangeRates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ExchangeRatesRepository extends JpaRepository<ExchangeRates,Long> {
    @Query("select e from ExchangeRates e join Currencies  c on  c.id = e.id where c.id=?1 and c.id= ?2")
    ExchangeRates findByName(String firstName, String secondName);
}