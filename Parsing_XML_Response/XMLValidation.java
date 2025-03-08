package RESTAssured_API_Testing.Parsing_XML_Response;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class XMLValidation {
    @Test(priority = 1)
    public void JsonValidation() {
        given()
                .when()
                .get("http://localhost:3000/students")
                .then()
                .statusCode(200)
                .body("university.students.student[0].name", equalTo("John Doe"));
    }
}