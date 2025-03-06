package RESTAssured_API_Testing.PostPayloads;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestPOJO {
    @Test(priority = 1)
    public void postPOJO() {
        PostUsingPOJO data = new PostUsingPOJO();
        data.setId("105");
        data.setName("Shahir");
        data.setAge("22");

        given()
                .contentType("application/json")
                .body(data)
                .when()
                .post("http://localhost:3000/students")
                .then()
                .statusCode(201)
                .log().all();

        given()
                .when()
                .delete("http://localhost:3000/students/105")
                .then()
                .statusCode(200)
                .log().all();
    }
}
