package testkube;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ExampleApiTest {
    
    @Test
    public void testGetPosts() {

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        Response response = given()
                .when()
                .get("/posts")
                .then()
                .extract().response();

        response.then().statusCode(200);

        response.then().body("[0].title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));
    }

    @Test
    public void testGetComments() {

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        Response response = given()
                .when()
                .get("/comments")
                .then()
                .extract().response();

        response.then().statusCode(200);

        response.then().body("[0].name", equalTo("id labore ex et quam laborum"));
    }
}
