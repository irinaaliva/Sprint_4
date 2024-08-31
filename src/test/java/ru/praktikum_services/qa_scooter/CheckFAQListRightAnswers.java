package ru.praktikum_services.qa_scooter;

import pageobj.*;
import ru.praktikum_services.qa_scooter.constants.Url;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CheckFAQListRightAnswers {
    private final String text;
    private final int numOfLine;

    public CheckFAQListRightAnswers(String text, int numOfLine) {
        this.text = text;
        this.numOfLine = numOfLine;
    }

    @Parameterized.Parameters
    public static Object[][] getFAQRightAnswers() {
        return new Object[][] {
                { "Сутки — 400 рублей. Оплата курьеру — наличными или картой.", 0},
                { "Пока что у нас так: один заказ — один самокат. " +
                        "Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", 1},
                {"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. " +
                        "Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. " +
                        "Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", 2},
                {"Только начиная с завтрашнего дня. Но скоро станем расторопнее.", 3},
                {"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", 4},
                {"Самокат приезжает к вам с полной зарядкой. " +
                        "Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", 5},
                {"Да, пока самокат не привезли. " +
                        "Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", 6},
                {"Да, обязательно. Всем самокатов! И Москве, и Московской области.", 7},
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
    public void checkElementsOfList() {
        FAQListOnMainPage faqList = new FAQListOnMainPage(driver);
        assertEquals(text, faqList.getTextOfElementOfList(numOfLine));
    }

    @After
    public void teardown() {
        driver.quit();
    }
}

