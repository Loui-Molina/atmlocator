package com.louimolina.controller;

import com.louimolina.model.ATM;
import com.louimolina.service.ATMLocatorService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;

import java.util.List;

@Controller("/atmlocatordemo/v1.0")
public class ATMLocatorController {

    @Inject
    ATMLocatorService atmLocatorService;

    @Post(uri = "/search", processes = MediaType.APPLICATION_JSON)
    public List<ATM> getATMs(@Body ATM atm) {
        return atmLocatorService.getMatchingATMs(atm);
    }
}