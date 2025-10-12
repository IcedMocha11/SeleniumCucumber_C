package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import utilities.Console;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import java.util.List;

import static utilities.BrowserDriver.driver;

public class WebControl extends BrowserDriver {
     Console console = new Console();

    public void wait(int sec) {
        try{
            sec = sec * 1000;
            Thread.sleep(sec);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void waitElementToBeVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitElementToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void navigateTo(String url){

        try{
            getDriver().get(url);
            waitForFullPageLoad(30);
            console.setPassed("Navigate to url: '" + url +"'");
        } catch (Exception e) {
            console.setFailed("Failed to navigate to: '" + url + "'",e.getMessage());
        }

    }

    public void waitForFullPageLoad(long timeoutInSeconds) {
        WebDriver driver = BrowserDriver.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));

        // Wait for document.readyState === "complete"
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
                .equals("complete"));

        // Wait for jQuery to finish (only if jQuery is present)
        wait.until(webDriver -> {
            JavascriptExecutor js = (JavascriptExecutor) webDriver;
            try {
                return (Boolean) js.executeScript("return (typeof jQuery === 'undefined') || (jQuery.active === 0)");
            } catch (Exception e) {
                // In case jQuery is not defined or another JS issue happens
                return true;
            }
        });

        // Additional check: Wait until the body contains some visible elements
        wait.until(webDriver -> {
            JavascriptExecutor js = (JavascriptExecutor) webDriver;
            String bodyText = js.executeScript("return document.body.textContent || ''").toString();
            return !bodyText.trim().isEmpty(); // Ensure the body is not blank
        });
    }


    public WebElement findElement(Element element) {
        try {
            return driver.findElement(element.getElementBy());
        } catch (Exception e) {
            console.setFailed("Could not find element: " + element.getElementBy(), e.getMessage());
            throw e;
        }
    }

    public List<WebElement> findElements(Element element) {
        try {
            return driver.findElements(element.getElementBy());
        } catch (Exception e) {
            console.setFailed("Could not find elements: " + element.getElementBy(), e.getMessage());
            throw e;
        }
    }

//    public void takeScreenshot(){
//        try {
//
//        }
//
//    }




}
