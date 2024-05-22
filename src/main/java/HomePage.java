import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    //homepage classes
    public WebElement sortList(WebDriver driver) {
        By sortBtn = By.className("product_sort_container");
        return driver.findElement(sortBtn);
    }
    public WebElement selectedSorting(WebDriver driver) {
        By selectedItem = By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[3]");
        return driver.findElement(selectedItem);
    }
    public WebElement Homepage(WebDriver driver){
        By validLogin = By.className("title");
        return driver.findElement(validLogin);
    }

    public WebElement AddElmToCart (WebDriver driver){
        By addedElm = By.name("add-to-cart-sauce-labs-backpack");
        return driver.findElement(addedElm);
    }
    public WebElement cartIcon(WebDriver driver){
        By cartBtn = By.className("shopping_cart_link");
        return driver.findElement(cartBtn);
    }
}
