package RESTAssured_API_Testing.Parsing_JSON_Response;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UsingJSONObject {

    @Test(priority = 1)
    public void JsonValidation() {
        Response res = given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/students");  // Sending GET request

        // Convert response body to JSONArray
        JSONArray jsonArray = new JSONArray(res.getBody().asString());

        // Loop through the JSON array and print names
        for (int i = 0; i < jsonArray.length(); ) {
            String name = jsonArray.getJSONObject(i).getString("name");
            i++;
            // Extract name
            System.out.println(i + ":" + name);
        }
    }
}


