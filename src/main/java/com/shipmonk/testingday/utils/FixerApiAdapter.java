package com.shipmonk.testingday.utils;

import com.shipmonk.testingday.entity.ExchangeRate;
import com.shipmonk.testingday.exceptions.FixerApiException;
import com.shipmonk.testingday.model.ExchangeRateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class FixerApiAdapter {

    private static final String API_KEY_HEADER = "apikey";
    private final RestTemplate restTemplate;

    @Value("${fixer.api.scheme}")
    private String scheme;
    @Value("${fixer.api.host}")
    private String host;
    @Value("${fixer.api.path}")
    private String path;
    @Value("${fixer.api.urlDateParam}")
    private String urlDateParam;
    @Value("${fixer.api.apikey}")
    private String apiKey;

    public ExchangeRate getRates(LocalDate date) throws FixerApiException {
        ExchangeRateDTO exchangeRateDTO = restTemplate.exchange(buildURI(date), HttpMethod.GET, new HttpEntity<>(null, getHeaders()), ExchangeRateDTO.class).getBody();
        if (Objects.isNull(exchangeRateDTO))
            throw new FixerApiException("Response from FIXER API is null");
        return ExchangeRateMapper.toEntity(exchangeRateDTO);
    }

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add(API_KEY_HEADER, apiKey);
        return headers;
    }

    private URI buildURI(LocalDate date) {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put(urlDateParam, date.toString());
        return UriComponentsBuilder.newInstance()
            .scheme(scheme)
            .host(host)
            .path(path)
            .buildAndExpand(urlParams)
            .toUri();
    }
}
