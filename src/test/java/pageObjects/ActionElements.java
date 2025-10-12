package pageObjects;
import org.openqa.selenium.By;
import utilities.Element;

public class ActionElements {

    public Element search(){
        return new Element("Search buton: ",
                By.xpath("//button[@class = 'search-buton']"));
    }








}
