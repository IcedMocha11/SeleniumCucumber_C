package utilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import javax.management.ServiceNotFoundException;
import java.io.IOException;


public class Hooks {

    Console console = new Console();

    @Before(order=0)
    public void initialize(Scenario scenario) throws InterruptedException, IOException, ServiceNotFoundException {

        console.setInfo("Opening Browser...");
        BrowserDriver.initializeDriver();
        console.setInfo(BrowserDriver.baseUrl + " is successfully opened.");

    }

    @After(order = 0)
    public void tearDown(Scenario scenario) throws IOException {

        BrowserDriver.quitDriver();
        console.setInfo("Closing browser...");

    }

}
