import com.google.gson.Gson;
import presentation.WeatherView;
import service.DataWeatherService;

import static spark.Spark.get;

public class Main {

    public static void start() {
        get("/welcome", (req, res) -> "Welcome to statistics API");

        get("/data", (request, response) -> {
            response.type("application/json");

            WeatherView weatherView = WeatherView.of(new DataWeatherService().calculateAverage("London"));
            return new Gson().toJson(weatherView);
        });
    }


}
