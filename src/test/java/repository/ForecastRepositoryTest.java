package repository;

import org.junit.Test;


import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class ForecastRepositoryTest {

    @Test
    public void shouldReturnCityLondon() throws IOException {
        ForecastRepository forecastRepository = new ForecastRepository();
        ForecastResponse response = forecastRepository.getData("London");

        City cityExpected = new City()
                .withName("London")
                .withId(2643743)
                .withCountry("GB");

        assertThat(response.getStatusResponse(), is(200));
        assertThat(cityExpected, is(equalTo(response.getCity())));
    }
}
