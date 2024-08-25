package page_obj;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ScooterOrderPageTwo {
    private WebDriver driver;
    private By dataField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private By RentField = By.xpath(".//div[text()='* Срок аренды']");
    private By orderButtonMakeOrder = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
    private By orderButtonYes = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    private By orderDone = By.xpath(".//diu[text()='Заказ оформлен']");

    public ScooterOrderPageTwo(WebDriver driver){
        this.driver = driver;
    }

    private void selectData(int day){
        driver.findElement(dataField).click();
        By elementOfData = By.xpath(".//div[@role='button' and text()='" + day + "']");
        driver.findElement(elementOfData).click();
    }

    private void selectRent(int rent_quantity){
        driver.findElement(RentField).click();
        String quantity_str = "сутки";
        if (rent_quantity == 1) quantity_str = "сутки";
        else if (rent_quantity == 2) quantity_str = "двое суток";
        else if (rent_quantity == 3) quantity_str = "трое суток";
        else if (rent_quantity == 4) quantity_str = "четверо суток";
        else if (rent_quantity == 5) quantity_str = "пятеро суток";
        else if (rent_quantity == 6) quantity_str = "шестеро суток";
        else if (rent_quantity == 7) quantity_str = "семеро суток";
        By elementOfListRent = By.xpath(".//div[text()='" + quantity_str + "']");
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

    public String getTextOrderDone(){
        return driver.findElement(orderDone).getText();
    }

    public void setOrderPageTwo(int day, int rent_quantity, String color) {
        selectData(day);
        selectRent(rent_quantity);
        selectColor(color);
    }
}
