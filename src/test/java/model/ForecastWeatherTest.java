package model;

import org.hamcrest.Matchers;
import org.junit.Test;
import repository.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ForecastWeatherTest {

    @Test
    public void shouldCalculateAverage() {
        ForecastOpenWeatherResponse response = new ForecastOpenWeatherResponse()
                .withCode(200)
                .withNumberLines(2)
                .withMessage("0.0367")
                .withCity(new City()
                        .withId(2643743)
                        .withName("London")
                        .withCountry("GB"))
                .add(new ListDataWeather()
                        .withDate(1532109600)
                        .withMainDataWeather( new ListDataWeather.MainDataWeather(292.1, 927.28))
                        .withDateFormatTxt("2018-07-20 18:00:00"))
                .add(new ListDataWeather()
                        .withDate(1532120400)
                        .withMainDataWeather( new ListDataWeather.MainDataWeather(290.4, 1019.85))
                        .withDateFormatTxt("2018-07-20 21:00:00"));

        assertThat(292.1, is(ForecastWeather.of(response).getAverageDaily()));
        assertThat(290.4, is(ForecastWeather.of(response).getAverageNightly()));
        assertThat(973.565, is(ForecastWeather.of(response).getAveragePressure()));
    }

    @Test
    public void shouldCalculateAverageOnlyForTheNext3Days() {
        ForecastOpenWeatherResponse response = new ForecastOpenWeatherResponse()
                .withCode(200)
                .withNumberLines(2)
                .withMessage("0.0367")
                .withCity(new City()
                        .withId(2643743)
                        .withName("London")
                        .withCountry("GB"))
                .add(new ListDataWeather()
                        .withDate(1532120400)
                        .withMainDataWeather( new ListDataWeather.MainDataWeather(293.28, 927.28))
                        .withDateFormatTxt("2018-07-20 21:00:00"))
                .add(new ListDataWeather()
                        .withDate(1532163600)
                        .withMainDataWeather( new ListDataWeather.MainDataWeather(281.068, 928.46))
                        .withDateFormatTxt("2018-07-21 09:00:00"))
                .add(new ListDataWeather()
                        .withDate(1532131200)
                        .withMainDataWeather( new ListDataWeather.MainDataWeather(287.66, 928.65))
                        .withDateFormatTxt("2018-07-21 00:00:00"))
                .add(new ListDataWeather()
                        .withDate(1532217600)
                        .withMainDataWeather( new ListDataWeather.MainDataWeather(289.598, 928.19))
                        .withDateFormatTxt("2018-07-22 00:00:00"))
                .add(new ListDataWeather()
                        .withDate(1532304000)
                        .withMainDataWeather( new ListDataWeather.MainDataWeather(287.868, 930.61))
                        .withDateFormatTxt("2018-07-23 00:00:00"))
                .add(new ListDataWeather()
                        .withDate(1532412000)
                        .withMainDataWeather( new ListDataWeather.MainDataWeather(284.929, 931.7))
                        .withDateFormatTxt("2018-07-24 06:00:00"))
                .add(new ListDataWeather()
                        .withDate(1532509200)
                        .withMainDataWeather( new ListDataWeather.MainDataWeather(282.23, 932.28))
                        .withDateFormatTxt("2018-07-25 09:00:00"))
                ;

        assertThat("AverageDaily", ForecastWeather.of(response).getAverageDaily(), is(281.068));
        assertThat("AverageNightly", ForecastWeather.of(response).getAverageNightly(), is(289.6015));
        assertThat("Pressure", ForecastWeather.of(response).getAveragePressure(), is(928.6380000000001));
    }

    @Test
    public void theDataIsInTheNextThreeDays() {
        assertThat(ForecastWeather.isInTheNextThreeDays(1532206800), Matchers.is(true));
        assertThat(ForecastWeather.isInTheNextThreeDays(1532131200), Matchers.is(true));
        assertThat(ForecastWeather.isInTheNextThreeDays(1532217600), Matchers.is(true));
        assertThat(ForecastWeather.isInTheNextThreeDays(1532304000), Matchers.is(true));
    }

    @Test
    public void theDataIsNotInTheNextThreeDays() {
        assertThat(ForecastWeather.isInTheNextThreeDays(1532412000), Matchers.is(false));
        assertThat(ForecastWeather.isInTheNextThreeDays(1532509200), Matchers.is(false));

    }
}
