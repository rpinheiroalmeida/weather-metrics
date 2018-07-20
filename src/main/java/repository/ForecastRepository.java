package repository;

import com.google.gson.Gson;
import org.apache.http.client.fluent.Request;

import java.io.IOException;


public class ForecastRepository {


    public ForecastResponse getData(String city) throws IOException {
        String response = Request.Get("http://api.openweathermap.org/data/2.5/forecast?q=London&appid=b79bfe9da8b1e51883b30b37fa7460e8")
                            .execute()
                            .returnContent()
                .asString();

        return new Gson().fromJson(response, ForecastResponse.class);
    }
}
