package repository;


import java.io.IOException;

public interface ForecastRepository {

    ForecastOpenWeatherResponse getData(String city) throws IOException;
}
