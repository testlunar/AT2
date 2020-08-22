import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;
import steps.BaseSteps;
import steps.MainPageSteps;
import steps.SendAppSteps;
import steps.TravelInsuranceSteps;

import java.util.HashMap;

public class ExampleTest extends BaseSteps {
    MainPageSteps mainPageSteps = new MainPageSteps();
    TravelInsuranceSteps travelInsuranceSteps = new TravelInsuranceSteps();
    SendAppSteps sendAppSteps = new SendAppSteps();
    HashMap<String, String> testData = new HashMap<>();


    @Title("Оформить страхование для путешественников")
    @Test
    public void Test() throws InterruptedException {
        testData.put("Фамилия застрахованного", "Иванов");
        testData.put("Имя застрахованного", "Иван");
        testData.put("Фамилия страхователя", "Иванов");
        testData.put("Имя страхователя", "Олег");
        testData.put("Отчество страхователя", "Иванович");
        testData.put("Серия паспорта", "9287");
        testData.put("Номер паспорта", "737464");
        testData.put("Где выдан", "Москва");
        testData.put("Дата рождения застрахованного", "15.05.1975");
        testData.put("Дата рождения страхователя", "14.07.1988");
        testData.put("Дата выдачи паспорта", "25.09.2000");
        testData.put("Электронная почта", "");


        mainPageSteps.selectMenuItem("Страхование");
        mainPageSteps.selectMenuInsurance("Страхование путешественников");
        travelInsuranceSteps.waitSendAppClickable();

        sendAppSteps.sendButton();
        sendAppSteps.fillFields(testData);
        sendAppSteps.sendButton2();
        sendAppSteps.checkError("Электронная почта","Какая то ошибка");












    }
}

