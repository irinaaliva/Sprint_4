package page_obj;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;

public class FAQListOnMainPage {
    private final WebDriver driver;

    public FAQListOnMainPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickButtonElementOfList(int numberOfButton){
        By buttonElementOfList = By.xpath(".//div[(@class='accordion__button') and (@id='accordion__heading-" + numberOfButton + "')]");
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(buttonElementOfList));
        driver.findElement(buttonElementOfList).click();
    }

    public String getTextOfElementOfList(int numberOfButton){
        clickButtonElementOfList(numberOfButton);
        By ElementOfList = By.xpath(".//div[(@class='accordion__panel') and (@id='accordion__panel-" + numberOfButton + "') and not(@hidden)]");
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(ElementOfList));
        return driver.findElement(ElementOfList).getText();
    }

}


