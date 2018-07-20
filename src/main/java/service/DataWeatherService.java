package service;

import repository.DateWeather;
import repository.ForecastOpenWeatherRepository;
import repository.ForecastRepository;
import repository.ForecastResponse;

import java.io.IOException;

public class DataWeatherService {


    private ForecastRepository forecastRepository;

    public DataWeatherService() {
        this.forecastRepository = new ForecastOpenWeatherRepository();
    }

    public DataWeatherService(ForecastRepository forecastRepository) {
        this.forecastRepository = forecastRepository;
    }


    public AverageWeather calculateAverage(String city) throws IOException {
        //1. Get the response from service
        //2. A partir do objeto calcular a média da pressão
        ForecastResponse response = forecastRepository.getData(city);
        double sumAverage = 0.0;
        double sumDailyTemperature = 0.0;
        double sumNightlyTemperature = 0.0;
        int size = response.getDataWeather().size();
        for (DateWeather data: response.getDataWeather()) {
            sumAverage += data.getPressure();
            sumDailyTemperature += data.getTemperature();
            sumNightlyTemperature += data.getTemperature();
        }

        return new AverageWeather(sumDailyTemperature / size, sumNightlyTemperature / size, sumAverage / size);
    }
}
