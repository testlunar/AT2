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

public class TravelnsurancePage extends BasePage {

    WebDriver driver;


    //@FindBy(xpath = "//div[@class='t-content']//*[contains(text(),'Оформить онлайн')]")
    //public WebElement sendButton;

    public TravelnsurancePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }


    public void waitSendAppClickable() {
        String originalWindow = driver.getWindowHandle();
        final Set<String> oldWindowsSet = driver.getWindowHandles();

        String signOnline = "//div[@class='t-content']//*[contains(text(),'Оформить')]";
        ((JavascriptExecutor) driver).executeScript("return arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(signOnline)));
        driver.findElement(By.xpath(signOnline)).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);


        String newWindowHandle = (new WebDriverWait(driver, 30))
                .until(new ExpectedCondition<String>() {
                           public String apply(WebDriver driver) {
                               Set<String> newWindowsSet = driver.getWindowHandles();
                               newWindowsSet.removeAll(oldWindowsSet);
                               return newWindowsSet.size() > 0 ?
                                       newWindowsSet.iterator().next() : null;
                           }
                       }
                );
        driver.switchTo().window(newWindowHandle);
    }
}

