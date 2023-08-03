package kz.alken1t15.currencyexchange.repository;

import kz.alken1t15.currencyexchange.entity.ExchangeRates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ExchangeRatesRepository extends JpaRepository<ExchangeRates, Long> {
    @Query("select e from ExchangeRates e join Currencies  c on  c.id = e.baseCurrencyId.id join Currencies c2 on c2.id = e.targetCurrencyId.id where c.id=(select c.id from Currencies c where c.code = ?1) and c2.id= (select c.id from Currencies c where c.code = ?2)")
    ExchangeRates findByName(String firstName, String secondName);

    @Query("select e from ExchangeRates e join Currencies  c on  c.id = e.baseCurrencyId.id join Currencies c2 on c2.id = e.targetCurrencyId.id where c.id=(select c.id from Currencies c where c.code = ?1) and c2.id= (select c.id from Currencies c where c.code = ?2) and e.rate=?3")
    ExchangeRates findByNameAndRate(String firstName, String secondName, Double rate);

}