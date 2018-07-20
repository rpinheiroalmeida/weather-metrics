package service;

import model.ForecastWeather;
import presentation.AverageWeather;
import presentation.WeatherView;
import repository.ForecastOpenWeatherRepository;
import repository.ForecastRepository;

import java.io.IOException;

public class DataWeatherService {


    private ForecastRepository forecastRepository;

    public DataWeatherService() {
        this.forecastRepository = new ForecastOpenWeatherRepository();
    }



    public WeatherView calculateAverage(String city) throws IOException {
        ForecastWeather forecastWeather = forecastRepository.getData(city);

        double averageDaily = forecastWeather.getAverageDaily();
        double averageNightly = forecastWeather.getAverageNightly();
        double averagePressure = forecastWeather.getAveragePressure();


        return new WeatherView(averageDaily, averageNightly, averagePressure);
    }
}
