package kz.alken1t15.currencyexchange.contoller;

import kz.alken1t15.currencyexchange.dto.CurrenciesDTO;
import kz.alken1t15.currencyexchange.entity.Currencies;
import kz.alken1t15.currencyexchange.service.CurrenciesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/currencies")
public class CurrenciesController {
    private final CurrenciesService currenciesService;

    @GetMapping()
    public ResponseEntity<List<Currencies>> currencies(){
        return new  ResponseEntity<>(currenciesService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Currencies> currencies(@PathVariable String name){
        if (name.isEmpty() && name==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        Currencies currencies = currenciesService.findByCode(name);
        if (currencies==null){
            return new  ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new  ResponseEntity<>(currencies,HttpStatus.OK);
    }

    @PostMapping()
    public HttpStatus currencies(@RequestBody CurrenciesDTO currenciesDTO){
        return currenciesService.save(currenciesDTO.getName(),currenciesDTO.getCode().toUpperCase(),currenciesDTO.getSign());
    }
}
