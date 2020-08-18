package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MainPage  {
    WebElement element;
       WebDriver driver;

       @FindBy(xpath = "//ul[@class='kitt-top-menu__list  kitt-top-menu__list_left']")
    WebElement mainMenu;

   @FindBy(xpath = "//div[@class='kitt-top-menu__dropdown']")
    WebElement subMenu;

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void selectMainMenu( String menuItem){
    //mainMenu.findElement(By.xpath(".//button[@class='lg-menu__link']//*[contains(text(),'"+menuItem+"')]"));
       mainMenu.findElement(By.xpath(".//label[contains(text(),'"+menuItem+"')]")).click();

    }

    public void selectSubMenu( String menuItem){

        ((JavascriptExecutor) driver).executeScript("return arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//a[contains(text(),'"+menuItem+"')]")));
        driver.findElement(By.xpath(".//a[contains(text(),'"+menuItem+"')]")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        String originalWindow = driver.getWindowHandle();
        final Set<String> oldWindowsSet = driver.getWindowHandles();

        String signOnline= "//div[@class='t-content']//*[contains(text(),'Оформить онлайн')]";
        ((JavascriptExecutor) driver).executeScript("return arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(signOnline)));
        driver.findElement(By.xpath(signOnline)).click();
        driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);



    }

}
