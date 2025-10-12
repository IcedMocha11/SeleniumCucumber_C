package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import static utilities.BrowserDriver.driver;

public class Element {
    private final By by;
    private WebElement element;
    private final String name;
    Console console = new Console();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

    public Element(String name, By by) {
        this.by = by;
        this.name = name;
    }

    public By getElementBy(){
        return by;
    }

    public void click() {
        try {
            // Locate the element
            element = driver.findElement(by);

            // Wait until the element is clickable, ignoring StaleElementReferenceException
            wait.ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.elementToBeClickable(element));

            // Retry clicking if StaleElementReferenceException happens
            try {
                element.click();
                console.setPassed("[" + name + "] Clicked element.");
            } catch (StaleElementReferenceException e) {
                // Re-locate the element and try clicking again
                element = driver.findElement(by);
                element.click();
                console.setPassed("[" + name + "] Clicked element after stale reference.");
            }

        } catch (Exception e) {
            console.setFailed("[" + name + "] Failed to click element:", e.getMessage());
            Assert.fail();
        }
    }


    public void sendKeys(String value) {
        try {
            element = driver.findElement(by);
            wait.ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.visibilityOf(element));
            element.sendKeys(value);
            console.setPassed("["+name+"] Entered '"+value+"' to element.");
        } catch (Exception e) {
            console.setFailed("["+name+"] Failed to enter '"+value+"' to element:", e.getMessage());
            Assert.fail();
        }
    }

    public boolean isDisplayed() {
        try {
            element = driver.findElement(by);
            wait.ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.visibilityOf(element));
            console.setPassed("["+name+"] is displayed");
            return element.isDisplayed();
        } catch (Exception e) {
            Assert.fail();
            return false;
        }
    }

    public String getText() {
        try {
            element = driver.findElement(by);
            wait.ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.presenceOfElementLocated(by));
            return element.getText();
        } catch (NoSuchElementException e){
            console.setFailed("Unable to locate element ["+ name +"]", e.getMessage());
            return null;
        } catch (Exception e) {
            console.setFailed("["+name+"] Failed to get element's text:", e.getMessage());
            return null;
        }
    }


}
