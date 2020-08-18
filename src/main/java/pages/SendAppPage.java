package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class SendAppPage extends BasePage {


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

    public SendAppPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }


    public void waitSendAppClickable() {


        String sendButton = "//div[@class='row']//*[contains(text(),'Оформить')]";
        ((JavascriptExecutor) driver).executeScript("return arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(sendButton)));
        driver.findElement(By.xpath(sendButton)).click();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);


    }


    public void fillField(String fieldName, String value) {
        ((JavascriptExecutor) driver).executeScript("return arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//div[@class='row']//*[contains(text(),'Продолжить')]")));
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
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
        String sendButton2 = "//div[@class='row']//*[contains(text(),'Продолжить')]";
        ((JavascriptExecutor) driver).executeScript("return arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(sendButton2)));
        driver.findElement(By.xpath(sendButton2)).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        assertEquals("При заполнении данных произошла ошибка", driver.findElement(By.xpath("//div[@class='alert-form alert-form-error']")).getText());
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
        throw new AssertionError("Поле не объявлено на странице");
    }


}








