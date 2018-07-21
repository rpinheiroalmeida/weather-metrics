package model;

import org.junit.Test;
import repository.ListDataWeather;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class WeatherMainDataTest {

    @Test
    public void isDailyTemperature() {

        assertThat(new WeatherMainData(1.0, 1.0, 1532185200).isDailyTemperature(), is(true));
        assertThat(new WeatherMainData(1.0, 1.0, 1532196000).isDailyTemperature(), is(true));
    }

    @Test
    public void isNightlyTemperature() {
        assertThat(new WeatherMainData(1.0, 1.0, 1532206800).isNightlyTemperature(), is(true));
        assertThat(new WeatherMainData(1.0, 1.0, 1532217600).isNightlyTemperature(), is(true));

    }

}