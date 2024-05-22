import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CompletePage {
    //Checkout: Complete page classes
    public WebElement complete(WebDriver driver){
        By compProcess = By.className("complete-header");
        return driver.findElement(compProcess);
    }
}
