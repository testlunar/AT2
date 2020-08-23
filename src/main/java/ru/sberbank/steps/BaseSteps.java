package ru.sberbank.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.allure.annotations.Attachment;

import java.util.concurrent.TimeUnit;


public class BaseSteps {
    public static WebDriver driver;
    public static WebDriver getDriver(){
               return driver;
    }



@Before
    public void startScenario() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.sberbank.ru/ru/person");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        System.out.println("Application title is ============="+driver.getTitle());
        driver.navigate().to("http://www.sberbank.ru/ru/person");
        Thread.sleep(6000);

    }



    @After
    public static void afterMethod(){        driver .quit();    }



    @Attachment(type = "image/png", value = "Screenshot")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}