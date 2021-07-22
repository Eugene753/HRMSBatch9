package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class EmployeeListPage extends CommonMethods {

    @FindBy(xpath="//input[@id='empsearch_id']")
    public WebElement idEmployee;

    @FindBy(id="searchBtn")
    public WebElement searchButton;

    @FindBy(id="empsearch_employee_name_empName")
    public WebElement employeenamefield;

    @FindBy(xpath = "//table[@id='resultTable']/tbody/tr")
    public List<WebElement> employeeList;

    @FindBy(linkText = "Ievgenii Mari")
    public WebElement employeeNameFromTheList;

    @FindBy(id = "btnSave")
    public WebElement editButton;

    @FindBy(id = "personal_txtEmpFirstName")
    public WebElement fullNameField;

    @FindBy(className = "ui-datepicker-trigger")
    public WebElement calendar;

    @FindBy(className = "ui-datepicker-month")
    public WebElement monthSelectorDD;

    @FindBy(className = "ui-datepicker-year")
    public WebElement yearSelectorDD;

    @FindBy(className = "ui-icon ui-icon-circle-triangle-e")
    public WebElement nextButton;

    @FindBy(xpath = "//table[@class='ui-datepicker-calendar']/tbody/tr/td")
    public List<WebElement> datesOfTheMonth;

    @FindBy(xpath = "//div[@id='profile-pic']/h1")
    public WebElement employeeName;

    @FindBy(linkText = "Next")
    public WebElement nextButtonEmployeeList;

    public EmployeeListPage(){
        PageFactory.initElements(driver,this);
    }
}
