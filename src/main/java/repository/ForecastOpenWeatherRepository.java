package repository;

import com.google.gson.Gson;
import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.net.URLEncoder;


public class ForecastOpenWeatherRepository implements ForecastRepository {

    private static final String URL_OPEN_WEATHER_MAP = "http://api.openweathermap.org/data/2.5/forecast?q=%s&appid=%s";

    public ForecastResponse getData(String city) throws IOException {
        String response = Request.Get(String.format(URL_OPEN_WEATHER_MAP, URLEncoder.encode(city, "UTF-8"), "b79bfe9da8b1e51883b30b37fa7460e8"))
                            .execute()
                            .returnContent()
                .asString();

        return new Gson().fromJson(response, ForecastResponse.class);
    }
}
