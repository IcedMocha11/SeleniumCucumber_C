package functions;
import pageObjects.CommonElements;
import utilities.WebControl;


public class CommonFunctions extends CommonElements{
    public static void click_button(String header, String name) {
        WebControl.waitElementToBeVisible(common_button(header,name).getElementBy());
        common_button(header,name).click();
    }


}
