package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class JobPage extends CommonMethods {

    @FindBy(id = "menu_admin_Job")
    public WebElement jobButton;

    @FindBy(id = "menu_admin_viewJobTitleList")
    public WebElement jobTitleListButton;

    @FindBy(id = "btnAdd")
    public WebElement addButton;

    @FindBy(id = "jobTitle_jobTitle")
    public WebElement jobTitleBox;

    @FindBy(id = "jobTitle_jobDescription")
    public WebElement jobDescriptionBox;

    @FindBy(id = "jobTitle_note")
    public WebElement noteBox;

    @FindBy(id = "btnSave")
    public WebElement saveButton;

    public JobPage(){
        PageFactory.initElements(driver,this);
    }

}
