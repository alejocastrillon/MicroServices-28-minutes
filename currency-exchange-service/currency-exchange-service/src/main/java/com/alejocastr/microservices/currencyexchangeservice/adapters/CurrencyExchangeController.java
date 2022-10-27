package com.alejocastr.microservices.currencyexchangeservice.adapters;

import com.alejocastr.microservices.currencyexchangeservice.domain.CurrencyExchange;
import com.alejocastr.microservices.currencyexchangeservice.ports.CurrencyExchangeService;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("currency-exchange")
@AllArgsConstructor
public class CurrencyExchangeController {

    private final Environment environment;

    private final CurrencyExchangeService service;

    @GetMapping("/from/{from}/to/{to}")
    public ResponseEntity<CurrencyExchange> retriveExchangeValue(@PathVariable String from,
                                                                 @PathVariable String to) {
        CurrencyExchange currencyExchange = service.retrieveCurrencyExchange(from, to);
        String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);
        return new ResponseEntity<>(currencyExchange, HttpStatus.OK);
    }
}
