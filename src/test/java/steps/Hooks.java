package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;
import utils.Constants;

public class Hooks extends CommonMethods {
    ConfigReader configReader=new ConfigReader();

    @Before
    public void start(){
        setUp();
        LoginPage loginPage=new LoginPage();
    }

    @After
    public void teardown(Scenario scenario){

        byte[]pic;
        if(scenario.isFailed()){
            pic=takeScreenshot("failed/"+ scenario.getName());
        }else{
            pic=takeScreenshot("passed/"+ scenario.getName());
        }
        scenario.attach(pic,"image/png", scenario.getName());

        tearDown();
    }
}
