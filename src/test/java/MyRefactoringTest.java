import org.junit.Test;
import pages.MainPage;
import pages.SendAppPage;
import pages.TravelnsurancePage;

public class MyRefactoringTest extends BaseTest {

    @Test
    public void newInsuranceTest(){
        driver.get(baseUrl + "/");
     MainPage mainPage = new MainPage(driver);
     mainPage.selectMainMenu("Страхование");
     mainPage.selectSubMenu("Страхование путешественников");

     new TravelnsurancePage(driver).sendButton.click();

        SendAppPage sendAppPage=  new SendAppPage(driver);
        sendAppPage.fillField("Фамилия застрахованного","Иванов");
        sendAppPage.fillField("Имя застрахованного","Иван");
        sendAppPage.fillField("Фамилия страхователя","Иванов");
        sendAppPage.fillField("Имя страхователя","Олег");
        sendAppPage.fillField("Отчество страхователя","Иванович");
        sendAppPage.fillField("Серия паспорта","9287");
        sendAppPage.fillField("Номер паспорта","737464");
        sendAppPage.fillField("Где выдан","Москва");
        sendAppPage.fillField("Дата рождения застрахованного","15.05.1975");
        sendAppPage.fillField("Дата рождения страхователя","14.07.1988");
        sendAppPage.fillField("Дата выдачи паспорта","25.09.2000");
    }
}
