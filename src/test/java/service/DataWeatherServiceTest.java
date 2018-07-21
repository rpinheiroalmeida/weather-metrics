package service;

import model.ForecastWeather;
import org.junit.Test;
import presentation.WeatherView;
import repository.ForecastRepository;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class DataWeatherServiceTest {

    private ForecastRepository forecastRepository = mock(ForecastRepository.class);
    private DataWeatherService dataWeatherService = new DataWeatherService(forecastRepository);

    @Test
    public void shouldCalculteAverageWeatherSucess() throws IOException {
        when(forecastRepository.getData("London")).thenReturn(new ForecastWeather(10.0, 10.0, 10.0, "London"));

        WeatherView forecastWeatherExpected = new WeatherView(10.0, 10.0, 10.0, "London");


        assertThat(dataWeatherService.calculateAverage("London"), is(equalTo(forecastWeatherExpected)));
    }

    @Test
    public void shouldUseCacheToReturnAverageWeatherData() throws IOException {
        when(forecastRepository.getData("London")).thenReturn(new ForecastWeather(10.0, 10.0, 10.0, "London"));

        WeatherView forecastWeatherExpected = new WeatherView(10.0, 10.0, 10.0, "London");

        assertThat(dataWeatherService.calculateAverage("London"), is(equalTo(forecastWeatherExpected)));

        when(forecastRepository.getData("London")).thenReturn(null);
        assertThat(dataWeatherService.calculateAverage("London"), is(equalTo(forecastWeatherExpected)));
    }
}