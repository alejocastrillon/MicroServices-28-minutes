package com.alejocastr.microservices.currencyexchangeservice.domain.repository;

import com.alejocastr.microservices.currencyexchangeservice.domain.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

    Optional<CurrencyExchange> findFirstByFromIgnoreCaseAndToIgnoreCaseOrderByIdDesc(String from,
                                                                                     String to);

}
