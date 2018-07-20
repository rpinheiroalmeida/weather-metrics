import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;

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
                .body("average_nightly", greaterThan(0.0f))
                .body("city", is("London"))
        ;
    }

    @Test
    public void  get_dataWeatherForBeloHorizonteCityShouldReturn_Sucess() {
        get("/data?city=Belo Horizonte").then().statusCode(200).assertThat()
                .body("average_pressure", greaterThan(0.0f))
                .body("average_daily", greaterThan(0.0f))
                .body("average_nightly", greaterThan(0.0f))
                .body("city", is("Belo Horizonte"))
        ;
    }
}
