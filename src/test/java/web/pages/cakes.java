package web.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import web.utils.Driver;
import web.utils.commonUtils;

import java.util.Map;

public class cakes {

    public static String emptycart="You have no items in your shopping cart.";
    public static String KidsCategory="//a[text()='\n" +
            "                                Kids Cakes                            ']";
    public static String cakes="//a[text()='  Cakes  ']";
    public static String cakemodel="//a[@href='https://www.eggfreecake.co.uk/princess-doll-yellow.html']";
    public static String search="//input[@placeholder='SEARCH CAKES... ']";
    public static String viewcart="//span[text()='View cart']";


public static void selectKidscake()
{
   Driver.getDriver().findElement(By.xpath(search)).sendKeys("princess yellow doll");
    Driver.getDriver().findElement(By.xpath(search)).sendKeys(Keys.ENTER);
    commonUtils.clickElement(By.xpath(cakemodel));
   commonUtils.pause(3);
}

public void addTocart(Map<String,String> tabletoMap)
{
try {
    Select sponge=new Select(Driver.getDriver().findElement(By.name("super_attribute[135]")));
     sponge.selectByVisibleText(tabletoMap.get("Sponge Flavour"));
    commonUtils.pause(1);
    Select size=new Select(Driver.getDriver().findElement(By.name("super_attribute[186]")));
     size.selectByVisibleText(tabletoMap.get("Size"));
    commonUtils.pause(1);
     Driver.getDriver().findElement(By.id("options_32402_text")).sendKeys(tabletoMap.get("Message on Cake"));
    WebElement Quantity=Driver.getDriver().findElement(By.id("qty"));
     Quantity.sendKeys(Keys.CONTROL+"a");
     Quantity.sendKeys(Keys.DELETE);
    commonUtils.pause(1);
     Quantity.sendKeys(tabletoMap.get("Quantity"));
     commonUtils.pause(1);
     commonUtils.clickButton(Driver.getDriver().findElement(By.id("product-addtocart-button")));
     commonUtils.pause(3);
}
catch (Exception e)
{
    e.printStackTrace();
}
}

public static void deleteall()
{
Driver.getDriver().findElement(By.xpath("//span[text()='View cart']")).click();
Driver.getDriver().findElement(By.xpath("//a[@title='Remove item']")).click();
commonUtils.pause(2);
}

public static void deleteVerify()
{
    String carttext=Driver.getDriver().findElement(By.xpath("//p[text()='You have no items in your shopping cart.']")).getText();
    Assert.assertEquals(emptycart,carttext);
}
}
