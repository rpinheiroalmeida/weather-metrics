package repository;


import exception.WeatherException;
import model.ForecastWeather;

import java.io.IOException;

public interface ForecastRepository {

    ForecastWeather getData(String city) throws IOException, WeatherException;
}
