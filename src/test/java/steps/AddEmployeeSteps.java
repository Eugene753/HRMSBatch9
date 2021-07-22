package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import org.junit.Assert;
import pages.AddEmployeePage;
import pages.DashBoardPage;
import utils.CommonMethods;
import utils.Constants;
import utils.ExcelReading;
import utils.GlobalVariable;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {

    @When("user click on PIM option")
    public void user_click_on_pim_option() {
        DashBoardPage dash=new DashBoardPage();
        click(dash.pimOption);
    }

    @When("user click on Add employee button")
    public void user_click_on_add_employee_button() {
        DashBoardPage dash=new DashBoardPage();
        click(dash.addEmployeeButton);
    }

    @When("user enters firstname middlename and lastname")
    public void user_enters_firstname_middlename_and_lastname() {
        AddEmployeePage add=new AddEmployeePage();
        sendText(add.firstName,"Givi123");
        sendText(add.middleName,"MS");
        sendText(add.lastName,"MS12");
    }

    @When("user enters first name {string} middle name {string} and lastname {string}")
    public void user_enters_first_name_middle_name_and_lastname(String firstName, String middleName, String lastName) {
        AddEmployeePage add=new AddEmployeePage();
        sendText(add.firstName,firstName);
        sendText(add.middleName,middleName);
        sendText(add.lastName,lastName);
        GlobalVariable.firstName=firstName;
        GlobalVariable.middleName=middleName;
        GlobalVariable.lastName=lastName;
    }

    @When("user enters {string} {string} and {string} in the application")
    public void user_enters_and_in_the_application(String FirstName, String MiddleName, String LastName) {
        AddEmployeePage add=new AddEmployeePage();
        sendText(add.firstName,FirstName);
        sendText(add.middleName,MiddleName);
        sendText(add.lastName,LastName);
    }

    @When("user click on save button option")
    public void user_click_on_save_button_option() {
        AddEmployeePage add=new AddEmployeePage();
        click(add.saveBtn);
    }
    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("Employee Added Successfully");
    }

    @When("add multiple employees and verify they are added successfully")
    public void add_multiple_employees_and_verify_they_are_added_successfully(DataTable employee) throws InterruptedException {
        List<Map<String,String>> employeeNames=employee.asMaps();
        for(Map<String,String> employeename:employeeNames){

            String firstnamevalue=employeename.get("FirstName");
            String middlenamevalue=employeename.get("MiddleName");
            String lastnamevalue=employeename.get("LastName");
            System.out.println(firstnamevalue+" "+middlenamevalue+" "+lastnamevalue);

            AddEmployeePage addEmployeePage=new AddEmployeePage();
            sendText(addEmployeePage.firstName,firstnamevalue);
            sendText(addEmployeePage.middleName,middlenamevalue);
            sendText(addEmployeePage.lastName,lastnamevalue);
            click(addEmployeePage.saveBtn);

            //assertion take it as HW
            Thread.sleep(5000);
            DashBoardPage dash=new DashBoardPage();
            click(dash.addEmployeeButton);
            Thread.sleep(3000);

        }
    }

    @When("user adds multiple employees from excel file from {string} sheet and verify they are added")
    public void user_adds_multiple_employees_from_excel_file_from_sheet_and_verify_they_are_added(String sheetname) {

        List<Map<String,String>> newemployees= ExcelReading.excelIntoListMap(Constants.TESTDATA_FILEPATH,sheetname);

        DashBoardPage dash=new DashBoardPage();
        AddEmployeePage addEmployeePage=new AddEmployeePage();

        Iterator<Map<String,String>> it=newemployees.iterator();
        while(it.hasNext()){
            Map<String,String> mapNewEmp=it.next();
            sendText(addEmployeePage.firstName,mapNewEmp.get("FirstName"));
            sendText(addEmployeePage.middleName,mapNewEmp.get("MiddleName"));
            sendText(addEmployeePage.lastName,mapNewEmp.get("LastName"));
            click(addEmployeePage.saveBtn);

            //assertion complete in HW
        }
    }

    @When("capture the employeeId")
    public void capture_the_employee_id() {
        AddEmployeePage addEmployeePage=new AddEmployeePage();
        GlobalVariable.empId=addEmployeePage.employeeId.getAttribute("value");
    }

    @Then("verify the data from frontend and backend")
    public void verify_the_data_from_frontend_and_backend() {
        System.out.println("Backend");
        System.out.println("DBFirstName "+GlobalVariable.dbFirstName);
        System.out.println("DBMiddleName "+GlobalVariable.dbMiddleName);
        System.out.println("DBLastName "+GlobalVariable.dbLastName);
        System.out.println("FrontEnd");
        System.out.println("FirstName "+GlobalVariable.firstName);
        System.out.println("MiddleName "+GlobalVariable.middleName);
        System.out.println("LastName "+GlobalVariable.lastName);
        Assert.assertEquals(GlobalVariable.firstName,GlobalVariable.dbFirstName);
        Assert.assertEquals(GlobalVariable.middleName,GlobalVariable.dbMiddleName);
        Assert.assertEquals(GlobalVariable.lastName,GlobalVariable.dbLastName);
    }
}
