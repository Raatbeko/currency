package com.example.currency.mapper;

import com.example.currency.dto.currency.request.CurrencyRequest;
import com.example.currency.dto.currency.response.CurrencyResponse;
import com.example.currency.entity.Currency;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CurrencyMapper {
    CurrencyMapper INSTANCE = Mappers.getMapper(CurrencyMapper.class);

    Currency toCurrencyEntity(CurrencyRequest currencyRequest);

    CurrencyResponse toCurrencyResponse(Currency currency);

    CurrencyResponse toCurrencyResponse(CurrencyRequest currencyRequest);

    List<CurrencyResponse> toCurrencyResponse(List<Currency> currencies);
}
