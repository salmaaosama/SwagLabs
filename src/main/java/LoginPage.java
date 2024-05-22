import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

//    public LoginPage(WebDriver driver){
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }
    //@FindBy(id = "user-name");
//    WebElement usernamePF;

    public WebElement usernameElm(WebDriver driver) {
        By username = By.id("user-name");
        return driver.findElement(username);
    }

    public WebElement passwordElm(WebDriver driver) {
        By password = By.id("password");
        return driver.findElement(password);
    }

    public WebElement loginElm(WebDriver driver) {
        By logBtn = By.id("login-button");
        return driver.findElement(logBtn);
    }

    public WebElement erorrMessage(WebDriver driver){
        By errorMSG = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");
        return driver.findElement(errorMSG);
    }

    public void LoginSteps (WebDriver driver,String username, String password){
        usernameElm(driver).sendKeys(username);
        passwordElm(driver).sendKeys(password);
        loginElm(driver).click();
    }
}
