package stepDefinitions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import utilities.*;
import pageObjects.HomepageElements;
import pageObjects.CommonElements;

import java.util.List;
import java.util.Map;


public class PageAction {

    WebControl control = new WebControl();
    Console console = new Console();
    CommonElements cmn = new CommonElements();

    @And("User inputs {string} data in {string} field")
    public void populate_fld(String fldValue, String fldName){

        WebControl.waitElementToBeVisible(cmn.inputFld(fldName).getElementBy());
        if(cmn.inputFld(fldName).isDisplayed()){
            cmn.inputFld(fldName).sendKeys(fldValue);
            console.setPassed(fldName +" field has been populated! ");
        }else{
            console.setFailed(""+ fldName + "is not found","Check field name");
        }


    }

    //Inputs using Data Table:
    @And("User inputs data in the following fields")
    public void populate_fields(DataTable dataTable){

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data){
            String inpfld = row.get("Field Name");
            String expvalue = row.get("Expected Value");
            if(cmn.inputFld(inpfld).isDisplayed()){
                cmn.inputFld(inpfld).sendKeys(expvalue);
                console.setPassed(inpfld +" field has been populated! ");
            }else{
                console.setFailed(""+ inpfld + "is not found","Check field name");
            }

        }



    }

    @And("User clicks Submit button")
    public void click_submit(){

        if(cmn.submitBtn().isDisplayed()){
            cmn.submitBtn().click();
            console.setPassed("Submit button has been clicked! ");
        } else {
            console.setFailed("Submit button was not found!","Check button name!");
        }

    }

    @And("User clicks {string} link")
    public void click_link(String linkName){

        if(cmn.hyperlink(linkName).isDisplayed()){
            cmn.hyperlink(linkName).click();
            console.setPassed("Link has been clicked! ");
        } else {
            console.setFailed("Link was not found!","Check link name!");
        }

    }








}
