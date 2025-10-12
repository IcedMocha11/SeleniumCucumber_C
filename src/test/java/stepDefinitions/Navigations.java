package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import utilities.*;
import pageObjects.HomepageElements;
import pageObjects.CommonElements;

public class Navigations {

    static WebControl control = new WebControl();
    Console console = new Console();
    CommonElements cmn = new CommonElements();

    @And("User navigates to {string} tab")
    public void click_tab(String tabName){

        WebControl.waitElementToBeVisible(cmn.pageTab(tabName).getElementBy());
        if(cmn.pageTab(tabName).isDisplayed()){
            cmn.pageTab(tabName).click();
            console.setPassed(tabName +" tab has been clicked! ");
        } else {
            console.setFailed(" " +tabName+ " is not found","Check tab name!");
        }

    }




}
