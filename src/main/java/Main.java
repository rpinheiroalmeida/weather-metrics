import com.google.gson.Gson;
import exception.WeatherException;
import org.apache.http.client.HttpResponseException;
import presentation.WeatherView;
import service.DataWeatherService;

import static spark.Spark.get;

public class Main {

    private static DataWeatherService service = new DataWeatherService();

    public static void main(String[] args) {
        start(args[0]);
    }


    public static void start(String key) {
        System.setProperty("api.key", key);

        get("/welcome", (req, res) -> "Welcome to statistics API");

        get("/data", (request, response) -> {
            response.type("application/json");
            response.status(200);
            String city = request.queryMap("city").value();

            try {
                return new Gson().toJson(service.calculateAverage(city));
            } catch (WeatherException e) {
                return new Gson().toJson(WeatherView.NULL);
            } catch (HttpResponseException e) {
                e.printStackTrace();
                response.status(e.getStatusCode());
                return new Gson().toJson(WeatherView.NULL);
            }
        });
    }


}
