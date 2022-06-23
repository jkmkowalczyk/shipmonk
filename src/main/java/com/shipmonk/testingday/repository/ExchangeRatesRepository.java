package com.shipmonk.testingday.repository;

import com.shipmonk.testingday.entity.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface ExchangeRatesRepository extends JpaRepository<ExchangeRate, Long> {
    Optional<ExchangeRate> findByDate(LocalDate date);
}
