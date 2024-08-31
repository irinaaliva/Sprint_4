package pageobj;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ScooterOrderPageTwo {
    private WebDriver driver;
    private By dataField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private By RentField = By.xpath(".//div[text()='* Срок аренды']");
    private By orderButtonMakeOrder = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
    private By orderButtonYes = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    private By checkOrderStatus = By.xpath(".//button[text()='Посмотреть статус']");

    public ScooterOrderPageTwo(WebDriver driver){
        this.driver = driver;
    }

    private void selectData(int day){
        driver.findElement(dataField).click();
        By elementOfData = By.xpath(".//div[@role='button' and text()='" + day + "']");
        driver.findElement(elementOfData).click();
    }

    private void selectRent(int rentQuantity){
        driver.findElement(RentField).click();
        String quantityStr = "сутки";
        if (rentQuantity == 1) quantityStr = "сутки";
        else if (rentQuantity == 2) quantityStr = "двое суток";
        else if (rentQuantity == 3) quantityStr = "трое суток";
        else if (rentQuantity == 4) quantityStr = "четверо суток";
        else if (rentQuantity == 5) quantityStr = "пятеро суток";
        else if (rentQuantity == 6) quantityStr = "шестеро суток";
        else if (rentQuantity == 7) quantityStr = "семеро суток";
        By elementOfListRent = By.xpath(".//div[text()='" + quantityStr + "']");
        driver.findElement(elementOfListRent).click();
    }

    private void selectColor(String color){
        By elementOfColor = By.xpath(".//input[@class='Checkbox_Input__14A2w' and @id='" + color + "']");
        driver.findElement(elementOfColor).click();
    }

    public void clickButtonMakeOrder(){
        driver.findElement(orderButtonMakeOrder).click();
    }

    public void clickButtonOrderYes(){
        driver.findElement(orderButtonYes).click();
    }

    public String getTextCheckStatus(){
        return driver.findElement(checkOrderStatus).getText();
    }

    public void setOrderPageTwo(int day, int rent_quantity, String color) {
        selectData(day);
        selectRent(rent_quantity);
        selectColor(color);
    }
}
