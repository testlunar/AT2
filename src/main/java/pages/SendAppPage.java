package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SendAppPage {
    public SendAppPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "surname_vzr_ins_0")
    WebElement surname;

    @FindBy(id = "name_vzr_ins_0")
    WebElement name;

    @FindBy(id = "person_lastName")
    WebElement person_lastName;

    @FindBy(id = "person_firstName")
    WebElement person_firstName;

    @FindBy(id = "person_middleName")
    WebElement person_middleName;

    @FindBy(xpath = "//*[contains(text(),'Мужской')]")
    WebElement sex;

    @FindBy(id = "passportSeries")
    WebElement passportSeries;

    @FindBy(id = "passportNumber")
    WebElement passportNumber;

    @FindBy(id = "documentIssue")
    WebElement documentIssue;

    @FindBy(id = "birthDate_vzr_ins_0")
    WebElement birthDate_vzr_ins_0;

    @FindBy(id = "person_birthDate")
    WebElement person_birthDate;

    @FindBy(id = "documentDate")
    WebElement documentDate;

    @FindBy(xpath = "//*[contains(text(),'Продолжить')]")
    public WebElement sendButton;


    public SendAppPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(sendButton)).click();
    }

   public void fillField(String fieldName, String value) {

            // default:  throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");

        }

    }





