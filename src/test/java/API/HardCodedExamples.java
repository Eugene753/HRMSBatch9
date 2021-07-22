package API;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamples {

    /**
     * NOTE:
     * <p>
     * Given - Preparing request
     * <p>
     * When - making the request/making the call/getting the endpoint
     * <p>
     * Then - verification/assertions
     */

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MjY2MTc5MjksImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTYyNjY2MTEyOSwidXNlcklkIjoiMjk1MyJ9.W7WOYAUm0e547jrFFiK4WeTl_7tUi65WF4pYi3f40eo";
    static String employee_id;

    static String first_name;

    //@Test
    public void sampleTest() {

        RequestSpecification preparedRequest = given().header("Authorization", token).
                header("Content-Type", "application/json").queryParam("employee_id", "20333320");


        Response response = preparedRequest.when().get("/getOneEmployee.php");

        /**
         * Printing response using asString() method to convert JSON object to a String and printing using System.out.pringln()
         *
         */
        System.out.println(response.asString());
    }

    @Test
    public void aPostCreateEmployee() {
        RequestSpecification preparedRequest = given().header("Authorization", token).header("Content-Type", "application/json").body("{\n" +
                "  \"emp_firstname\": \"Danillo\",\n" +
                "  \"emp_lastname\": \"Igor\",\n" +
                "  \"emp_middle_name\": \"Igor\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"1995-08-17\",\n" +
                "  \"emp_status\": \"employeed\",\n" +
                "  \"emp_job_title\": \"Engeneer\"\n" +
                "}");

        /***
         *
         * log().all() will log and print all information being sent with the request
         */
        Response response = preparedRequest.when().post("/createEmployee.php");


        /**
         * prettyPrint() does the same as System.out.println(Response)
         */
        //response.prettyPrint();

        /**
         * jsonPath() allows us to retrieve specific data from a json object - just like an xpath with selenium
         */
        employee_id = response.jsonPath().getString("Employee.employee_id");

        first_name = response.jsonPath().getString("Employee.emp_firstname");


        /**
         * Performing assertion
         */
        response.then().assertThat().statusCode(201);

        /**
         * Using Hamcrest Matchers class equalTo()
         */
        response.then().assertThat().body("Message", equalTo("Employee Created"));

        /**
         * Write an assertion that verifies that the response body has the name you used
         */
        response.then().assertThat().body("Employee.emp_firstname", equalTo("Danillo"));

        /**
         * Verifying server
         */
        response.then().assertThat().header("Server", "Apache/2.4.39 (Win64) PHP/7.2.18");
    }


    @Test
    public void bGetCreatedEmployee() {

        RequestSpecification preparedRequest = given().header("Authorization", token).header("Content-Type", "application/json").queryParam("employee_id", employee_id);

        Response response = preparedRequest.when().get("/getOneEmployee.php");

        //response.prettyPrint();

        String empID = response.jsonPath().getString("employee.employee_id");

        boolean comparingEmpIDs = empID.contentEquals(employee_id);

        String firstname = response.jsonPath().getString("employee.emp_firstname");


        boolean comparingFirst_names = firstname.contentEquals(first_name);

        Assert.assertTrue(comparingFirst_names);

        //12345
        //13456

        Assert.assertTrue(comparingEmpIDs);

        //Task.Retrive the first name and assert that the first name is the same as the one you used
        //DO NOT USE HAMCREST MATCHERS
    }

    /*@Test
    public void check(){
        int str=12345;

        int str1=12324;

        if(str.contains(str1)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }*/
    @Test
    public void cGetAllEmployees() {
        RequestSpecification preparedRequest = given().header("Authorization", token).header("Content-Type", "application/json");

        Response response = preparedRequest.when().get("/getAllEmployees.php");

        //String allEmployees=response.prettyPrint();

        /**
         * Creating object of JsonPath class
         */
        JsonPath js = new JsonPath(response.asString());

        /**
         *
         * Retrieving number of employees in response body
         */
        int count = js.getInt("Employees.size()");

        //System.out.println(count);

        //Print out all employee IDs from the response


        for (int i = 0; i < count; i++) {

            String employeesIDs = js.getString("Employees[" + i + "].employee_id");

            //System.out.println(employeesIDs);

            /**
             * Verify stored employee ID from previous call is in response body
             *
             */
            if (employeesIDs.contentEquals(employee_id)) {

                System.out.println("Employee ID " + employee_id + " is present in response body");
                String firstName = js.getString("Employees[" + i + "].emp_firstname");
                /**
                 *
                 * Printing out the first name of the employee that we created
                 */
                System.out.println("Employee name is " + firstName);
                break;
            }
        }
    }

    @Test
    public void dPutUpdatedCreatedEMployee() {
        RequestSpecification preparedRequest = given().header("Authorization", token).header("Content-Type", "application/json").
                body("{\n" + " \"employee_id\": \"" + employee_id + "\",\n"
                        + " \"emp_firstname\": \"Vadim\",\n"
                        + "  \"emp_lastname\": \"Vadimchenko\",\n"
                        + "  \"emp_middle_name\": \"Cropop\",\n" + "  \"emp_gender\": \"M\",\n"
                        + "  \"emp_birthday\": \"1995-09-17\",\n" + "  \"emp_status\": \"Hired\",\n"
                        + "  \"emp_job_title\": \"BA\"\n"+"}");

        System.out.println(employee_id);
        Response response = preparedRequest.when().put("/updateEmployee.php");

        response.prettyPrint();

        JsonPath js = new JsonPath(response.asString());
    }

    /*@Test
    public void dPutUpdateCreatedEmployee() {

        *//**
         * Update the created employee
         *//*

        RequestSpecification preparedRequest = given().header("Authorization", token)
                .header("Content-Type", "application/json").
                        body("{\n" + "  \"employee_id\": \"" + employee_id + "\",\n"
                        + "  \"emp_firstname\": \"syntaxUpdatedFirstName\",\n"
                        + "  \"emp_lastname\": \"syntaxUpdatedLastName\",\n"
                        + "  \"emp_middle_name\": \"syntaxUpdatedMiddleName\",\n" + "  \"emp_gender\": \"F\",\n"
                        + "  \"emp_birthday\": \"2000-07-11\",\n" + "  \"emp_status\": \"Employee\",\n"
                        + "  \"emp_job_title\": \"Cloud Consultant\"\n" + "}");

        Response response = preparedRequest.when().put("/updateEmployee.php");

        response.prettyPrint();

    }*/


}