package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pages.EmployeeListPage;
import utils.CommonMethods;

import java.util.List;

public class ModifyEmployeeTest extends CommonMethods {

    @When("user enter employee first name {string}")
    public void user_enter_employee_first_name(String employeeName) throws InterruptedException {
        EmployeeListPage employeeListPage = new EmployeeListPage();
        Thread.sleep(2000);
        sendText(employeeListPage.employeenamefield, employeeName);
        Thread.sleep(2000);
        click(employeeListPage.searchButton);
    }

    @When("user click on employee name from the employee list {string}")
    public void user_click_on_employee_name_from_the_employee_list(String employeeName) throws InterruptedException {
        EmployeeListPage employeeListPage = new EmployeeListPage();

        List<WebElement> list = employeeListPage.employeeList;
        boolean flag = true;
        while (flag) {
            String name="";
            for (WebElement employee : list) {
                name = employee.getText();
                if (name.contains(employeeName)) {
                    System.out.println(name);
                    click(employeeListPage.employeeNameFromTheList);
                    flag=false;
                    break;
                }
            }
            if(!name.contains(employeeName)){
                click(employeeListPage.nextButtonEmployeeList);
            }
        }
    }

    @When("user change first name to {string}")
    public void user_change_first_name_to(String newEmployeeName) {
        EmployeeListPage employeeListPage=new EmployeeListPage();
        sendText(employeeListPage.fullNameField,newEmployeeName);
    }

    @When("user click on edit button")
    public void user_click_on_edit_button() throws InterruptedException {
       EmployeeListPage employeeListPage=new EmployeeListPage();
       Thread.sleep(2000);
       click(employeeListPage.editButton);
    }


    @When("user enters license expiration date")
    public void user_enters_license_expiration_date() {
        EmployeeListPage employeeListPage = new EmployeeListPage();
        click(employeeListPage.calendar);
        Select select = new Select(employeeListPage.monthSelectorDD);
        select.selectByVisibleText("Aug");
        select=new Select(employeeListPage.yearSelectorDD);
        select.selectByVisibleText("2010");
        List<WebElement> dates=employeeListPage.datesOfTheMonth;
        for(WebElement date:dates){
            String day=date.getText();
            if(day.equals("10")){
                click(date);
                break;
            }
        }

    }

    @Then("user click on save button")
    public void user_click_on_save_button() {
        EmployeeListPage employeeListPage=new EmployeeListPage();
        click(employeeListPage.editButton);
    }

    @Then("user verifies that employee name was changed")
    public void user_verifies_that_employee_name_was_changed() {
        EmployeeListPage employeeListPage=new EmployeeListPage();
        String actualText=employeeListPage.employeeName.getText();
        String expectedText="Eugene Mari Yarema";
        Assert.assertEquals("Values do not match",actualText,expectedText);
        System.out.println("Test Passed");

    }
}



