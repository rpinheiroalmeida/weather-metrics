import com.google.gson.Gson;
import service.DataWeatherService;

import static spark.Spark.get;

public class Main {

    private static DataWeatherService service = new DataWeatherService();

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        get("/welcome", (req, res) -> "Welcome to statistics API");

        get("/data", (request, response) -> {
            response.type("application/json");
            response.status(200);
            String city = request.queryMap("city").value();

            return new Gson().toJson(service.calculateAverage(city));
        });
    }


}
