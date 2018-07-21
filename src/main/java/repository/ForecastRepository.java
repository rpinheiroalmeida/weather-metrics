package repository;

import model.ForecastWeather;

import java.io.IOException;

public interface ForecastRepository {

    ForecastWeather getData(String city) throws IOException;
}
