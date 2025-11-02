package utilities;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import javax.management.ServiceNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Hooks {

    Console console = new Console();

    @Before(order=0)
    public void initialize(Scenario scenario) throws InterruptedException, IOException, ServiceNotFoundException {

        console.setInfo("Opening Browser...");
        BrowserDriver.initializeDriver();
        console.setInfo(BrowserDriver.baseUrl + " is successfully opened.");

    }

    @AfterStep
    public void captureExceptionImage(Scenario scenario) {
        if (scenario.isFailed()) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String timeMilliseconds = Long.toString(timestamp.getTime());

            byte[] screenshot = ((TakesScreenshot) BrowserDriver.getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", timeMilliseconds);
        }
    }

    @After(order = 0)
    public void tearDown(Scenario scenario) throws IOException {

        BrowserDriver.quitDriver();
        console.setInfo("Closing browser...");

    }

}
