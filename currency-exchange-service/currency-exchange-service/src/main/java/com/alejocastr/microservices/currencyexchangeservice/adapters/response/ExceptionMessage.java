package com.alejocastr.microservices.currencyexchangeservice.adapters.response;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class ExceptionMessage {

    private Date timestamp = new Date();
    @NonNull
    private String error;
    private List<String> details;

}
