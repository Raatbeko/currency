package com.example.currency.repository;

import com.example.currency.dto.currency.request.CurrencyRequest;
import com.example.currency.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {

    Optional<Currency> findByCharCode(String charCode);

    @Modifying
    @Query(nativeQuery = true,value = "UPDATE currency c " +
            "c.value_to_KGZ =:value" +
            "WHERE c.id =:id")
    Integer updateToValue(Long id,Double value);


}
