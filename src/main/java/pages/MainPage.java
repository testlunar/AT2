package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MainPage extends BasePage {
    WebElement element;
    WebDriver driver;
    //String originalWindow = driver.getWindowHandle();
    //final Set<String> oldWindowsSet = driver.getWindowHandles();

    @FindBy(xpath = "//ul[@class='kitt-top-menu__list  kitt-top-menu__list_left']")
    WebElement mainMenu;


    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    public void selectMainMenu(String menuItem) {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        mainMenu.findElement(By.xpath(".//label[contains(text(),'"+menuItem+"')]")).click();


    }

    public void selectSubMenu(String menuItem) {

        ((JavascriptExecutor) driver).executeScript("return arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//a[contains(text(),'"+ menuItem +"')]")));
        driver.findElement(By.xpath("//a[contains(text(),'"+menuItem+"')]")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


    }

}
