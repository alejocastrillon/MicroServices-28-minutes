package com.alejocastr.microservices.currencyconversionservice.adapters;

import com.alejocastr.microservices.currencyconversionservice.adapters.response.CurrencyConversion;
import com.alejocastr.microservices.currencyconversionservice.ports.secondary.CurrencyExchangeProxy;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

@RestController
@RequestMapping("/currency-conversion")
@AllArgsConstructor
public class CurrencyConversionController {

    private final RestTemplate restTemplate;

    private final CurrencyExchangeProxy proxy;

    @GetMapping("/from/{from}/to/{to}/quantity/{quantity}")
    public ResponseEntity<CurrencyConversion> calculateCurrencyConversion(@PathVariable String from,
                                                                          @PathVariable String to,
                                                                          @PathVariable BigDecimal quantity) {
        HashMap<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);
        ResponseEntity<CurrencyConversion> response = restTemplate
                .getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                CurrencyConversion.class, uriVariables);
        CurrencyConversion currencyConversion = response.getBody();
        return new ResponseEntity<>(new CurrencyConversion(1000L, from, to, quantity,
                currencyConversion.getConversionMultiple(),
                quantity.multiply(currencyConversion.getConversionMultiple()),
                currencyConversion.getEnvironment()), HttpStatus.OK);
    }

    @GetMapping("/feign/from/{from}/to/{to}/quantity/{quantity}")
    public ResponseEntity<CurrencyConversion> calculateCurrencyConversionFeign(@PathVariable String from,
                                                                          @PathVariable String to,
                                                                          @PathVariable BigDecimal quantity) {
        CurrencyConversion currencyConversion = proxy.retrieveExchangeValue(from, to);
        return new ResponseEntity<>(new CurrencyConversion(1000L, from, to, quantity,
                currencyConversion.getConversionMultiple(),
                quantity.multiply(currencyConversion.getConversionMultiple()),
                currencyConversion.getEnvironment()), HttpStatus.OK);
    }
}
