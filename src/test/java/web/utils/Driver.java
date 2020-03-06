package web.utils;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeScenario;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class Driver {
    public static WebDriver driver;
    public static Properties prop;

    @BeforeScenario
    public static void intializeDriver() {
        if (driver == null) {
            driver = DriverFactory.getDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    @AfterScenario
    public static void closebrowser() {
        DriverFactory.closeDriver(driver);
    }

    @AfterSuite
    public static void quitbrowser(){
        DriverFactory.quitDriver(driver);
    }
}
