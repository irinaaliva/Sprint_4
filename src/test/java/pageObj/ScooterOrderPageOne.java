package pageObj;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ScooterOrderPageOne {
    private WebDriver driver;

    private By nameField = By.xpath(".//input[@placeholder='* Имя']");
    private By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    private By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private By metroStationField = By.xpath(".//input[@placeholder='* Станция метро']");
    private By phoneNumberField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    private By orderButtonNext = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее']");

    public ScooterOrderPageOne(WebDriver driver){
        this.driver = driver;
    }

    private void selectMetroStation(int value){
        driver.findElement(metroStationField).click();
        By elementOfMetroList = By.xpath(".//button[@value='" + value + "']");
        driver.findElement(elementOfMetroList).click();
    }

    public void setOrderPageOne(String name, String surname, String address, int metroValue, String phone) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(surnameField).sendKeys(surname);
        driver.findElement(addressField).sendKeys(address);
        selectMetroStation(metroValue);
        driver.findElement(phoneNumberField).sendKeys(phone);
    }

    public void clickOrderButtonNext(){
        //((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(orderButtonNext));
        driver.findElement(orderButtonNext).click();
    }
}

