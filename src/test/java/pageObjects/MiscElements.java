package pageObjects;
import org.openqa.selenium.By;
import utilities.Element;

public class MiscElements {

    public Element pageTab (String tabName){
        return new Element("Page tab: " + tabName,
                By.xpath("//a[text()= '"+ tabName +"']"));
    }

    public Element products(){
        return new Element("Products: " ,
                By.xpath("//div[@class='products']/div[@class='product']"));
    }

    public Element productName(){
        return new Element("Product Name: " ,
                By.xpath(".//h4[@class='product-name']"));
    }

    public Element productPrice(){
        return new Element("Product Price: " ,
                By.xpath(".  //p[@class='product-price']"));
    }


}
