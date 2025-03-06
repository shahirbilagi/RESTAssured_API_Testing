package RESTAssured_API_Testing.Path_Query_Parameter;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class TestQuery {
    @Test
    public void TestQuery() {

        given()
                //https://reqres.in/api/users?page=2&id=5
                .pathParam("mypath", "users")//Path Parameter
                .queryParam("page", 2)//Query Parameter
                .queryParam("id", 5)//Query Parameter
                .when()
                .get("https://reqres.in/api/{mypath}/")
                //No need to add Query Parameter
                //due to its not variable and standard syntax does not follow adding query parameter
                .then()
                .statusCode(200)
                .log().all();
    }
}
