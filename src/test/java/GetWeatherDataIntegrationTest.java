import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;

public class GetWeatherDataIntegrationTest {

    @BeforeClass
    public static void setUp() throws InterruptedException {
        Main.start("b79bfe9da8b1e51883b30b37fa7460e8");

        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 4567;
    }

    @After
    public void tearDown() {
        System.setProperty("api.key", "b79bfe9da8b1e51883b30b37fa7460e8");
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

        get("/data?city=Belo Horizonte").then().statusCode(200).assertThat()
                .body("average_pressure", greaterThan(0.0f))
                .body("average_daily", greaterThan(0.0f))
                .body("average_nightly", greaterThan(0.0f))
                .body("city", is("Belo Horizonte"))
        ;
    }

    @Test
    public void get_errorWhenApiKeyIsIncorrect() {
        System.setProperty("api.key", "b79bfe9da8b1e51883b30b37fa7460e81");

        get("/data?city=Belo Horizonte").then().statusCode(401);
    }

    @Test
    public void get_errorWhenCityIsIncorrect() {
        get("/data?city=Belo HorizonteHHH").then().statusCode(404);
    }

    @Test
    public void get_errorWhenCityIsEmpty() {
        get("/data?city=").then().statusCode(400);
    }

}
