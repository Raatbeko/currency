package com.example.currency.entity;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "currency")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Currency extends BaseEntity {

    @Column(name = "char_code", nullable = false, unique = true)
    String charCode;

    @Column(name = "nominal")
    Long nominal;

    @Column(name = "currency_name", nullable = false, unique = false)
    String currency_name;

    @Column(name = "value_to_kgz")
    Double value;

}
