package ru.sberbank.steps;

import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class ScenarioSteps {
    MainPageSteps mainPageSteps = new MainPageSteps();
    TravelInsuranceSteps travelInsuranceSteps = new TravelInsuranceSteps();
    SendAppSteps sendAppSteps = new SendAppSteps();



    @When("^выбран пункт меню \"(.+)\"$")
    public void selectMenuItem(String menuName){
        mainPageSteps.selectMenuItem(menuName);
    }



    @When("^выбран вид страхования \"(.+)\"$")
    public void selectMenuInsurance(String menuName){
        mainPageSteps.selectMenuInsurance(menuName);
    }



    @Then("^нажать на кнопку Отправить заявку$")
    public void waitSendAppClickable() throws InterruptedException {
        travelInsuranceSteps.waitSendAppClickable();
    }



    @Then("^нажать кнопка Оформить$")
    public void sendButton(){
        sendAppSteps.sendButton();
    }


    @When("^заполнятся поля:$")
    public void fillForm(DataTable fields){
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> sendAppSteps.fillField(field, value));
    }

    @When("^нажата кнопка Продолжить$")
    public void sendButton2(){
        sendAppSteps.sendButton2();
    }

    @Then("^проверить ошибку на кнопке Продолжить$")
    public void checkSendButtonError1(){
        sendAppSteps.checkSendButtonError();
    }


     @Then("^ проверить в поле \"(.+)\" присутствует сообщение об ошибке \"(.+)\"$")
    public void checkFieldError2(String field, String errorMessage){
        sendAppSteps.checkFieldError(field, errorMessage);
    }
}
