package repository;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ListDataWeatherTest {

    @Test
    public void isDailyTemperature() {
        ListDataWeather listDataWeatherAt15Hour = new ListDataWeather()
                .withDate(1532185200)
                .withDateFormatTxt("2018-07-21 15:00:00")
                .withPressure(927.28)
                .withTemperature(293.28);

        ListDataWeather listDataWeatherAt18Hour = new ListDataWeather()
                .withDate(1532196000)
                .withDateFormatTxt("2018-07-21 18:00:00")
                .withPressure(927.28)
                .withTemperature(293.28);

        assertThat(listDataWeatherAt15Hour.isDailyTemperature(), is(true));
        assertThat(listDataWeatherAt18Hour.isDailyTemperature(), is(true));
    }

    @Test
    public void isNightlyTemperature() {
        ListDataWeather listDataWeatherAt21Hour = new ListDataWeather()
                .withDate(1532206800)
                .withDateFormatTxt("2018-07-21 21:00:00")
                .withPressure(927.28)
                .withTemperature(293.28);
        ListDataWeather listDataWeatherAtMiddleNight = new ListDataWeather()
                .withDate(1532217600)
                .withDateFormatTxt("2018-07-21 00:00:00")
                .withPressure(927.28)
                .withTemperature(293.28);

        assertThat(listDataWeatherAt21Hour.isNightlyTemperature(), is(true));
        assertThat(listDataWeatherAtMiddleNight.isNightlyTemperature(), is(true));
    }
}