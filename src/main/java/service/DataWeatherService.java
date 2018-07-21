package service;

import exception.WeatherException;
import http.HttpOpenWeatherRequest;
import model.ForecastWeather;
import presentation.WeatherView;
import repository.ForecastOpenWeatherRepository;
import repository.ForecastRepository;

import java.io.IOException;

public class DataWeatherService {


    private ForecastRepository forecastRepository;

    public DataWeatherService() {
        this.forecastRepository = new ForecastOpenWeatherRepository(new HttpOpenWeatherRequest());
    }

    public WeatherView calculateAverage(String city) throws IOException, WeatherException {
        ForecastWeather forecastWeather = forecastRepository.getData(city);

        double averageDaily = forecastWeather.getAverageDaily();
        double averageNightly = forecastWeather.getAverageNightly();
        double averagePressure = forecastWeather.getAveragePressure();


        return new WeatherView(averageDaily, averageNightly, averagePressure, forecastWeather.getCity());
    }
}
