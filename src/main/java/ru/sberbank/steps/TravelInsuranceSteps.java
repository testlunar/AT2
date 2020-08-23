package ru.sberbank.steps;

import ru.sberbank.pages.TravelInsurancePage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.concurrent.TimeUnit;

public class TravelInsuranceSteps  {




    @Step("выполнено нажатие на кнопку Оформить")
    public void waitSendAppClickable() throws InterruptedException {

        new TravelInsurancePage().waitButtonClickable();
        BaseSteps.getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

    }



}
