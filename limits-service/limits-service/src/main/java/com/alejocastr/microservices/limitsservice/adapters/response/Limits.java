package com.alejocastr.microservices.limitsservice.adapters.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Limits {

    private int minimum;
    private int maximum;

}
