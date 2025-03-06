package RESTAssured_API_Testing.Cookies_Headers;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class TestHeaders {
    @Test(priority = 1)
    public void TestHearder() {
        given()
                .when()
                .get("https://www.google.com")
                .then()
                .header("Expires", "-1")
                .and()
                .header("Content-Type", "text/html; charset=ISO-8859-1")
                .and()
                .header("Content-Encoding", "gzip")
                .and()
                .header("Server", "gws")
                .statusCode(200);
    }

    @Test(priority = 2)
    public void GetHearder() {
        Response rs = given()
                .when()
                .get("https://www.google.com");
        //To Get Single Cookies Name
        String server = rs.getHeader("Server");
        System.out.println("Single Header Detail (Server): " + server);

        //To Get Multiple Cookies Name
        Headers headers = rs.getHeaders();
        int i = 0;
        System.out.println("Total Header are: "+headers.size());
        for (Header header : headers) {
            i++;
            System.out.println(i + ". " + header.getName() + ": " + header.getValue());

        }

    }
}
