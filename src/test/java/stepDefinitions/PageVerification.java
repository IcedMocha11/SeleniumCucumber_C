package stepDefinitions;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebElement;
import utilities.*;

import pageObjects.CommonElements;
import pageObjects.MiscElements;
import utilities.Utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageVerification {

    WebControl control = new WebControl();
    Console console = new Console();
    CommonElements cmn = new CommonElements();
    MiscElements msc = new MiscElements();



    @And("Verify if {string} is in the results")
    public void storeResult(String verData){


        List<WebElement> searchResults = control.findElements(msc.products());
        List<Map<String, String>> resultDetails = new ArrayList<>();

        for(WebElement result : searchResults){
            String name = result.findElement(msc.productName().getElementBy()).getText();
            String price = result.findElement(msc.productPrice().getElementBy()).getText();

            Map<String, String> details = new HashMap<>();
            details.put("name", name);
            details.put("price", price);

            resultDetails.add(details);

        }

        for (Map<String, String> product : resultDetails) {
            console.setPassed("Product: " + product.get("name") + " | Price: " + product.get("price"));
        }

        boolean found = resultDetails.stream().anyMatch(item -> item.get("name").contains(verData));

        if(found){
            console.setPassed(verData + " product found!");
        } else {
            console.setFailed("Failed",verData + " not found!");
        }

        control.wait(5);
        Utilities.captureScreenshot("ResultVerification_" + verData);



    }











}
