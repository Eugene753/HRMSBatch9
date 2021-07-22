package steps;

import io.cucumber.java.en.Then;
import utils.DbUtils;
import utils.GlobalVariable;

import java.util.List;
import java.util.Map;

public class DbSteps {

    @Then("query the HRMS database")
    public void query_the_hrms_database() {
        String query="select emp_firstname,emp_middle_name,emp_lastname from hs_hr_employees where emp_number ="+ GlobalVariable.empId;
        List<Map<String,String>> tabelDataAsList=DbUtils.getTableDataAsList(query);
        GlobalVariable.dbFirstName=tabelDataAsList.get(0).get("emp_firstname");
        GlobalVariable.dbMiddleName=tabelDataAsList.get(0).get("emp_middle_name");
        GlobalVariable.dbLastName=tabelDataAsList.get(0).get("emp_lastname");
    }

    @Then("enter query into HRMS database")
    public void enter_query_into_hrms_database() {
        String query="select job_title,job_description,note from ohrm_job_title where job_title = '"+GlobalVariable.newJobTitle+"'";
        List<Map<String,String>> newJobTable=DbUtils.getTableDataAsList(query);
        GlobalVariable.dbNewJobTitle=newJobTable.get(0).get("job_title");
        GlobalVariable.dbNewJobDescription=newJobTable.get(0).get("job_description");
        GlobalVariable.dbNewJobNote=newJobTable.get(0).get("note");
    }
}
