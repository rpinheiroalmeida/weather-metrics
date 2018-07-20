package service;

import org.junit.Test;
import repository.*;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class DataWeatherServiceTest {

    private final class ForecastRepositoryStub implements ForecastRepository {

        @Override
        public ForecastResponse getData(String city) throws IOException {
            return new ForecastResponse()
                    .withCode(200)
                    .withNumberLines(2)
                    .withMessage("0.0367")
                    .withCity(new City()
                            .withId(2643743)
                            .withName("London")
                            .withCountry("GB"))
                    .add(new DateWeather()
                            .withDate(1532109600)
                            .withTemperature(292.1)
                            .withPressure(1019.61)
                            .withDateFormatTxt("2018-07-20 18:00:00"))
                    .add(new DateWeather()
                            .withDate(1532120400)
                            .withTemperature(290.4)
                            .withPressure(1019.85)
                            .withDateFormatTxt("2018-07-20 21:00:00"));
        }
    }

    @Test
    public void shouldCalculateAverage() throws IOException {
        DataWeatherService dateWeatherService = new DataWeatherService(new ForecastRepositoryStub());

        AverageWeather averageWeatherActual = dateWeatherService.calculateAverage("London");

        AverageWeather averageWeatherExpected = new AverageWeather(292.1, 290.4, 1019.73);

        assertThat(averageWeatherActual, is(equalTo(averageWeatherExpected)));
    }
}
