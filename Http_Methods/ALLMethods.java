package RESTAssured_API_Testing.Http_Methods;
/*
given() - content type, set cookies, add auth
when() - get, post, put, delete
then() - validate status code, extract response, extract headers & response body
 */

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;

public class ALLMethods {
    int id;

    @Test(priority = 1)
    void GetDetails() {
        given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test(priority = 2)
    void CreateUser() {
        HashMap map = new HashMap();
        map.put("name", "Shoaib");
        map.put("job", "Developer");

        id = given()
                .contentType("application/json")
                .body(map)
                .when()
                .post("https://reqres.in/api/users")
                .jsonPath().getInt("id");

    }

    @Test(priority = 3, dependsOnMethods = {"CreateUser"})
    void UpdateUser() {
        HashMap map = new HashMap();
        map.put("name", "shahir");
        map.put("job", "Developer");
        given()
                .contentType("application/json")
                .body(map)
                .when()
                .put("https://reqres.in/api/users/" + id)

                .then()
                .statusCode(200)
                .log().all();
    }
    @Test(priority = 4)
    void DeleteUser() {
        given()
        .when()
                .delete("https://reqres.in/api/users/" + id)
                .then()
                .statusCode(204)
                .log().all();

    }
}
