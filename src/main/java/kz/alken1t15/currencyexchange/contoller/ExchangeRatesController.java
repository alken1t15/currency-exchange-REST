package kz.alken1t15.currencyexchange.contoller;

import kz.alken1t15.currencyexchange.entity.ExchangeRates;
import kz.alken1t15.currencyexchange.service.ExchangeRatesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exchangeRates")
@AllArgsConstructor
public class ExchangeRatesController {
    private final ExchangeRatesService exchangeRatesService;

    @GetMapping
    public List<ExchangeRates> getAll(){
        return exchangeRatesService.findAll();
    }

    @GetMapping("/{name}")
    public ResponseEntity<ExchangeRates> getAll(@PathVariable String name){
        if (name== null && name.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        String firstName = name.substring(0,3);
        String secondName = name.substring(3,name.length());
        ExchangeRates exchangeRates = exchangeRatesService.findByName(firstName,secondName);
        if (exchangeRates==null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(exchangeRates, HttpStatus.OK);
    }
}
