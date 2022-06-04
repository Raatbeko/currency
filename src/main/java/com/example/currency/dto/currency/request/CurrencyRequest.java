package com.example.currency.dto.currency.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CurrencyRequest {
    @NotEmpty
    String charCode;

    @NotNull
    Double nominal;

    @NotEmpty
    String currency_name;

    @NotNull
    Double value;
}
