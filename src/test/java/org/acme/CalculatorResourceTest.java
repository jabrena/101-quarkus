package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import io.restassured.http.ContentType;

@QuarkusTest
class CalculatorResourceTest {

    @Test
    void testCalculatorEndpoint() {
        String requestBody = """
                {
                    "operator1": "10",
                    "operator2": "5",
                    "operation": "add"
                }
                """;
        
        System.out.println("Sending request: " + requestBody);
        
        // Assuming the calculator service would return "15" for this operation
        given()
            .contentType(ContentType.JSON)
            .body(requestBody)
            .when()
            .post("/calculate")
            .then()
            .statusCode(200)
            .body(is("15")); // This expected result depends on your actual implementation
    }
}