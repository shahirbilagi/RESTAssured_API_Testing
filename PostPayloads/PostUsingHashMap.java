package RESTAssured_API_Testing.PostPayloads;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PostUsingHashMap {

    // 1.Post Request Using Hashmap
    @Test(priority = 1)
    public void postRequestHashMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("id", "105");
        map.put("name", "shahir");
        map.put("age", "22");

        given()
                .contentType("application/json")
                .body(map)
                .when()
                .post("http://localhost:3000/students")
                .then()
                .statusCode(201)
                .log().all();
    }

    @Test(priority = 2)
    public void DeleteRequest() {
        given()
                .when()
                .delete("http://localhost:3000/students/105")
                .then()
                .statusCode(200)
                .log().all();
    }
}
