package RESTAssured_API_Testing.PostPayloads;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static io.restassured.RestAssured.given;

public class PostUsingExternalFile {
    @Test
    public void postUsingExternalFile() throws FileNotFoundException {
        File file = new File("src/main/java/RESTAssured_API_Testing/PostPayloads/Body.Json");
        FileReader fileReader = new FileReader(file);//Helps to read the file
        JSONTokener jsonTokener = new JSONTokener(fileReader);//Ultimately gets Json Format Data
        JSONObject jsonObject = new JSONObject(jsonTokener);//Extract Data into Json Object Format
        given()
                .contentType("application/json")
                .body(jsonObject.toString())
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
