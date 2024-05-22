import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SiteTest {
    ChromeDriver driver = new ChromeDriver();
    LoginPage login;
    HomePage home;
    CartPage cart;
    InformationPage info;
    CompletePage complete;
    OverviewPage over;

        @BeforeTest
        public void openBrowser() throws InterruptedException {
            //Set Browser resolution
            driver.manage().window().maximize();
            //  driver.navigate().to("https://www.saucedemo.com/");
            login = new LoginPage();
            home = new HomePage();
            cart = new CartPage();
            info = new InformationPage();
            complete = new CompletePage();
            over = new OverviewPage();
            Thread.sleep(2000);
        }

        //Login Functionality:
        //Navigate to the login page.
        //Enter valid credentials and click on the login button.
        //Verify that the user is logged in successfully.
        @Test
        public void ValidLoginData() throws InterruptedException {
            driver.navigate().to("https://www.saucedemo.com/");
            //usernameElm ().sendKeys("standard_user");
            login.LoginSteps(driver,"standard_user","secret_sauce" );
            home.Homepage(driver).getText();
            String expectedText = "Products";
            String actualText = home.Homepage(driver).getText();
            Assert.assertEquals(actualText, expectedText, "True");
            Thread.sleep(2000);
        }

        //Invalid Login:
        //Navigate to the login page.
        //Enter invalid credentials and click on the login button.
        //Verify that an error message is displayed.
        @Test
        public void InValidLoginData() throws InterruptedException {
            driver.navigate().to("https://www.saucedemo.com/");
            login.LoginSteps(driver,"standard","secret" );

            String expectedResult = "Epic sadface: Username and password do not match any user in this service";
            String actualResult = login.erorrMessage(driver).getText();
            System.out.println("actualResult = " + actualResult);
            Assert.assertEquals(actualResult, expectedResult);
            Thread.sleep(2000);
        }


        //Product Sorting:
        //Login with valid credentials (if not already logged in).
        //Navigate to a product listing page.
        //Select a sorting option from the dropdown.
        //Verify that the products are sorted correctly.
        @Test
        public void ProductSorting() throws InterruptedException {
            driver.navigate().to("https://www.saucedemo.com/");
            login.LoginSteps(driver,"standard_user","secret_sauce" );
            home.sortList(driver).getText();
            home.sortList(driver).click();
            home.selectedSorting(driver).click();
            String expected = "Price (low to high)";
            String actual = home.selectedSorting(driver).getText();
            System.out.println("actualResult = " + actual);
            Assert.assertEquals(actual, expected, "True");
            Thread.sleep(2000);
        }

        //Add to Cart:
        //Login with valid credentials (if not already logged in).
        //Navigate to a product page.
        //Click on the "Add to Cart" button.
        //Verify that the product is added to the cart.
        @Test
        public void addToCart(){
            driver.navigate().to("https://www.saucedemo.com/");
            login.LoginSteps(driver,"standard_user","secret_sauce" );
            home.AddElmToCart(driver).click();
            home.cartIcon(driver).click();
            cart.checkElm(driver).click();
            info.InformationData(driver,"Salma", "Osama","5555");
            info.continueElm(driver).click();
            over.finishElm(driver).click();
            String expectedResult = "Thank you for your order!";
            String actualResult = complete.complete(driver).getText();
            System.out.println("actualResult = " + actualResult);
            Assert.assertTrue(actualResult.contains(expectedResult), "Error message = your text is wrong");

        }


        //Remove from Cart:
        //Login with valid credentials (if not already logged in).
        //Navigate to the cart page.
        //Click on the "Remove" button for a product.
        //Verify that the product is removed from the cart.
        @Test
        public void removeFromCArt(){
            driver.navigate().to("https://www.saucedemo.com/");
            login.LoginSteps(driver,"standard_user","secret_sauce" );
            home.AddElmToCart(driver).click();
            home.cartIcon(driver).click();
            cart.removeELm(driver).click();
        }

        @AfterTest
        public void CloseDriver() throws InterruptedException {
            Thread.sleep(3000);
            driver.quit();
        }
    }

