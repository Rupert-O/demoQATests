package WO10Modemy;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.junit.Test;



public class restAssuredTest1 {
    @Test
public void TestAPI1() {

        given().baseUri("https://restful-booker.herokuapp.com/")
                .when()
                .get("booking/2")
                .then()
                .statusCode(200)
        ;
    }


    @Test
    public void TestAPI2() {

        given().baseUri("https://restful-booker.herokuapp.com/")
                .when()
                .get("booking/2")
                .then()
                .statusCode(200)
                .body("lastname", equalTo("Jones"))
        ;
    }

    @Test
    public void TestAPI3() {

        given().baseUri("https://restful-booker.herokuapp.com/")
                .when()
                .get("booking/2")
                .then()
                .body("lastname", instanceOf(String.class))
        ;
    }
}

