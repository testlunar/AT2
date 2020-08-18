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
    public TravelnsurancePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }



    @FindBy(xpath = "//div[@class='t-content']//*[contains(text(),'Оформить онлайн')]")
    public WebElement sendButton;

    public TravelnsurancePage(WebDriver driver){

        PageFactory.initElements(driver, this);
        Wait<WebDriver> wait=  new WebDriverWait(driver, 5,1000);
        wait.until(ExpectedConditions.visibilityOf(sendButton)).click();


    }


}
