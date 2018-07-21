package model;


import repository.ForecastOpenWeatherResponse;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;

public class ForecastWeather {

    private final String city;
    private final double averageDaily;
    private final double averageNightly;
    private final double averagePressure;



    public ForecastWeather(double averageDaily, double averageNightly, double averagePressure, String cityName) {
        this.averageDaily = averageDaily;
        this.averageNightly = averageNightly;
        this.averagePressure = averagePressure;
        this.city = cityName;
    }


    public static boolean isInTheNextThreeDays(long date) {
        LocalDateTime ldt = LocalDateTime.ofInstant(Instant.ofEpochSecond(date), ZoneOffset.UTC);
        LocalDateTime ldtNow = LocalDateTime.now();
        return ldtNow.getDayOfMonth() + 3 >= ldt.getDayOfMonth() ;
    }


    public static ForecastWeather of(ForecastOpenWeatherResponse forecastOpenWeatherResponse) {
        List<WeatherMainData> data = forecastOpenWeatherResponse.getDataWeather()
                .stream()
                .filter(listDataWeather -> isInTheNextThreeDays(listDataWeather.getDate()))
                .map(listDataWeather -> new WeatherMainData(listDataWeather.getTemperature(),
                        listDataWeather.getPressure(),
                        listDataWeather.getDate())).collect(Collectors.toList());

        double averageDaily = data.stream()
                .filter(WeatherMainData::isDailyTemperature)
                .mapToDouble(WeatherMainData::getTemperature)
                .average().orElse(0.0);

        double averageNightly = data.stream()
                .filter(WeatherMainData::isNightlyTemperature)
                .mapToDouble(WeatherMainData::getTemperature)
                .average().orElse(0.0);

        double averagePressure = data.stream()
                .mapToDouble(WeatherMainData::getPressure)
                .average().orElse(0.0);

        return new ForecastWeather(averageDaily, averageNightly, averagePressure,
                forecastOpenWeatherResponse.getCityName());
    }

    public String getCity() {
        return city;
    }

    public double getAverageDaily() {
        return averageDaily;
    }

    public double getAverageNightly() {
        return averageNightly;
    }

    public double getAveragePressure() {
        return averagePressure;
    }
}
