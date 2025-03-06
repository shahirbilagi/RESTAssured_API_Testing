package RESTAssured_API_Testing.Cookies_Headers;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestLogs {
    @Test(priority = 1)
    public void TestLogs() {
        given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .log().body()
                .and()
                .log().cookies()
                .and()
                .log().headers();
    }
}
