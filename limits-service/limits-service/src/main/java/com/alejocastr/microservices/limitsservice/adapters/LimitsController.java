package com.alejocastr.microservices.limitsservice.adapters;

import com.alejocastr.microservices.limitsservice.adapters.response.Limits;
import com.alejocastr.microservices.limitsservice.config.LimitConfiguration;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/limits")
@AllArgsConstructor
public class LimitsController {

    private final LimitConfiguration configuration;

    @GetMapping
    public ResponseEntity<Limits> retriveLimits() {
        return new ResponseEntity<>(new Limits(configuration.getMinimum(),
                configuration.getMaximum()), HttpStatus.OK);
    }

}
