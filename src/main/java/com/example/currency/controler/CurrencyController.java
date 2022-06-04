package com.example.currency.controler;

import com.example.currency.dto.currency.request.CurrencyRequest;
import com.example.currency.dto.currency.request.CurrencyRequestToUpdate;
import com.example.currency.dto.currency.response.CurrencyResponse;
import com.example.currency.entity.Currency;
import com.example.currency.service.CurrencyService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/currency")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@CrossOrigin(origins = "*", maxAge = 3600)
public class CurrencyController {

    final CurrencyService currencyService;

    @GetMapping("/currencies")
    List<CurrencyResponse> getAll(){
        return currencyService.getAll();
    }

    @GetMapping("/{id}")
    CurrencyResponse getById(@RequestParam("id") Currency currency){
        return currencyService.findById(currency);
    }

    @PostMapping
    CurrencyResponse save(@RequestBody CurrencyRequest currencyRequest){
        return currencyService.save(currencyRequest);
    }

    @PutMapping("/update")
    CurrencyResponse updateToValue(@RequestBody CurrencyRequestToUpdate currency){
        return currencyService.update(currency);
    }

}
