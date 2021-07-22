package APISteps;

import APISteps.GenerateTokenSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.poi.poifs.filesystem.Entry;
import utils.apiConstants;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class APIGetOneEmployee {
        static Response response;
        RequestSpecification request;

    @Given("request is prepared to retrieve employee {string} is {string}")
    public void a_get_call_made_to_retrieve_employee(String string, String string2) {
       request=given().accept(ContentType.JSON).queryParam(string,string2).
               header(apiConstants.Header_Content_type,apiConstants.Content_type).
               header(apiConstants.Header_Authorization, GenerateTokenSteps.token);

    }

    @When("a Get call made to retrieve employee")
    public void a_get_call_made_to_retrieve_employee() {
        response=request.when().get(apiConstants.GET_ONE_EMPLOYEE_URI);
    }

    @Then("print get employee")
    public void print_get_employee() {
        Map<String,Object> mapOfEmployee=response.body().as(Map.class);

        System.out.println(mapOfEmployee.get("emp_firstname"));
    }
}
