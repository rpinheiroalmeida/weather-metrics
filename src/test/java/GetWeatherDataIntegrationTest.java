import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.any;

public class GetWeatherDataIntegrationTest {

    @BeforeClass
    public static void setUp() throws InterruptedException {
        Main.start();
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 4567;
    }

    @Test
    public void  get_dataWeatherShouldReturn_Sucess() {
        get("/data?city=london").then().statusCode(200).assertThat()
                .body("average_pressure", any(String.class))
                .body("average_daily", any(String.class))
                .body("average_nightly", any(String.class));
    }
}
