package repository;

import com.google.gson.Gson;
import exception.WeatherException;
import http.HttpOpenWeatherRequest;
import model.ForecastWeather;

import java.io.IOException;


public class ForecastOpenWeatherRepository implements ForecastRepository {

    private HttpOpenWeatherRequest request;

    public ForecastOpenWeatherRepository(HttpOpenWeatherRequest request) {
        this.request = request;
    }


    public ForecastWeather getData(String city) throws IOException, WeatherException {
        String response = request.getResponseContent(city);
        ForecastOpenWeatherResponse forecastOpenWeatherResponse = new Gson()
                .fromJson(response, ForecastOpenWeatherResponse.class);

        if (forecastOpenWeatherResponse.getStatusResponse() == 401) {
            throw  new WeatherException("Error to get the data from OpenWeatherMap.", forecastOpenWeatherResponse.getStatusResponse());
        }

        return ForecastWeather.of(forecastOpenWeatherResponse);
    }
}
