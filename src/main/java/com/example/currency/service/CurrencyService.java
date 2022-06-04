package com.example.currency.service;

import com.example.currency.dto.currency.request.CurrencyRequest;
import com.example.currency.dto.currency.request.CurrencyRequestToUpdate;
import com.example.currency.dto.currency.response.CurrencyResponse;
import com.example.currency.entity.Currency;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public interface CurrencyService extends BaseService<CurrencyResponse, CurrencyRequest>{
    CurrencyResponse update(CurrencyRequestToUpdate currency);
    public CurrencyResponse findById(Currency currency);
}
