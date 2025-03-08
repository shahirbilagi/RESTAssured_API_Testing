package RESTAssured_API_Testing.Authentications;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PremtiveAuth {
    @Test
    void Authenticate() {
        given()
                .auth().preemptive().basic("postman", "password")
                .when()
                .get("https://postman-echo.com/basic-auth")
                .then()
                .statusCode(200)
                .body("authenticated", equalTo(true))
                .log().all();

    }
}
