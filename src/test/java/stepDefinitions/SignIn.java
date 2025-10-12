package stepDefinitions;

import io.cucumber.java.af.En;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import utilities.*;
import pageObjects.HomepageElements;


public class SignIn {
    static WebControl control = new WebControl();
    Console console = new Console();
    Environment env = new Environment();
    HomepageElements homepg = new HomepageElements();

    private WebDriver driver;


    @Given("^the user is already on the rahulshetty website$")
    public void access_website() {

        //Log this step on the report
        //Log.stepDefinitionName();
        control.waitForFullPageLoad(5);
        WebControl.waitElementToBeVisible(homepg.rahul_home.getElementBy());
        if(homepg.rahul_home.isDisplayed()){
            console.setPassed("User already in homepage");
        } else {
            console.setFailed("user is not on the homepage","Check website");
        }

    }


    @Given("^The user is already on the GreenKart page$")
    public void access_GreenKart() {

        //Log this step on the report
        //Log.stepDefinitionName();
        control.waitForFullPageLoad(5);
        WebControl.waitElementToBeVisible(homepg.GreenKart_logo.getElementBy());
        if(homepg.GreenKart_logo.isDisplayed()){
            console.setPassed("User already in the landing page");
        } else {
            console.setFailed("user is not on the landing page","Check website");
        }



    }

}


