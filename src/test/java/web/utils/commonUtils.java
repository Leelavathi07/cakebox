package web.utils;

import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.table.TableColumn;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class commonUtils extends Driver{

    public static void clickButton(WebElement element)
    {
        try
        {
           new WebDriverWait(getDriver(),30).until(ExpectedConditions.visibilityOf(element));
            element.click();
        }
        catch (WebDriverException e)
        {
            new WebDriverWait(getDriver(),30).until(ExpectedConditions.visibilityOf(element));
            element.click();
        }
    }

    public static void clickElement(By by)
    {
     try
     {
         new WebDriverWait(getDriver(),30).until(ExpectedConditions.visibilityOfElementLocated(by));
         Driver.getDriver().findElement(by).click();
     }
     catch (WebDriverException e)
     {
         new WebDriverWait(getDriver(),30).until(ExpectedConditions.visibilityOfElementLocated(by));
         Driver.getDriver().findElement(by).click();
     }
    }

    public static void pause(Integer no_of_seconds)
    {
        try{
            TimeUnit.SECONDS.sleep(no_of_seconds);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public static Map ConvertchildtableTomap(Table table)
    {
    Map<String,Object> Mapobj=new HashMap<>();
    for(TableRow row:table.getTableRows()) {
        for (String col : table.getColumnNames()) {
            Mapobj.put(col, row.getCell(col));
        }
    }
    return Mapobj;
    }

    public static void screenshot(String pictureName)
    {
        try {
            String fileName = "images/" + pictureName.concat(String.valueOf(System.currentTimeMillis()));
            File file = new File(System.getenv("gauge_reports_dir") + "/html-report/" + fileName);
            if (file.exists()) {
                file.delete();
            }
            File srcFile = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, file);
            Gauge.writeMessage("<a href='../"+fileName+"'><img src='../"+fileName+"'width='800' height='480'></a>");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
/*
    public static void EnterDetailsInTextBox(WebElement element,String texttoEnter)
    {
        new WebDriverWait(getDriver(),30).until(ExpectedConditions.visibilityOf(element));
        if(element.isEnabled())
        {
            element.click();
            element.sendKeys(Keys.CONTROL+"a");
            element.sendKeys(Keys.DELETE);
            element.sendKeys(texttoEnter);
        }
    }
*/
}

