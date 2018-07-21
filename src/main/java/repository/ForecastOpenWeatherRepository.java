package repository;

import com.google.gson.Gson;
import http.HttpOpenWeatherRequest;
import model.ForecastWeather;

import java.io.IOException;
import java.time.Instant;

public class ForecastOpenWeatherRepository implements ForecastRepository {

    private HttpOpenWeatherRequest request;


    public ForecastOpenWeatherRepository(HttpOpenWeatherRequest request) {
        this.request = request;
    }


    public ForecastWeather getData(String city) throws IOException {
        String response = request.getResponseContent(city);
        ForecastOpenWeatherResponse forecastOpenWeatherResponse = new Gson()
                .fromJson(response, ForecastOpenWeatherResponse.class);

        return ForecastWeather.of(forecastOpenWeatherResponse, Instant.now().getEpochSecond());
    }
}
