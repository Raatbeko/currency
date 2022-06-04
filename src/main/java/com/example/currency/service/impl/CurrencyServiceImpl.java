package com.example.currency.service.impl;

import com.example.currency.dto.currency.request.CurrencyRequest;
import com.example.currency.dto.currency.request.CurrencyRequestToUpdate;
import com.example.currency.dto.currency.response.CurrencyResponse;
import com.example.currency.entity.Currency;
import com.example.currency.exception.CurrencyIsEmptyException;
import com.example.currency.exception.NotFoundException;
import com.example.currency.mapper.CurrencyMapper;
import com.example.currency.repository.CurrencyRepository;
import com.example.currency.service.CurrencyService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    final CurrencyRepository currencyRepository;

    @Override
    public CurrencyResponse save(@RequestBody CurrencyRequest currencyRequest) {
        if(currencyRequest != null){

        return CurrencyMapper.INSTANCE.toCurrencyResponse(
                currencyRepository.save(
                        CurrencyMapper.INSTANCE.toCurrencyEntity(currencyRequest)));
        }
        throw new CurrencyIsEmptyException("Невозможно передать пустой обьект!!!", HttpStatus.BAD_REQUEST);
    }

    @Override
    public List<CurrencyResponse> getAll() {
        return CurrencyMapper.INSTANCE.toCurrencyResponse(currencyRepository.findAll());
    }

    @Override
    public CurrencyResponse findById(Long id) throws ChangeSetPersister.NotFoundException {
        return null;
    }

    @Override
    public CurrencyResponse findById(Currency currency) {
        return CurrencyMapper.INSTANCE.toCurrencyResponse(currency);
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public CurrencyResponse update(CurrencyRequestToUpdate currencyRequest) {
        Currency currency = currencyRepository.findById(currencyRequest.getId()).orElse(new Currency());
        currency.setValue(currencyRequest.getValue());

        return CurrencyMapper.INSTANCE.toCurrencyResponse(currencyRepository.save(currency));
    }
}
