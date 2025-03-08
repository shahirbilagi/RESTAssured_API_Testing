package RESTAssured_API_Testing.Parsing_XML_Response;

import com.github.dockerjava.transport.DockerHttpClient;
import io.restassured.response.Response;
import org.junit.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class VariableValidation {
    @Test(priority = 1)
    public void JsonValidation() {
        Response res=given()
                .when()
                .get("http://localhost:3000/students");
        Assert.assertThat(res.statusCode(), equalTo(200));
                String name=res.xmlPath().get("university.students.student[0].name").toString();
                Assert.assertThat(name, equalTo("John Doe"));
                System.out.println(name);

    }
}