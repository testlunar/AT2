package ru.sberbank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import ru.sberbank.steps.BaseSteps;


public class BasePageObject  {


        protected WebDriver driver;

        public BasePageObject() {
            PageFactory.initElements(BaseSteps.getDriver(), this);
        }



        public void fillField(WebElement field, String value){
            field.clear();
            field.sendKeys(value);
        }
    }

