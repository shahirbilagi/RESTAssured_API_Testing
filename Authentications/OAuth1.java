package RESTAssured_API_Testing.Authentications;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class OAuth1 {
    @Test
    void Auth1() {
        given()
                .auth().oauth("","","","")//Stronger keys
                .when()
                .get("https://postman-echo.com/basic-auth")
                .then()
                .statusCode(200)
                .body("authenticated", equalTo(true))
                .log().all();
    }
    @Test(priority = 1)
    void Auth2() {
        given()
                .auth().oauth2("")//Stronger keys
                .when()
                .get("https://api.github.com/users/shahirbilagi/repos")
                .then()
                .statusCode(200)
                .body("authenticated", equalTo(true))
                .log().all();
    }
}