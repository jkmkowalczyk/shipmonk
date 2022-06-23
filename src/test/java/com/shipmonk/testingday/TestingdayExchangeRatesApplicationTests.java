package com.shipmonk.testingday;

import com.shipmonk.testingday.repository.ExchangeRatesRepository;
import com.shipmonk.testingday.service.ExchangeRatesService;
import com.shipmonk.testingday.utils.FixerApiAdapter;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class ExchangeRatesServiceTest {

    @InjectMocks
    ExchangeRatesService exchangeRatesService;
    @Mock
    ExchangeRatesRepository exchangeRatesRepository;
    @Mock
    FixerApiAdapter fixerApiAdapter;

//    @Test
//    void shouldCallFixerApiWhenExchangeRateNotFound() {
//        LocalDate date = LocalDate.now();
//        when(exchangeRatesRepository.findByDate(date)).thenReturn(Optional.empty());
//        exchangeRatesService.getRates(date);
//        verify(fixerApiAdapter, times(1)).getRates(date);
//    }
//
//    @Test
//    @Ignore
//    void shouldNotCallFixerApiWhenExchangeRateIsFoundInDatabase() {
//        LocalDate date = LocalDate.now();
//        when(exchangeRatesRepository.findByDate(date)).thenReturn(Optional.of(mock(ExchangeRate.class)));
//        exchangeRatesService.getRates(date);
//        verify(fixerApiAdapter, times(0)).getRates(any());
//    }

}
