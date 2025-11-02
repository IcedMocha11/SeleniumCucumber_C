//package hooks;
//
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import org.openqa.selenium.PageLoadStrategy;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//
//public class HooksSetup {
//    private WebDriver driver;
//
//    @Before
//    public void setup(){
//        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/core/drivers/chromedriver.exe");
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//        driver = new ChromeDriver(chromeOptions);
//        driver.manage().window().maximize();
//    }
//
//    @After
//    public void tearDown(){
//        driver.quit();
//    }
//}
//
//// as of June 4, nasa course # 30 ka na ng course ni Rahul Shetty