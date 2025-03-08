package RESTAssured_API_Testing.Parsing_XML_Response;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class UsingXMLPath {
    @Test(priority = 1)
    public void JsonValidation() {
        Response res = given()
                .when()
                .get("http://localhost:3000/students");
        Assert.assertEquals(res.statusCode(), 200);
        XmlPath xmlPath = XmlPath.from(res.getBody().asString());
        List<String> Student_Name = xmlPath.getList("university.students.student.name");
        System.out.println(Student_Name);
        for(int i=0;i<Student_Name.size();i++){
            System.out.println(Student_Name.get(i));
    }
}
}
