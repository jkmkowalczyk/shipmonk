package com.shipmonk.testingday.service;

import com.shipmonk.testingday.entity.ExchangeRate;
import com.shipmonk.testingday.model.ExchangeRateDTO;
import com.shipmonk.testingday.repository.ExchangeRatesRepository;
import com.shipmonk.testingday.utils.ExchangeRateMapper;
import com.shipmonk.testingday.utils.FixerApiAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ExchangeRatesService {

    private final ExchangeRatesRepository exchangeRatesRepository;
    private final FixerApiAdapter fixerApiAdapter;

    /**
     * Retrieves rates for selected date. Either cached from database or fetched from Fixer API.
     *
     * @param date date to fetch rates
     * @return exchange rate response
     */
    public ExchangeRateDTO getRates(LocalDate date) {
        ExchangeRate exchangeRate = exchangeRatesRepository.findByDate(date)
            .orElseGet(() -> exchangeRatesRepository.save(fixerApiAdapter.getRates(date)));
        return ExchangeRateMapper.toDTO(exchangeRate);
    }
}
