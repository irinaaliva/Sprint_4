package ru.praktikum_services.qa_scooter;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobj.*;
import ru.praktikum_services.qa_scooter.constants.Url;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CheckHowToCreateOrder {
    private final String textCheckStatus;
    private final String name;
    private final String surname;
    private final String address;
    private final int metroValue;
    private final String phone;
    private final int day;
    private final int rentQuantity;
    private final String color;
    private final String browser;

    public CheckHowToCreateOrder(String textCheckStatus, String name, String surname, String address, int metroValue, String phone, int day, int rentQuantity, String color, String browser) {
        this.textCheckStatus = textCheckStatus;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroValue = metroValue;
        this.phone = phone;
        this.day = day;
        this.rentQuantity = rentQuantity;
        this.color = color;
        this.browser = browser;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderCheckStatus() {
        return new Object[][] {
                { "Посмотреть статус", "Иван","Иванов", "ул.Ленина, д.1, кв.1", 1, "77777777777", 27, 1, "black", "edge"},
                { "Посмотреть статус", "Петр","Петров", "ул.Гагарина, д.2, кв.2", 3, "11111111111", 28, 3,"grey", "edge"},
                { "Посмотреть статус", "Иван","Иванов", "ул.Ленина, д.1, кв.1", 1, "77777777777", 27, 1, "black", "chrome"},
                { "Посмотреть статус", "Петр","Петров", "ул.Гагарина, д.2, кв.2", 3, "11111111111", 28, 3,"grey", "chrome"},
        };
    }

    private WebDriver driver;


    private void setDriver(String browser) {
        if (Objects.equals(browser, "edge"))
        {
            driver = new EdgeDriver();
        }
        else if (Objects.equals(browser, "chrome"))
        {
            driver = new ChromeDriver();
        }
        driver.get(Url.url);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void checkMakeOrderWithButtonOnTop() {

        setDriver(browser);

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

        setDriver(browser);

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
