package com.project.CurrencyExchangeService.controller;

import com.project.CurrencyExchangeService.model.Currencies;
import com.project.CurrencyExchangeService.service.CurrencyService;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/api/")
public class CurrencyController {
    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @PostMapping("convert")
    public String currencyConverter(@RequestParam("from") Currencies from,
                                    @RequestParam("to") Currencies to,
                                    @RequestParam("amount") Double amount) {
        return currencyService.converter(from, to, amount);
    }

    @GetMapping("rates")
    public Map<String, Double> currencyRates(){
        return currencyService.rates();
    }
}
