package RESTAssured_API_Testing.Cookies_Headers;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class TestCookies {
    @Test(priority = 1)
    public void TestCookies() {
        given()
                .when()
                .get("https://www.google.com")
                .then()
                .statusCode(200);
    }

    @Test(priority = 2)
    public void GetCookies() {
        Response rs = given()
                .when()
                .get("https://www.google.com");
        //To Get Single Cookies Name
        String CookiesVariable = rs.getCookie("AEC");
        System.out.println("AEC Cookie: " + CookiesVariable);

        //To Get Multiple Cookies Name
        Map<String, String> cookies = rs.getCookies();
        System.out.println("Cookies Present in Sets: " + cookies.keySet());
        for (String key : cookies.keySet()) {
            System.out.println(key + ": " + cookies.get(key));
        }
    }
}
