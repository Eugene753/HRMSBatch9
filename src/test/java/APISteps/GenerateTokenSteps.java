package APISteps;

import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.apiConstants;

import static io.restassured.RestAssured.*;


public class GenerateTokenSteps {

    static String token;
    @Given("JWT is generated")
    public void jwt_is_generated() {

        RequestSpecification generateTokenRequest = given().header("Content-type", "application/json")
                .body("{\n" +
                        "  \"email\": \"moazam888@gmail.com\",\n" +
                        "  \"password\": \"jeka777\"\n" +
                        "}");

        Response generateTokenResponse = generateTokenRequest.when().post(apiConstants.GENERATE_TOKEN_URI);

        token ="Bearer "+generateTokenResponse.jsonPath().getString("token");
    }
}
