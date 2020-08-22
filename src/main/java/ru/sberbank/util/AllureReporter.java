package ru.sberbank.util;


import org.junit.runner.notification.Failure;


public class AllureReporter extends ru.yandex.qatools.allure.cucumberjvm.AllureReporter {

    @Override
    public void testFailure(Failure failure){
       // BaseSteps.takeScreenshot();
        //super.testFailure(failure);
        System.out.println("Тест завален!");

    }

}
