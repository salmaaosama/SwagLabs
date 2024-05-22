import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InformationPage {
    //Information Page classes
    public WebElement firstname(WebDriver driver){
        By frstname = By.id("first-name");
        return driver.findElement(frstname);
    }
    public WebElement lastname(WebDriver driver){
        By lstname = By.id("last-name");
        return driver.findElement(lstname);
    }
    public WebElement postalCode(WebDriver driver){
        By postal = By.id("postal-code");
        return driver.findElement(postal);
    }
    public WebElement continueElm(WebDriver driver){
        By continuebtn = By.id("continue");
        return driver.findElement(continuebtn);
    }
    public void InformationData(WebDriver driver,String firstname,String lastname, String postal ){
        firstname(driver).sendKeys(firstname);
        lastname(driver).sendKeys(lastname);
        postalCode(driver).sendKeys(postal);
    }
}
