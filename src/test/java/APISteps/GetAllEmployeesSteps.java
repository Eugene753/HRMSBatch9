package APISteps;

import APISteps.GenerateTokenSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.apiConstants;
import static io.restassured.RestAssured.*;

public class GetAllEmployeesSteps {

    RequestSpecification request;
    Response response;
    int count;
    JsonPath js;
    @Given("request is prepared to retrieve all employees from database")
    public void request_is_prepared_to_retrieve_all_employees_from_database() {
        request = given().header(apiConstants.Header_Content_type,apiConstants.Content_type)
                .header(apiConstants.Header_Authorization,GenerateTokenSteps.token);
    }
    @When("a GET call is made to retrieve all employees")
    public void a_get_call_is_made_to_retrieve_all_employees() {
        response = request.when().get(apiConstants.GET_ALL_EMPLOYEE_URI);
        //response.prettyPrint();
    }
    @Then("verify a status code for retrieving all employees is {int}")
    public void verify_a_status_code_for_retrieving_all_employees_is(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }
    @Then("count how many employees we have in Database")
    public void count_how_many_employees_we_have_in_database() {
        js = new JsonPath(response.asString());
        count = js.getInt("Employees.size()");
        System.out.println("Total employees: " + count);
    }
    @Then("retrieve {string}, {string}, {string}, {string}")
    public void retrieve(String employeeID, String firstName, String middleName, String lastName) {
        for (int i =0; i < count; i++){
            String empID = js.getString("Employees[" +i+ "]."+employeeID);
            String fName = js.getString("Employees[" +i+ "]."+firstName);
            String mName = js.getString("Employees[" +i+ "]."+middleName);
            String lName = js.getString("Employees[" +i+ "]."+lastName);
            System.out.println(empID+" \n " +
                    " " + fName + " \n " +
                    " " + mName + " \n " +
                    " " + lName + " \n ");

            //System.out.println(String.format("%-20s%-20s%-20s%-20s",empID,fName,mName,lName));
        }
    }

}
