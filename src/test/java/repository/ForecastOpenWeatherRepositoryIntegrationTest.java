package repository;

import http.HttpOpenWeatherRequest;
import model.ForecastWeather;
import org.apache.http.client.HttpResponseException;
import org.junit.Test;


import java.io.IOException;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ForecastOpenWeatherRepositoryIntegrationTest {

    HttpOpenWeatherRequest mockRequest = mock(HttpOpenWeatherRequest.class);

    @Test
    public void shouldReturnCityLondon() throws IOException {
        ForecastOpenWeatherRepository forecastOpenWeatherRepository = new ForecastOpenWeatherRepository(mockRequest);
        when(mockRequest.getResponseContent("London")).thenReturn("{\n" +
                "    \"cod\": \"200\",\n" +
                "    \"message\": 0.0038,\n" +
                "    \"cnt\": 1,\n" +
                "    \"list\": [\n" +
                "        {\n" +
                "            \"dt\": 1532142000,\n" +
                "            \"main\": {\n" +
                "                \"temp\": 289.45,\n" +
                "                \"temp_min\": 288.27,\n" +
                "                \"temp_max\": 289.45,\n" +
                "                \"pressure\": 1018.74,\n" +
                "                \"sea_level\": 1026.16,\n" +
                "                \"grnd_level\": 1018.74,\n" +
                "                \"humidity\": 97,\n" +
                "                \"temp_kf\": 1.18\n" +
                "            },\n" +
                "            \"weather\": [\n" +
                "                {\n" +
                "                    \"id\": 500,\n" +
                "                    \"main\": \"Rain\",\n" +
                "                    \"description\": \"light rain\",\n" +
                "                    \"icon\": \"10n\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"clouds\": {\n" +
                "                \"all\": 88\n" +
                "            },\n" +
                "            \"wind\": {\n" +
                "                \"speed\": 1.37,\n" +
                "                \"deg\": 86.5025\n" +
                "            },\n" +
                "            \"rain\": {\n" +
                "                \"3h\": 0.19\n" +
                "            },\n" +
                "            \"sys\": {\n" +
                "                \"pod\": \"n\"\n" +
                "            },\n" +
                "            \"dt_txt\": \"2018-07-21 03:00:00\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"city\": {\n" +
                "        \"id\": 2643743,\n" +
                "        \"name\": \"London\",\n" +
                "        \"coord\": {\n" +
                "            \"lat\": 51.5073,\n" +
                "            \"lon\": -0.1277\n" +
                "        },\n" +
                "        \"country\": \"GB\",\n" +
                "        \"population\": 1000000\n" +
                "    }\n" +
                "}");

        ForecastWeather response = forecastOpenWeatherRepository.getData("London");

        assertThat(response.getCity(), is(equalTo("London")));
        assertThat("Average Daily", response.getAverageDaily(), is(0.0));
        assertThat("Average Nightly", response.getAverageNightly(), is(289.45));
        assertThat("Average Pressure", response.getAveragePressure(), is(1018.74));
    }

    @Test
    public void shouldReturnCityBeloHorizonte() throws IOException {
        ForecastOpenWeatherRepository forecastOpenWeatherRepository = new ForecastOpenWeatherRepository(mockRequest);
        when(mockRequest.getResponseContent("Belo Horizonte")).thenReturn("{\n" +
                "    \"cod\": \"200\",\n" +
                "    \"message\": 0.0023,\n" +
                "    \"cnt\": 1,\n" +
                "    \"list\": [\n" +
                "        {\n" +
                "            \"dt\": 1532142000,\n" +
                "            \"main\": {\n" +
                "                \"temp\": 287.28,\n" +
                "                \"temp_min\": 283.97,\n" +
                "                \"temp_max\": 287.28,\n" +
                "                \"pressure\": 929.09,\n" +
                "                \"sea_level\": 1033.7,\n" +
                "                \"grnd_level\": 929.09,\n" +
                "                \"humidity\": 88,\n" +
                "                \"temp_kf\": 3.31\n" +
                "            },\n" +
                "            \"weather\": [\n" +
                "                {\n" +
                "                    \"id\": 800,\n" +
                "                    \"main\": \"Clear\",\n" +
                "                    \"description\": \"clear sky\",\n" +
                "                    \"icon\": \"01n\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"clouds\": {\n" +
                "                \"all\": 0\n" +
                "            },\n" +
                "            \"wind\": {\n" +
                "                \"speed\": 1.37,\n" +
                "                \"deg\": 97.5025\n" +
                "            },\n" +
                "            \"sys\": {\n" +
                "                \"pod\": \"n\"\n" +
                "            },\n" +
                "            \"dt_txt\": \"2018-07-21 03:00:00\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"city\": {\n" +
                "        \"id\": 3470127,\n" +
                "        \"name\": \"Belo Horizonte\",\n" +
                "        \"coord\": {\n" +
                "            \"lat\": -19.9228,\n" +
                "            \"lon\": -43.9451\n" +
                "        },\n" +
                "        \"country\": \"BR\",\n" +
                "        \"population\": 2373224\n" +
                "    }\n" +
                "}");

        ForecastWeather response = forecastOpenWeatherRepository.getData("Belo Horizonte");

        assertThat(response.getCity(), is(equalTo("Belo Horizonte")));
        assertThat(response.getAverageDaily(), is(0.0));
        assertThat(response.getAverageNightly(), is(287.28));
        assertThat(response.getAveragePressure(), is(929.09));
    }


    @Test(expected = HttpResponseException.class)
    public void shouldThrowExceptionWhenOpenWeatherReturnInvalidApiKeyError() throws IOException {
        when(mockRequest.getResponseContent("Belo Horizonte")).thenThrow(HttpResponseException.class);

        ForecastOpenWeatherRepository forecastOpenWeatherRepository = new ForecastOpenWeatherRepository(mockRequest);
        forecastOpenWeatherRepository.getData("Belo Horizonte");
    }


}
