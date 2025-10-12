package pageObjects;

import org.openqa.selenium.By;
import utilities.Element;


public class CommonElements {

    public static Element common_button (String header, String name) {
        return new Element("Element for : " + name,
                By.xpath("//" + header + "[contains(text(),'" + name + "')]"));
    }

    public Element pageTab (String tabName){
        return new Element("Page tab: " + tabName,
                By.xpath("//a[text()= '"+ tabName +"']"));
    }

    public Element inputFld (String fldName){
        return new Element("Input Field: " + fldName,
                By.xpath("//input[@id='"+ fldName +"' or @type='"+ fldName +"']"));
    }

    public Element submitBtn (){
        return new Element("Submit button: ",
                By.xpath("//button[@type='submit']"));
    }

    public Element hyperlink (String linkName) {
        return new Element("Link name: " + linkName,
                By.xpath("//a[normalize-space(text())='" + linkName + "']"));
    }






}
