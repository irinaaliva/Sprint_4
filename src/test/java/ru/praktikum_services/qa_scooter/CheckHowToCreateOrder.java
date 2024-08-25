package ru.praktikum_services.qa_scooter;
import page_obj.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Test;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class CheckHowToCreateOrder {
    private WebDriver driver;

    @Test
    public void checkMakeOrderWithButtonOnTop() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        ScooterOrderMainPage orderPageMain = new ScooterOrderMainPage(driver);
        orderPageMain.clickCookieButton();
        orderPageMain.clickOrderButtonOnTop();

        ScooterOrderPageOne orderPageOne = new ScooterOrderPageOne(driver);
        orderPageOne.setOrderPageOne("Иван","Иванов", "ул.Ленина, д.1, кв.1", 1, "77777777777");
        orderPageOne.clickOrderButtonNext();

        ScooterOrderPageTwo orderPageTwo = new ScooterOrderPageTwo(driver);
        orderPageTwo.setOrderPageTwo(27, 1,"black");
        orderPageTwo.clickButtonMakeOrder();
        orderPageTwo.clickButtonOrderYes();
        assertEquals("Заказ оформлен", orderPageTwo.getTextOrderDone());
    }

    @Test
    public void checkMakeOrderWithButtonOnBottom() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        ScooterOrderMainPage orderPageMain = new ScooterOrderMainPage(driver);
        orderPageMain.clickCookieButton();
        orderPageMain.clickOrderButtonOnBottom();

        ScooterOrderPageOne orderPageOne = new ScooterOrderPageOne(driver);
        orderPageOne.setOrderPageOne("Петр","Петров", "ул.Гагарина, д.2, кв.2", 3, "11111111111");
        orderPageOne.clickOrderButtonNext();

        ScooterOrderPageTwo orderPageTwo = new ScooterOrderPageTwo(driver);
        orderPageTwo.setOrderPageTwo(28, 3,"grey");
        orderPageTwo.clickButtonMakeOrder();
        orderPageTwo.clickButtonOrderYes();
        assertEquals("Заказ оформлен", orderPageTwo.getTextOrderDone());
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
