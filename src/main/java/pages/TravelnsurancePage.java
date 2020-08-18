package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TravelnsurancePage {

    WebDriver driver;




    @FindBy(xpath = "//div[@class='t-content']//*[contains(text(),'Оформить онлайн')]")
    public WebElement sendButton;

    public TravelnsurancePage(WebDriver driver) {
        //String signOnline = "//div[@class='t-content']//*[contains(text(),'Оформить онлайн')]";
        //((JavascriptExecutor) driver).executeScript("return arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(signOnline)));
        // driver.findElement(By.xpath(signOnline)).click();
        // driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(sendButton)).click();


    }


}
