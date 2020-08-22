package ru.sberbank.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.sberbank.steps.BaseSteps;

import java.util.Set;

public class TravelInsurancePage extends BasePageObject {


    @FindBy(xpath = "//div[@class='t-content']//*[contains(text(),'Оформить онлайн')]")
    public WebElement button;

    @FindBy(xpath = "//button[@class='kitt-cookie-warning__close']")
    public WebElement cookie;

    Set<String> oldWindowsSet;


    public TravelInsurancePage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);

        (new WebDriverWait(BaseSteps.getDriver(), 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='t-content']//*[contains(text(),'Оформить онлайн')]")));
    }


    public void waitButtonClickable() throws InterruptedException {
        String parentWindow = BaseSteps.getDriver().getWindowHandle();

        String s = BaseSteps.getDriver().getTitle();
        System.out.println("Я на странице" + s);

        new TravelInsurancePage().cookie.click();
        new TravelInsurancePage().button.click();
        Thread.sleep(3000);

        for (String winHandle : BaseSteps.getDriver().getWindowHandles()) {
            if (!parentWindow.equals(winHandle)) {
                BaseSteps.getDriver().switchTo().window(winHandle);
                Thread.sleep(3000);
                break;
            }
        }
        System.out.println("Title of the page after - switchingTo: " + BaseSteps.getDriver().getTitle());


    }
}




