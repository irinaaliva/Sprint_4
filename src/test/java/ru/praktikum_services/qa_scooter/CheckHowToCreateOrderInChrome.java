package ru.praktikum_services.qa_scooter;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageObj.*;
import ru.praktikum_services.qa_scooter.constants.Url;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CheckHowToCreateOrderInChrome {
    private final String textCheckStatus;
    private final String name;
    private final String surname;
    private final String address;
    private final int metroValue;
    private final String phone;
    private final int day;
    private final int rentQuantity;
    private final String color;

    public CheckHowToCreateOrderInChrome(String textCheckStatus, String name, String surname, String address, int metroValue, String phone, int day, int rentQuantity, String color) {
        this.textCheckStatus = textCheckStatus;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroValue = metroValue;
        this.phone = phone;
        this.day = day;
        this.rentQuantity = rentQuantity;
        this.color = color;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderCheckStatus() {
        return new Object[][] {
                { "Посмотреть статус", "Иван","Иванов", "ул.Ленина, д.1, кв.1", 1, "77777777777", 27, 1, "black"},
                { "Посмотреть статус", "Петр","Петров", "ул.Гагарина, д.2, кв.2", 3, "11111111111", 28, 3,"grey"},
        };
    }

    private WebDriver driver;

    @Before
    public void setDriver() {
        driver = new ChromeDriver();
        driver.get(Url.url);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void checkMakeOrderWithButtonOnTop() {

        ScooterOrderMainPage orderPageMain = new ScooterOrderMainPage(driver);
        orderPageMain.clickCookieButton();
        orderPageMain.clickOrderButtonOnTop();

        ScooterOrderPageOne orderPageOne = new ScooterOrderPageOne(driver);
        orderPageOne.setOrderPageOne(name,surname, address, metroValue, phone);
        orderPageOne.clickOrderButtonNext();

        ScooterOrderPageTwo orderPageTwo = new ScooterOrderPageTwo(driver);
        orderPageTwo.setOrderPageTwo(day, rentQuantity, color);
        orderPageTwo.clickButtonMakeOrder();
        orderPageTwo.clickButtonOrderYes();
        assertEquals(textCheckStatus, orderPageTwo.getTextCheckStatus());
    }

    @Test
    public void checkMakeOrderWithButtonOnBottom() {

        ScooterOrderMainPage orderPageMain = new ScooterOrderMainPage(driver);
        orderPageMain.clickCookieButton();
        orderPageMain.clickOrderButtonOnBottom();

        ScooterOrderPageOne orderPageOne = new ScooterOrderPageOne(driver);
        orderPageOne.setOrderPageOne(name,surname, address, metroValue, phone);
        orderPageOne.clickOrderButtonNext();

        ScooterOrderPageTwo orderPageTwo = new ScooterOrderPageTwo(driver);
        orderPageTwo.setOrderPageTwo(day, rentQuantity, color);
        orderPageTwo.clickButtonMakeOrder();
        orderPageTwo.clickButtonOrderYes();
        assertEquals(textCheckStatus, orderPageTwo.getTextCheckStatus());
    }

    @After
    public void teardown() {
       driver.quit();
    }

}
