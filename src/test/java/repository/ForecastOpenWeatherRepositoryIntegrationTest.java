package repository;

import model.ForecastWeather;
import org.junit.Test;


import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;

public class ForecastOpenWeatherRepositoryIntegrationTest {

    @Test
    public void shouldReturnCityLondon() throws IOException {
        ForecastOpenWeatherRepository forecastOpenWeatherRepository = new ForecastOpenWeatherRepository();
        ForecastWeather response = forecastOpenWeatherRepository.getData("London");

        assertThat(response.getCity(), is(equalTo("London")));
        assertThat(response.getAverageDaily(), greaterThan(0.0));
        assertThat(response.getAverageNightly(), greaterThan(0.0));
        assertThat(response.getAveragePressure(), greaterThan(0.0));
    }

    @Test
    public void shouldReturnCityBeloHorizonte() throws IOException {
        ForecastOpenWeatherRepository forecastOpenWeatherRepository = new ForecastOpenWeatherRepository();
        ForecastWeather response = forecastOpenWeatherRepository.getData("Belo Horizonte");

        assertThat(response.getCity(), is(equalTo("Belo Horizonte")));
        assertThat(response.getAverageDaily(), greaterThan(0.0));
        assertThat(response.getAverageNightly(), greaterThan(0.0));
        assertThat(response.getAveragePressure(), greaterThan(0.0));
    }
}
