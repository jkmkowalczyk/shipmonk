package com.shipmonk.testingday.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeRateDTO implements Serializable {
    private static final String BASE_CURRENCY = "EUR";

    @Builder.Default
    private boolean success = true;
    private Long timestamp;
    @Builder.Default
    private boolean historical = true;
    @Builder.Default
    private String base = "EUR";
    private LocalDate date;
    private Map<String, BigDecimal> rates;
}
