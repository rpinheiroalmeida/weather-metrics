package repository;


import com.google.gson.Gson;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ForecastDataWheaterConverterTest {

    private static final String RESPONSE_WITH_ONE_LINE = "{\n" +
            "    \"cod\": \"200\",\n" +
            "    \"message\": 0.0063,\n" +
            "    \"cnt\": 1,\n" +
            "    \"list\": [\n" +
            "        {\n" +
            "            \"dt\": 1532109600,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 292.54,\n" +
            "                \"temp_min\": 290.724,\n" +
            "                \"temp_max\": 292.54,\n" +
            "                \"pressure\": 1019.61,\n" +
            "                \"sea_level\": 1026.89,\n" +
            "                \"grnd_level\": 1019.61,\n" +
            "                \"humidity\": 88,\n" +
            "                \"temp_kf\": 1.82\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 500,\n" +
            "                    \"main\": \"Rain\",\n" +
            "                    \"description\": \"light rain\",\n" +
            "                    \"icon\": \"10d\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 100\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 1.57,\n" +
            "                \"deg\": 168\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 2.2875\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"d\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2018-07-20 18:00:00\"\n" +
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
            "}";

    @Test
    public void shouldConvertToForecastResponseObjectWithOneNumberLine() {
        ForecastOpenWeatherResponse forecastOpenWeatherResponseActual = new ForecastOpenWeatherResponse()
                .withCode(200)
                .withNumberLines(1)
                .withMessage("0.0063")
                .withCity(new City()
                                .withId(2643743)
                                .withName("London")
                                .withCountry("GB"))
                .add(new ListDataWeather()
                            .withDate(1532109600)
                            .withTemperature(292.54)
                            .withPressure(1019.61)
                            .withDateFormatTxt("2018-07-20 18:00:00"));

        ForecastOpenWeatherResponse forecastOpenWeatherResponseExpected = new Gson().fromJson(RESPONSE_WITH_ONE_LINE, ForecastOpenWeatherResponse.class);

        assertThat(forecastOpenWeatherResponseExpected, is(equalTo(forecastOpenWeatherResponseActual)));
    }

    private static final String RESPONSE_WITH_TWO_LINES = "{\n" +
            "    \"cod\": \"200\",\n" +
            "    \"message\": 0.0367,\n" +
            "    \"cnt\": 2,\n" +
            "    \"list\": [\n" +
            "        {\n" +
            "            \"dt\": 1532109600,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 292.1,\n" +
            "                \"temp_min\": 290.724,\n" +
            "                \"temp_max\": 292.1,\n" +
            "                \"pressure\": 1019.61,\n" +
            "                \"sea_level\": 1026.89,\n" +
            "                \"grnd_level\": 1019.61,\n" +
            "                \"humidity\": 88,\n" +
            "                \"temp_kf\": 1.38\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 500,\n" +
            "                    \"main\": \"Rain\",\n" +
            "                    \"description\": \"light rain\",\n" +
            "                    \"icon\": \"10d\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 100\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 1.57,\n" +
            "                \"deg\": 168\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 2.2875\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"d\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2018-07-20 18:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1532120400,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 290.4,\n" +
            "                \"temp_min\": 289.362,\n" +
            "                \"temp_max\": 290.4,\n" +
            "                \"pressure\": 1019.85,\n" +
            "                \"sea_level\": 1027.12,\n" +
            "                \"grnd_level\": 1019.85,\n" +
            "                \"humidity\": 97,\n" +
            "                \"temp_kf\": 1.03\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 501,\n" +
            "                    \"main\": \"Rain\",\n" +
            "                    \"description\": \"moderate rain\",\n" +
            "                    \"icon\": \"10n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 92\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 1.31,\n" +
            "                \"deg\": 118.503\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 3.98\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2018-07-20 21:00:00\"\n" +
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
            "}";

    @Test
    public void shouldConvertToForecastResponseObjectWithTwoNumberLine() {
        ForecastOpenWeatherResponse forecastOpenWeatherResponseActual = new ForecastOpenWeatherResponse()
                .withCode(200)
                .withNumberLines(2)
                .withMessage("0.0367")
                .withCity(new City()
                        .withId(2643743)
                        .withName("London")
                        .withCountry("GB"))
                .add(new ListDataWeather()
                        .withDate(1532109600)
                        .withTemperature(292.1)
                        .withPressure(1019.61)
                        .withDateFormatTxt("2018-07-20 18:00:00"))
                .add(new ListDataWeather()
                        .withDate(1532120400)
                        .withTemperature(290.4)
                        .withPressure(1019.85)
                        .withDateFormatTxt("2018-07-20 21:00:00"));

        ForecastOpenWeatherResponse forecastOpenWeatherResponseExpected = new Gson().fromJson(RESPONSE_WITH_TWO_LINES,
                ForecastOpenWeatherResponse.class);

        assertThat(forecastOpenWeatherResponseExpected, is(equalTo(forecastOpenWeatherResponseActual)));
    }

    private static final String RESPONSE_WITH_ACCESS_LIMITATION = "{\n" +
            "\"cod\": 429,\n" +
            "\"message\": \"Your account is temporary blocked due to exceeding of requests limitation of your subscription type. Please choose the proper subscription http://openweathermap.org/price\"\n" +
            "}";

    @Test
    public void shouldConvertToForecastResponseWithAccessLimitation() {
        ForecastOpenWeatherResponse forecastOpenWeatherResponseExpected = new Gson().fromJson(RESPONSE_WITH_ACCESS_LIMITATION,
                ForecastOpenWeatherResponse.class);

        ForecastOpenWeatherResponse forecastOpenWeatherResponseActual = new ForecastOpenWeatherResponse()
                .withCode(429)
                .withMessage("Your account is temporary blocked due to exceeding of requests limitation of your subscription type. Please choose the proper subscription http://openweathermap.org/price");

        assertThat(forecastOpenWeatherResponseExpected, is(equalTo(forecastOpenWeatherResponseActual)));

    }

    private static final String RESPONSE_WITH_INVALID_API_KEY = "{\n" +
            "    \"cod\": 401,\n" +
            "    \"message\": \"Invalid API key. Please see http://openweathermap.org/faq#error401 for more info.\"\n" +
            "}";

    @Test
    public void shouldConvertToForecastResponseWithInvalidApiKey() {
        ForecastOpenWeatherResponse forecastOpenWeatherResponseExpected = new Gson().fromJson(RESPONSE_WITH_INVALID_API_KEY,
                ForecastOpenWeatherResponse.class);

        ForecastOpenWeatherResponse forecastOpenWeatherResponseActual = new ForecastOpenWeatherResponse()
                .withCode(401)
                .withMessage("Invalid API key. Please see http://openweathermap.org/faq#error401 for more info.");

        assertThat(forecastOpenWeatherResponseExpected, is(equalTo(forecastOpenWeatherResponseActual)));

    }
}
