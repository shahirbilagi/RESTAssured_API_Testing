package RESTAssured_API_Testing.Authentications;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BearerAuth {
    @Test
    void bearerAuth() {
        String Token = "";
        given()
                .header("Authorization", "Bearer " + Token)
                //.auth().oauth2(Token)
                .when()
                .get("https://api.github.com/users/shahirbilagi/repos")
                .then()
                .statusCode(200)
                .log().all();

    }
}
