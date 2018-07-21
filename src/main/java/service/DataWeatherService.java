package service;

import http.HttpOpenWeatherRequest;
import model.ForecastWeather;
import presentation.WeatherView;
import repository.ForecastOpenWeatherRepository;
import repository.ForecastOpenWeatherResponse;
import repository.ForecastRepository;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class DataWeatherService {


    private ForecastRepository forecastRepository;
    private static final int MAX_ENTRIES = 1000;

    private Map<String, WeatherView> cache = new LinkedHashMap<String, WeatherView>(MAX_ENTRIES + 1, .75F, true) {

        public boolean removeEldestEntry(Map.Entry<String, WeatherView> eldest) {
            return size() > MAX_ENTRIES;
        }
    };

    public DataWeatherService() {
        this.forecastRepository = new ForecastOpenWeatherRepository(new HttpOpenWeatherRequest());
    }

    public WeatherView calculateAverage(String city) throws IOException {

        if (cache.containsKey(city)) {
            return cache.get(city);
        } else {
            ForecastWeather forecastWeather = forecastRepository.getData(city);

            double averageDaily = forecastWeather.getAverageDaily();
            double averageNightly = forecastWeather.getAverageNightly();
            double averagePressure = forecastWeather.getAveragePressure();


            WeatherView weatherView = new WeatherView(averageDaily, averageNightly, averagePressure, forecastWeather.getCity());
            cache.put(city, weatherView);

            return weatherView;
        }

    }
}
