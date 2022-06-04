package com.example.currency.exception;

import org.springframework.http.HttpStatus;

public class CurrencyIsEmptyException extends RuntimeException {

    public CurrencyIsEmptyException(String massage, HttpStatus badRequest) {
        super(massage);
    }

}
