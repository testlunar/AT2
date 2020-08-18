import org.junit.Test;
import pages.MainPage;
import pages.SendAppPage;
import pages.TravelnsurancePage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class MyRefactoringTest extends BaseTest {

    @Test
    public void newInsuranceTest() throws Exception {
        //driver.get(baseUrl + "/");
        MainPage mainPage = new MainPage(driver);
        mainPage.selectMainMenu("Страхование");
        mainPage.selectSubMenu("Страхование путешественников");


        new TravelnsurancePage(driver).waitSendAppClickable();

        SendAppPage sendAppPage = new SendAppPage(driver);
        new SendAppPage(driver).waitSendAppClickable();

        sendAppPage.fillField("Фамилия застрахованного", "Иванов");
        sendAppPage.fillField("Имя застрахованного", "Иван");
        sendAppPage.fillField("Фамилия страхователя", "Иванов");
        sendAppPage.fillField("Имя страхователя", "Олег");
        sendAppPage.fillField("Отчество страхователя", "Иванович");
        sendAppPage.fillField("Серия паспорта", "9287");
        sendAppPage.fillField("Номер паспорта", "737464");
        sendAppPage.fillField("Где выдан", "Москва");
        sendAppPage.fillField("Дата рождения застрахованного", "15.05.1975");
        sendAppPage.fillField("Дата рождения страхователя", "14.07.1988");
        sendAppPage.fillField("Дата выдачи паспорта", "25.09.2000");
        sendAppPage.fillField("Электронная почта", "");
        new SendAppPage(driver).submitApp();


    }
}
