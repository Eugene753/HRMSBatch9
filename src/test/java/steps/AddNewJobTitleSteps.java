package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AddEmployeePage;
import pages.DashBoardPage;
import pages.JobPage;
import utils.CommonMethods;
import utils.GlobalVariable;

public class AddNewJobTitleSteps extends CommonMethods {

    @Then("user click on Admin button")
    public void user_click_on_admin_button() {
        DashBoardPage dashBoardPage=new DashBoardPage();
        click(dashBoardPage.adminButton);
    }

    @Then("user click on Job title button")
    public void user_click_on_job_title_button() {
        JobPage jobPage=new JobPage();
        moveToElement(jobPage.jobButton);
        click(jobPage.jobTitleListButton);
    }
    @Then("user click on Add button")
    public void user_click_on_add_button() {
        JobPage jobPage=new JobPage();
        click(jobPage.addButton);
    }
    @When("user add job title, job description, note")
    public void user_add_job_title_job_description_note() {
        JobPage jobPage=new JobPage();
        GlobalVariable.newJobTitle="Data Analyst";
        sendText(jobPage.jobTitleBox,GlobalVariable.newJobTitle);
        GlobalVariable.newJobDescription="Collection data and analysing collected data";
        sendText(jobPage.jobDescriptionBox,GlobalVariable.newJobDescription);
        GlobalVariable.newJobNote="Check if data was added";
        sendText(jobPage.noteBox,GlobalVariable.newJobNote);

    }
    @Then("user clicks on save button")
    public void user_clicks_on_save_button() {
        JobPage jobPage=new JobPage();
        click(jobPage.saveButton);
    }

    @Then("checks if information added from front end and back end")
    public void checks_if_information_added_from_front_end_and_back_end() {
        System.out.println("Frontend");
        System.out.println("New Job Title: "+GlobalVariable.newJobTitle);
        System.out.println("New Job Description: "+GlobalVariable.newJobDescription);
        System.out.println("New Job Note: "+GlobalVariable.newJobNote);
        System.out.println("Backend");
        System.out.println("New Job Title: "+GlobalVariable.dbNewJobTitle);
        System.out.println("New Job Description: "+GlobalVariable.dbNewJobDescription);
        System.out.println("New Job Note: "+GlobalVariable.dbNewJobNote);
        Assert.assertEquals(GlobalVariable.newJobTitle,GlobalVariable.dbNewJobTitle);
        Assert.assertEquals(GlobalVariable.newJobDescription,GlobalVariable.newJobDescription);
        Assert.assertEquals(GlobalVariable.newJobNote,GlobalVariable.dbNewJobNote);
    }
}
