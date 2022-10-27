package com.alejocastr.microservices.currencyexchangeservice.adapters;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/sample-api")
@Slf4j
public class CircuitBreakerController {

    @GetMapping
    //@Retry(name = "sample-api", fallbackMethod = "hardcodeResponse")
    //@CircuitBreaker(name = "sample-api", fallbackMethod = "hardcodeResponse")
    //@RateLimiter(name = "default")
    @Bulkhead(name = "default")
    public ResponseEntity<String> sampleApi() {
        log.info("Sample API call received");
        /*ResponseEntity<String> forEntity = new RestTemplate()
                .getForEntity("http://localhost:8080/some-dummy", String.class);*/
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    public ResponseEntity<String> hardcodeResponse(Exception ex) {
        return new ResponseEntity<>("fallback-response", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
