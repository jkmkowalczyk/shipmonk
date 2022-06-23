package com.shipmonk.testingday.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity
@Table(name = "rate")
public class Rate extends AbstractEntity {
    @Column(name = "currency")
    private String currency;

    @Column(name = "currency_rate")
    private BigDecimal currencyRate;

    @JoinColumn(name = "exchange_rate_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private ExchangeRate exchangeRate;
}
