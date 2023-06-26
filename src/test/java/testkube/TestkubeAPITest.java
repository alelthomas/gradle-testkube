package testkube;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ExampleApiTest {

    @Test
    public void testGetRequest() {
        RestAssured.baseURI = "https://api.example.com";

        Response response = given()
                .when()
                .get("/users")
                .then()
                .extract().response();

        response.then().statusCode(200);
        response.then().body("users[0].name", equalTo("John Doe"));
    }

    @Test
    public void testPostRequest() {
        RestAssured.baseURI = "https://api.example.com";

        String requestBody = "{\"name\": \"John Doe\", \"email\": \"johndoe@example.com\"}";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/users")
                .then()
                .extract().response();

        response.then().statusCode(201);

        response.then().body("id", notNullValue());
    }
}
