import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
//import Pages.ScrollHelper;


public class SiteTest_SOft {
        ChromeDriver driver = new ChromeDriver();

        @BeforeTest
        public void openBrowser() {
            //Set Browser resolution
            driver.manage().window().maximize();
          //  driver.navigate().to("https://www.saucedemo.com/");

        }
        //Login Functionality:
        //Navigate to the login page.
        //Enter valid credentials and click on the login button.
        //Verify that the user is logged in successfully.

        @Test
        public void ValidLoginData() throws InterruptedException {
            driver.navigate().to("https://www.saucedemo.com/");
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();
            driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
            String expectedText = "Products";
            String actualText = driver.findElement(By.className("title")).getText();
            //Soft Assertion
            SoftAssert soft = new SoftAssert();
            soft.assertEquals(actualText,expectedText, "True");
        }
        //Invalid Login:
        //Navigate to the login page.
        //Enter invalid credentials and click on the login button.
        //Verify that an error message is displayed.
        @Test
        public void InValidLoginData() throws InterruptedException {
            driver.navigate().to("https://www.saucedemo.com/");
            driver.findElement(By.id("user-name")).sendKeys("standard");
            driver.findElement(By.id("password")).sendKeys("secret");
            driver.findElement(By.id("login-button")).click();
            driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
            String expectedText = "Products";
            String actualText = driver.findElement(By.className("title")).getText();
            Assert.assertEquals(actualText,expectedText, "True");
        }
        //Product Sorting:
        //Login with valid credentials (if not already logged in).
        //Navigate to a product listing page.
        //Select a sorting option from the dropdown.
        //Verify that the products are sorted correctly.
        @Test
        public void ProductSorting(){
            driver.navigate().to("https://www.saucedemo.com/");
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();
            driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
            driver.findElement(By.className("product_sort_container")).click();
            driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[3]")).click();
            String expected = "Price (low to high)";
            String actual = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[3]")).getText();
            System.out.println("actualResult = " + actual);
            Assert.assertEquals(actual,expected, "True");
        }

        //Add to Cart:
        //Login with valid credentials (if not already logged in).
        //Navigate to a product page.
        //Click on the "Add to Cart" button.
        //Verify that the product is added to the cart.
        @Test
        public void addToCart(){
            driver.navigate().to("https://www.saucedemo.com/");
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();
            driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();

           // driver.findElement(By.className("inventory_item_img")).click();
           // driver.findElement(By.id("add-to-cart")).click();
            driver.findElement(By.className("shopping_cart_link")).click();
            driver.findElement(By.id("checkout")).click();
            driver.findElement(By.id("first-name")).sendKeys("Salma");
            driver.findElement(By.id("last-name")).sendKeys("Osama");
            driver.findElement(By.id("postal-code")).sendKeys("5555");
            driver.findElement(By.id("continue")).click();
            driver.findElement(By.id("finish")).click();
            String expectedResult ="Thank you for your order!";
            String actualResult = driver.findElement(By.className("complete-header")).getText();
            System.out.println("actualResult = " + actualResult);
            Assert.assertTrue(actualResult.contains(expectedResult),"Error message = your text is wrong" );
        }

        //Remove from Cart:
        //Login with valid credentials (if not already logged in).
        //Navigate to the cart page.
        //Click on the "Remove" button for a product.
        //Verify that the product is removed from the cart.
        @Test
        public void removeFromCArt (){
            driver.navigate().to("https://www.saucedemo.com/");
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();
            driver.findElement(By.className("inventory_item_img")).click();
            driver.findElement(By.id("add-to-cart")).click();
            driver.findElement(By.className("shopping_cart_link")).click();
            driver.findElement(By.name("remove-sauce-labs-backpack")).click();

        }

        @AfterTest
        public void CloseDriver() throws InterruptedException  {
            Thread.sleep(3000);
            driver.quit();
        }
}
