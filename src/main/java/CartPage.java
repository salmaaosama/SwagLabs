import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    //Cart page classes
    public WebElement removeELm(WebDriver driver){
        By remove = By.id("remove-sauce-labs-backpack");
        return driver.findElement(remove);
    }
    public WebElement checkElm(WebDriver driver){
        By checkBtn = By.id("checkout");
        return driver.findElement(checkBtn);
    }

}
