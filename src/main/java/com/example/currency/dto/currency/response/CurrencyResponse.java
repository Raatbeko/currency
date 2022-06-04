package com.example.currency.dto.currency.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CurrencyResponse {

    String charCode;

    Double nominal;

    String currency_name;

    Double value;
}
