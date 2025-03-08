package RESTAssured_API_Testing.Parsing_JSON_Response;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class JsonValidation {
    @Test(priority = 1)
    public void JsonValidation() {
        given()
                .contentType("application/json")
                .when()
                .get("http://localhost:3000/students")
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json")
                .body("[0].name",equalTo("John Doe"));
    }
}
