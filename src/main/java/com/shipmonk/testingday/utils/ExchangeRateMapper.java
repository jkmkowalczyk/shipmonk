package com.shipmonk.testingday.utils;

import com.shipmonk.testingday.entity.ExchangeRate;
import com.shipmonk.testingday.entity.Rate;
import com.shipmonk.testingday.model.ExchangeRateDTO;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class ExchangeRateMapper {
    public ExchangeRate toEntity(ExchangeRateDTO exchangeRateDTO) {
        ExchangeRate exchangeRate = ExchangeRate.builder()
            .date(exchangeRateDTO.getDate())
            .build();
        List<Rate> rates = exchangeRateDTO.getRates().entrySet().stream()
            .map(o -> Rate.builder()
                .currency(o.getKey())
                .currencyRate(o.getValue())
                .exchangeRate(exchangeRate)
                .build())
            .toList();
        rates.forEach(exchangeRate::addRate);
        return exchangeRate;
    }

    public ExchangeRateDTO toDTO(ExchangeRate exchangeRate) {
        return ExchangeRateDTO.builder()
            .timestamp(System.currentTimeMillis())
            .date(exchangeRate.getDate())
            .rates(exchangeRate.ratesToMap())
            .build();
    }
}
