package pageObjects;
import org.openqa.selenium.By;
import utilities.Element;

public class HomepageElements {

    public Element rahul_home = new Element("Rahul Homepage",
            By.xpath("//div[contains(@class, 'logo')]"));


    public Element GreenKart_logo = new Element("GreenKart page: ",
            By.xpath("//div[@class='brand greenLogo']"));




}
