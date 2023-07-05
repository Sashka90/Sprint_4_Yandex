package edu.praktikum.samokat;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Parameterized.class)
public class OrderSamokatTest {

    private final String name;
    private final String lastName;
    private final String address;
    private final String metroStation;
    private final String telephone;
    private final String date;
    private final String rentalDate;
    private final String color;
    private final String comment;

    private WebDriver driver;
    private WebDriverWait wait;

    public OrderSamokatTest(String name, String lastName, String address, String metroStation, String telephone, String date, String rentalDate, String color, String comment) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.telephone = telephone;
        this.date = date;
        this.rentalDate = rentalDate;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][] {
                {"Александр", "Якушев", "Улица Пушкина, дом Колотушкина", "Черкизовская", "79046667788", "01.08.2023", "Сутки", "чёрный жемчуг", ":)"},
                {"Иван", "Иванов", "Кремль, дом 1", "Строгино", "79046667788", "21.07.2023", "Трое суток", "серая безысходность", ":)"},
                {"Василий", "Задов", "Москва, улица красивых молдавских партизан д.33", "Бабушкинская", "79046667788", "21.09.2023", "Семеро суток", "серая безысходность", ":)"}
        };
    }

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
    }

    @Test
    public void orderSamokatTest() {
        new MainPage(driver, wait)
                .open()
                .clickToAcceptCookieButton()
                .clickHeaderOrderButton()
                .fillOrderFieldsPersonalData(name, lastName, address, metroStation, telephone)
                .clickNextButton()
                .fillOrderFieldsAboutRent(date, rentalDate, color, comment)
                .clickOrderButton()
                .clickYesButton()
                .checkSubmitOrder();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
