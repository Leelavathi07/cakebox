package web.pages;

import com.thoughtworks.gauge.Gauge;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import web.utils.Driver;
import web.utils.commonUtils;
public class login {

    @FindBy(xpath = "//a[text()='Login']")
    WebElement login1;

/*    public static String login="//a[text()='\n" +
            "        Login    ']";*/

    public static String login="//a[contains(text(),'Login')]";

    public static String Loginsubmit="//button[@id='send2']";

    public static void clickonLogin()
    {
      //commonUtils.clickButton(login1);
        commonUtils.clickElement(By.xpath(login));
    }

    public void EnterCustomerDetails(String email,String password)
    {
        commonUtils.pause(2);
        ((JavascriptExecutor)Driver.getDriver()).executeScript("scroll(0,300);");
    // commonUtils.EnterDetailsInTextBox(username,System.getenv(email));
    // commonUtils.EnterDetailsInTextBox(Password,System.getenv(password));
        commonUtils.pause(2);
        Driver.getDriver().findElement(By.xpath("//input[@title='Email']")).sendKeys(System.getenv(email));
        Driver.getDriver().findElement(By.xpath("//input[@title='Password']")).sendKeys(System.getenv(password));
    }

    public void clickloginbutton()
    {
        commonUtils.clickElement(By.xpath(Loginsubmit));
        commonUtils.pause(5);
    }
}
