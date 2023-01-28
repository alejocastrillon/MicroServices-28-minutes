package com.alejocastr.microservices.currencyexchangeservice.ports;

import com.alejocastr.microservices.currencyexchangeservice.domain.CurrencyExchange;
import com.alejocastr.microservices.currencyexchangeservice.domain.repository.CurrencyExchangeRepository;
import com.alejocastr.microservices.currencyexchangeservice.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CurrencyExchangeService {

    private final CurrencyExchangeRepository repository;

    public CurrencyExchange retrieveCurrencyExchange(String from, String to) {
        return repository.findFirstByFromIgnoreCaseAndToIgnoreCaseOrderByIdDesc(from, to).orElseThrow(
                () -> new NotFoundException(String.format("Currency exchange not found %s to %s",
                        from, to)));
    }

}
