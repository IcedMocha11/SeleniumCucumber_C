package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class BrowserDriver {

    public static WebDriver driver;
    public static String baseUrl;

    public static void initializeDriver() throws IOException {
        if (driver == null) {
            // Create an instance of the Environment class
            Environment environment = new Environment();

            // Get the environment from system properties
            String env = System.getProperty("env", "default"); // Default to "default"
            baseUrl = environment.getBaseUrl(env);

            // Set the WebDriver path and initialize it
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/core/drivers/chromedriver.exe");

            ChromeOptions options = new ChromeOptions();

            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-gpu");

            driver = new ChromeDriver(options);

            driver.manage().window().maximize();

            driver.get(baseUrl);

        }
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("Driver not initialized. Call initializeDriver() first.");
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
