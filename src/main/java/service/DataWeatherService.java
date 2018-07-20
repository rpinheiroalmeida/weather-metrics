package service;

import repository.ListDataWeather;
import repository.ForecastOpenWeatherRepository;
import repository.ForecastRepository;
import repository.ForecastOpenWeatherResponse;

import java.io.IOException;
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
        ForecastOpenWeatherResponse response = forecastRepository.getData(city);


        OptionalDouble averageDaily = response.getDataWeather().parallelStream()
                .filter(ListDataWeather::isDailyTemperature)
                .mapToDouble(ListDataWeather::getTemperature).average();
        OptionalDouble averageNightly = response.getDataWeather().stream()
                .filter(ListDataWeather::isNightlyTemperature)
                .mapToDouble(ListDataWeather::getTemperature).average();
        OptionalDouble averagePressure = response.getDataWeather().stream()
                .mapToDouble(ListDataWeather::getPressure).average();


        return new AverageWeather(averageDaily.getAsDouble(), averageNightly.getAsDouble(),
                averagePressure.getAsDouble());
    }
}
