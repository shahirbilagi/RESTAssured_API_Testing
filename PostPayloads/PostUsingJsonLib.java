package RESTAssured_API_Testing.PostPayloads;

import org.json.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class PostUsingJsonLib {
    // 1.Post Request Using JsonLibrary
    @Test(priority = 1)
    public void postRequest() {
        JSONObject Obj = new JSONObject();
        Obj.put("id", "105");
        Obj.put("name", "shahir");
        Obj.put("age", "22");

        given()
                .contentType("application/json")
                .body(Obj.toString())
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
                //.statusCode(200)
                .log().all();
    }
}
