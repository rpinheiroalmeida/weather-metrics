import com.google.gson.Gson;
import presentation.WeatherView;

import static spark.Spark.get;

public class Main {

    public static void start() {
        get("/welcome", (req, res) -> "Welcome to statistics API");

        get("/data", (request, response) -> {
            response.type("application/json");

            return new Gson().toJson(new WeatherView("1", "1", "1"));
        });
    }


}
