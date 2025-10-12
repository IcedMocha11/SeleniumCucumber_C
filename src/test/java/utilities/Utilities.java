package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;

public class Utilities {

    static Console console = new Console();
    public static String folderName = null;

        public static String getTimeStamp() {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.format(new Date());
        }

    public static String captureScreenshot(String screenshotName) {
        //WebDriver driver = getDriver();
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        // Define path to save screenshot
        String screenshotPath = System.getProperty("user.dir") +
                "/target/screenshots/" + screenshotName + "_" + timestamp + ".png";

        try {
            File srcFile = ((TakesScreenshot) BrowserDriver.getDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, new File(screenshotPath));
            console.setInfo("Screenshot saved at: " + screenshotPath);
        } catch (IOException e) {
            console.setInfo("Failed to capture screenshot: " + e.getMessage());
        }

        return screenshotPath;
    }



}
