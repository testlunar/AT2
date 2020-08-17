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

       @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[4]/nav/div/ul/li[7]/label']")
    WebElement mainMenu;

   //@FindBy(xpath = "//li[@class='kitt-top-menu__item kitt-top-menu__item_first kitt-top-menu__item_opened']")
    //WebElement subMenu;

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void selectMainMenu( String menuItem){
    //mainMenu.findElement(By.xpath(".//button[@class='lg-menu__link']//*[contains(text(),'"+menuItem+"')]"));
       driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[4]/nav/div/ul/li[7]/label']")).click();


    }

    public void selectSubMenu( String menuItem){
        //String subMenu1 = "//li[@class='kitt-top-menu__item kitt-top-menu__item_first kitt-top-menu__item_opened']//*[contains(text(),'Страхование путешественников')]";
        ((JavascriptExecutor) driver).executeScript("return arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//li[@class='kitt-top-menu__item kitt-top-menu__item_first kitt-top-menu__item_opened']//*[contains(text(),'Страхование путешественников')]")));
        driver.findElement(By.xpath("//li[@class='kitt-top-menu__item kitt-top-menu__item_first kitt-top-menu__item_opened']//*[contains(text(),'Страхование путешественников')]")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        String originalWindow = driver.getWindowHandle();
        final Set<String> oldWindowsSet = driver.getWindowHandles();

        String signOnline= "//div[@class='t-content']//*[contains(text(),'Оформить онлайн')]";
        ((JavascriptExecutor) driver).executeScript("return arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(signOnline)));
        driver.findElement(By.xpath(signOnline)).click();
        driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);



    }

}
