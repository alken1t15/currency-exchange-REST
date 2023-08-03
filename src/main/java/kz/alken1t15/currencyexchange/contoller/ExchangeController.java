package kz.alken1t15.currencyexchange.contoller;

import kz.alken1t15.currencyexchange.dto.ExchangeDTO;
import kz.alken1t15.currencyexchange.entity.ExchangeRates;
import kz.alken1t15.currencyexchange.service.ExchangeRatesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/exchange")
@AllArgsConstructor
public class ExchangeController {
    private final ExchangeRatesService exchangeRatesService;


    @GetMapping()
    public ResponseEntity<ExchangeDTO> exchange(@RequestParam("from") String from, @RequestParam("to") String to, @RequestParam("amount") Double amount) {
        return exchangeRatesService.exchange(from, to, amount);
    }
}