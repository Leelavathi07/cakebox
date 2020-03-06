package web.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
    public static WebDriver getDriver() {
        String browser = System.getenv("BROWSER");
        String chromeDriverPath = System.getenv("CHROMEDRIVERPATH");
        String ieDriverPath = System.getenv("IEDRIVERPATH");
        switch (browser) {
            case "IE":
                System.setProperty("webdriver.ie.driver", ieDriverPath);
                return new InternetExplorerDriver();
            case "chrome":
                System.setProperty("webdriver.chrome.driver", chromeDriverPath);
                return new ChromeDriver();
        }
        return null;
    }

    public static void closeDriver(WebDriver driver)
    {
        try {
           if(driver!=null)
           {
               driver.close();
           }
        }
        catch (Exception e){
                e.printStackTrace();
        }
    }

    public static void quitDriver(WebDriver driver)
    {
        try {
            if(driver!=null)
            {
                driver.quit();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}