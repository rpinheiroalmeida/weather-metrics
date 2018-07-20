package repository;


import java.io.IOException;

public interface ForecastRepository {

    ForecastResponse getData(String city) throws IOException;
}
