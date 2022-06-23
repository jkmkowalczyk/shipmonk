package com.shipmonk.testingday.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity
@Table(name = "exchange_rate")
public class ExchangeRate extends AbstractEntity {

    @Column(name = "date")
    private LocalDate date;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,
        mappedBy = "exchangeRate")
    @OrderBy("currency")
    private List<Rate> rates;

    public Map<String, BigDecimal> ratesToMap() {
        Map<String, BigDecimal> map = new TreeMap<>();
        rates.forEach(o -> map.put(o.getCurrency(), o.getCurrencyRate()));
        return map;
    }

    public void addRate(Rate rate) {
        if (rate != null) {
            if (rates == null) {
                rates = new ArrayList<>();
            }
            rates.add(rate);
            rate.setExchangeRate(this);
        }
    }
}
