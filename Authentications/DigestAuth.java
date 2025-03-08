package RESTAssured_API_Testing.Authentications;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class DigestAuth {
    @Test
    void Authenticate() {
        given()
                .auth().digest("postman","password")//Firstly verify internally then hit the server
                .when()
                .get("https://postman-echo.com/basic-auth")
                .then()
                .statusCode(200)
                .body("authenticated", equalTo(true))
                .log().all();
    }
}
