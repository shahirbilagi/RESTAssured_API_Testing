package RESTAssured_API_Testing.Authentications;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class APIAuth {
    String API = "c3d4e7f4f25c296d320f47331299e2d4";

    @Test
    void Authenticate() {
        given()

                .queryParam("appid", API)
                .when()
                .get("https://api.openweathermap.org/data/2.5/forecast/daily?q=Delhi&units=metric&cnt=7")
                .then()
                .log().all();
    }
}
