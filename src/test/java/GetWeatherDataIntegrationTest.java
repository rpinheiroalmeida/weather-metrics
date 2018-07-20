import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.greaterThan;

public class GetWeatherDataIntegrationTest {

    @BeforeClass
    public static void setUp() throws InterruptedException {
        Main.start();
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 4567;
    }

    @Test
    public void  get_dataWeatherShouldReturn_Sucess() {
        get("/data?city=London").then().statusCode(200).assertThat()
                .body("average_pressure", greaterThan(0.0f))
                .body("average_daily", greaterThan(0.0f))
                .body("average_nightly", greaterThan(0.0f));
    }
}
