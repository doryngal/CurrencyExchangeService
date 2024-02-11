package com.project.CurrencyExchangeService.service;


import com.project.CurrencyExchangeService.model.Currencies;
import com.project.CurrencyExchangeService.model.ExchangeRateResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.DecimalFormat;
import java.util.Map;

@Service
public class CurrencyService {
    @Value("${external.api.url}")
    private String apiUrl;
    public String converter(Currencies from, Currencies to, Double amount) {
        String url = apiUrl + from.toString();

        RestTemplate restTemplate = new RestTemplate();
        ExchangeRateResponse exchangeRateResponse = restTemplate.getForObject(url, ExchangeRateResponse.class);

        assert exchangeRateResponse != null;
        Double convertedCurrency = exchangeRateResponse.getConversion_rates().get(to.toString());

        Double result = convertedCurrency * amount;
        DecimalFormat formatter = new DecimalFormat("#.##");

        return formatter.format(result);
    }

    public Map<String, Double> rates() {
        String url = apiUrl + "USD";

        RestTemplate restTemplate = new RestTemplate();
        ExchangeRateResponse exchangeRateResponse = restTemplate.getForObject(url, ExchangeRateResponse.class);

        assert exchangeRateResponse != null;
        return exchangeRateResponse.getConversion_rates();
    }

}
