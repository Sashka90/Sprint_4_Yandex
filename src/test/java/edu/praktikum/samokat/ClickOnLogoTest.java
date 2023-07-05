package edu.praktikum.samokat;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClickOnLogoTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
    }

    @Test
    public void clickOnSamokatLogoTest() {
        new MainPage(driver, wait)
                .open()
                .clickOnSamokatLogo()
                .checkMainPageSamokat();
    }

    @Test
    public void clickOnYandexLogoTest() {
        new MainPage(driver, wait)
                .open()
                .clickOnYandexLogo()
                .checkPageYandex();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
