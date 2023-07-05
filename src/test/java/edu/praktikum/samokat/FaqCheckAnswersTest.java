package edu.praktikum.samokat;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FaqCheckAnswersTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
    }

    @Test
    public void faqCheckAnswersTest() {
        new MainPage(driver, wait)
                .open()
                .clickToAcceptCookieButton()
                .moveToBottomOfPage()
                .checkFaqAnswersIsVisible();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
