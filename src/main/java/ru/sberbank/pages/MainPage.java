package ru.sberbank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.sberbank.steps.BaseSteps;

import java.util.concurrent.TimeUnit;
public class MainPage {
WebDriver driver= BaseSteps.getDriver();

public MainPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
        }

    @FindBy(xpath = "//ul[@class='kitt-top-menu__list  kitt-top-menu__list_left']")
    WebElement mainMenu;




    public void selectMainMenu(String menuItem) {
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        mainMenu.findElement(By.xpath(".//label[contains(text(),'"+menuItem+"')]")).click();


    }

    public void selectSubMenu(String menuItem) {

        ((JavascriptExecutor) driver).executeScript("return arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//a[contains(text(),'"+ menuItem +"')]")));
        driver.findElement(By.xpath("//a[contains(text(),'"+menuItem+"')]")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


    }

}