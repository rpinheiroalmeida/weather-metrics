package repository;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DateWeatherTest {

    @Test
    public void isDailyTemperature() {
        DateWeather dateWeatherAt15Hour = new DateWeather()
                .withDate(1532185200)
                .withDateFormatTxt("2018-07-21 15:00:00")
                .withPressure(927.28)
                .withTemperature(293.28);

        DateWeather dateWeatherAt18Hour = new DateWeather()
                .withDate(1532196000)
                .withDateFormatTxt("2018-07-21 18:00:00")
                .withPressure(927.28)
                .withTemperature(293.28);

        assertThat(dateWeatherAt15Hour.isDailyTemperature(), is(true));
        assertThat(dateWeatherAt18Hour.isDailyTemperature(), is(true));
    }

    @Test
    public void isNightlyTemperature() {
        DateWeather dateWeatherAt21Hour = new DateWeather()
                .withDate(1532206800)
                .withDateFormatTxt("2018-07-21 21:00:00")
                .withPressure(927.28)
                .withTemperature(293.28);
        DateWeather dateWeatherAtMiddleNight = new DateWeather()
                .withDate(1532217600)
                .withDateFormatTxt("2018-07-21 00:00:00")
                .withPressure(927.28)
                .withTemperature(293.28);

        assertThat(dateWeatherAt21Hour.isNightlyTemperature(), is(true));
        assertThat(dateWeatherAtMiddleNight.isNightlyTemperature(), is(true));
    }
}