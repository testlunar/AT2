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
        switch (fieldName) {
            case "Имя застрахованного":
                fillField(name, value);
                break;
            case "Фамилия страхователя":
                fillField(person_lastName, value);
                break;
            case "Имя страхователя":
                fillField(person_firstName, value);
                break;
            case "Отчество страхователя":
                fillField(person_middleName, value);
                break;
            case "Пол":
                new Select(sex).selectByVisibleText("Мужской");
                break;
            case "Серия паспорта":
                fillField(passportSeries, value);
                break;
            case "Номер паспорта":
                fillField(passportNumber, value);
                break;
            case "Где выдан":
                fillField(documentIssue, value);
                break;
            case "Дата рождения застрахованного":
                fillField(birthDate_vzr_ins_0, value);
                birthDate_vzr_ins_0.sendKeys(Keys.TAB);
                break;
            case "Дата рождения страхователя":
                fillField(person_birthDate, value);
                person_birthDate.sendKeys(Keys.TAB);
                break;
            case "Дата выдачи паспорта":
                fillField(documentDate, value);
                documentDate.sendKeys(Keys.TAB);
                break;

            // default:  throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");

        }

    }
}




