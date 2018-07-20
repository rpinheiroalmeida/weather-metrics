package service;

import repository.DateWeather;
import repository.ForecastOpenWeatherRepository;
import repository.ForecastRepository;
import repository.ForecastResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.OptionalDouble;

public class DataWeatherService {


    private ForecastRepository forecastRepository;

    public DataWeatherService() {
        this.forecastRepository = new ForecastOpenWeatherRepository();
    }

    public DataWeatherService(ForecastRepository forecastRepository) {
        this.forecastRepository = forecastRepository;
    }


    public AverageWeather calculateAverage(String city) throws IOException {
        ForecastResponse response = forecastRepository.getData(city);


        OptionalDouble averageDaily = response.getDataWeather().parallelStream()
                .filter(DateWeather::isDailyTemperature)
                .mapToDouble(DateWeather::getTemperature).average();
        OptionalDouble averageNightly = response.getDataWeather().stream()
                .filter(DateWeather::isNightlyTemperature)
                .mapToDouble(DateWeather::getTemperature).average();
        OptionalDouble averagePressure = response.getDataWeather().stream()
                .mapToDouble(DateWeather::getPressure).average();


        return new AverageWeather(averageDaily.getAsDouble(), averageNightly.getAsDouble(),
                averagePressure.getAsDouble());
    }
}
