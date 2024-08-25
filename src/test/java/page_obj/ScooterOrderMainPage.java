package page_obj;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ScooterOrderMainPage {
    private WebDriver driver;

    private By orderButtonOnTop = By.className("Button_Button__ra12g");
    private By orderButtonOnBottom = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
    private By cookieButton = By.xpath(".//button[text()='да все привыкли']");

    public ScooterOrderMainPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickOrderButtonOnTop(){
        driver.findElement(orderButtonOnTop).click();
    }

    public void clickCookieButton(){
        driver.findElement(cookieButton).click();
    }

    public void clickOrderButtonOnBottom(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(orderButtonOnBottom));
        driver.findElement(orderButtonOnBottom).click();
    }
}
