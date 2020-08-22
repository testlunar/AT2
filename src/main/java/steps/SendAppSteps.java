package steps;

import pages.SendAppPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class SendAppSteps extends BaseSteps {

    @Step("поле {0} заполняется значением {1}")
    public void fillField(String field, String value){
        new SendAppPage().fillField(field, value);
    }


    @Step("поле {0} заполнено значением {1}")
    public void checkFillField(String field, String value){
        String actual = new SendAppPage().getFillField(field);
        assertTrue(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, actual, value),
                actual.equals(value));
    }


    @Step("нажата кнопка Оформить")
    public void sendButton(){
        new SendAppPage().sendButton.click();
    }

    @Step("нажата кнопка Продолжить")
    public void sendButton2(){
        new SendAppPage().submitApp();
    }

    @Step("заполняются поля")
    public void fillFields(HashMap<String, String> fields){
        fields.forEach((k, v)-> fillField(k,v));
    }



    @Step("поля заполнены верно")
    public void checkFillFields(HashMap<String, String> fields){
        fields.forEach((k, v)-> checkFillField(k,v));
    }

    @Step("проверить на ошибку в пустых полях")
    public void checkError(String field, String errorMessage) {
        new SendAppPage().checkFieldErrorMessage(field, errorMessage);
    }

}
