package model;


import repository.ForecastOpenWeatherResponse;
import repository.ListDataWeather;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.stream.Stream;

public class ForecastWeather {
    private final Stream<WeatherMainData> dailyWeatherData;
    private final Stream<WeatherMainData> nightlyWeatherData;
    private final Stream<WeatherMainData> allData;
    private final String city;

    public ForecastWeather(Stream<WeatherMainData> dailyWeatherData, Stream<WeatherMainData> nightlyWeatherData, Stream<WeatherMainData> allData, String city) {
        this.dailyWeatherData = dailyWeatherData;
        this.nightlyWeatherData = nightlyWeatherData;
        this.allData = allData;
        this.city = city;
    }


    public static boolean isInTheNextThreeDays(long date) {
        LocalDateTime ldt = LocalDateTime.ofInstant(Instant.ofEpochSecond(date), ZoneOffset.UTC);
        LocalDateTime ldtNow = LocalDateTime.now();
        return ldtNow.getDayOfMonth() + 3 >= ldt.getDayOfMonth() ;
    }


    public static ForecastWeather of(ForecastOpenWeatherResponse forecastOpenWeatherResponse) {
        Stream<WeatherMainData> nightlyWeatherData = forecastOpenWeatherResponse.getDataWeather()
                .stream()
                .filter(listDataWeather -> isInTheNextThreeDays(listDataWeather.getDate()))
                .filter(ListDataWeather::isNightlyTemperature)
                .map(listDataWeather ->
                        new WeatherMainData(listDataWeather.getTemperature(),
                        listDataWeather.getPressure(),
                        listDataWeather.getDate()))
                ;

        Stream<WeatherMainData> dailyWeatherData = forecastOpenWeatherResponse.getDataWeather()
                .stream()
                .filter(listDataWeather -> isInTheNextThreeDays(listDataWeather.getDate()))
                .filter(ListDataWeather::isDailyTemperature)
                .map(listDataWeather ->
                        new WeatherMainData(listDataWeather.getTemperature(),
                                listDataWeather.getPressure(),
                                listDataWeather.getDate()));

        Stream<WeatherMainData> allData = forecastOpenWeatherResponse.getDataWeather()
                .stream()
                .filter(listDataWeather -> isInTheNextThreeDays(listDataWeather.getDate()))
                .map(listDataWeather ->
                        new WeatherMainData(listDataWeather.getTemperature(),
                                listDataWeather.getPressure(),
                                listDataWeather.getDate()));

        return new ForecastWeather(dailyWeatherData, nightlyWeatherData, allData,
                forecastOpenWeatherResponse.getCityName());
    }

    public double getAverageDaily() {
        return dailyWeatherData.mapToDouble(WeatherMainData::getTemperature).average().orElse(0.0);
    }

    public double getAverageNightly() {
        return nightlyWeatherData.mapToDouble(WeatherMainData::getTemperature).average().orElse(0.0);
    }

    public double getAveragePressure() {
        return allData.mapToDouble(WeatherMainData::getPressure).average().orElse(0.0);
    }

    public String getCity() {
        return city;
    }
}
