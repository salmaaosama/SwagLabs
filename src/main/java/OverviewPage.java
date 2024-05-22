import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OverviewPage {
    // Overview Page classes
    public WebElement finishElm(WebDriver driver){
        By finishbtn = By.id("finish");
        return driver.findElement(finishbtn);
    }
}
