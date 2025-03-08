package RESTAssured_API_Testing.Parsing_JSON_Response;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class VariableValidation {
    @Test(priority = 1)
    public void JsonValidation() {
        Response res = given()
                .contentType("application/json")
                .when()
                .get("http://localhost:3000/students");
                Assert.assertEquals(res.getStatusCode(), 200);
                String name=res.jsonPath().get("[0].name").toString();
                Assert.assertEquals(name,"John Doe");
    }
}
