package pages;


import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import steps.BaseSteps;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class SendAppPage extends BasePageObject {


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

    @FindBy(id = "email")
    WebElement email;

    @FindBy(xpath = "//div[@class='row']//*[contains(text(),'Оформить')]")
    public WebElement sendButton;

    @FindBy(xpath ="//div[@class='row']//*[contains(text(),'Продолжить')]")
    public WebElement  sendButton2;

    public SendAppPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
         this.driver= driver;
    }


    public void fillField(String fieldName, String value) {
        switch (fieldName) {
            case "Фамилия застрахованного":
                fillField(surname, value);
                break;
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
            case "Электронная почта":
                fillField(email, value);
                break;

            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
        }
    }

    public void submitApp() {
        new SendAppPage().sendButton2.click();
        assertEquals("При заполнении данных произошла ошибка", BaseSteps.getDriver().findElement(By.xpath("//div[@class='alert-form alert-form-error']")).getText());
        System.out.println("Тест завершен!");
    }

    public String getFillField(String fieldName) {
        switch (fieldName) {
            case "Фамилия застрахованного":
                return surname.getAttribute("value");
            case "Имя застрахованного":
                return name.getAttribute("value");
            case "Фамилия страхователя":
                return person_lastName.getAttribute("value");
            case "Имя страхователя":
                person_firstName.getAttribute("value");
            case "Отчество страхователя":
                person_middleName.getAttribute("value");
            case "Пол":
                return new Select(sex).getAllSelectedOptions().get(0).getText();
            case "Серия паспорта":
                passportSeries.getAttribute("value");
            case "Номер паспорта":
                passportNumber.getAttribute("value");
            case "Где выдан":
                documentIssue.getAttribute("value");
            case "Дата рождения застрахованного":
                birthDate_vzr_ins_0.getAttribute("value");
            case "Дата рождения страхователя":
                person_birthDate.getAttribute("value");
            case "Дата выдачи паспорта":
                documentDate.getAttribute("value");
            case "Электронная почта":
                email.getAttribute("value");

        }
        throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
    }

    public void checkFieldErrorMessage(String field, String errorMessage) {

        String xpath = "//form-control-label[@title='" + field + "']//*[@class='invalid-validate form-control__message']";
        String actualValue = BaseSteps.getDriver().findElement(By.xpath(xpath)).getText();
        Assert.assertTrue(String.format("Получено значение [%s]. Ожидалось [%s]", actualValue, errorMessage),
                actualValue.contains(errorMessage));

        assertEquals("При заполнении данных произошла ошибка", BaseSteps.getDriver().findElement(By.xpath("//div[@class='alert-form alert-form-error']")).getText());
        System.out.println("Получена корректная ошибка на кнопке 'Продолжить'");
    }
}








