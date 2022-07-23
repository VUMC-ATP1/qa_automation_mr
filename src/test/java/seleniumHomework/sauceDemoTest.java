package seleniumHomework;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjectsHomework.*;


public class sauceDemoTest {

    ChromeDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;
    CartPage cartPage;
    CheckoutPagee checkoutPage;
    CheckoutOverviewPage checkoutOverviewPage;
    CheckoutSuccessPage checkoutSuccessPage;

    //Input values
    private final String SAUCE_URL = "https://www.saucedemo.com/";
    private final String SAUCE_INVENTORY_URL = "https://www.saucedemo.com/inventory.html";

    private final String USERNAME = "standard_user";
    private final String PASSWORD = "secret_sauce";
    private final String PRODUCT_NAME = "Sauce Labs Bike Light";
    private final String FIRSTNAME = "Pete";
    private final String LASTNAME = "Pen";
    private final String ZIP_OR_POSTAL_CODE = "LV-1111";

    private final String ERROR_MESSAGE_FIRST_NAME = "Error: First Name is required";
    private final String ERROR_MESSAGE_LAST_NAME = "Error: Last Name is required";
    private final String ERROR_MESSAGE_ZIP_POSTAL_CODE = "Error: Postal Code is required";


    @BeforeMethod(alwaysRun = true)
    public void openTest() {
        System.out.println("Initializing saucedemo.com webpage test");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPagee(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutSuccessPage = new CheckoutSuccessPage(driver);
    }

    /*
    Scenario 1
    1. Navigate to https://www.saucedemo.com/
    2. Log in with the correct user name/password
    3. Verify that the user is logged in
    4. Place 1 product in the Basket
    5. Go to Cart
    6. Check how this product is in the basket
    7. Go to Checkout
    8. Enter name/postal code
    9. Go to Checkout overview page, check details
    10. Go to the finish page and check if everything was successful
    11. Go back to the first page with the 'Back Home' button
    */
    @Test
    public void firstTestScenario() {
        driver.get(SAUCE_URL);
        //log in
        loginPage.getUsernameField().sendKeys(USERNAME);
        loginPage.getPasswordField().sendKeys(PASSWORD);
        loginPage.clickOnLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(), SAUCE_INVENTORY_URL);
        //Adding product to cart
        inventoryPage.addSauceLabsBikeLight();
        inventoryPage.clickShoppingCartIcon();
        Assert.assertEquals(cartPage.getProductName().getText(), PRODUCT_NAME);
        cartPage.clickCheckoutButton();
        //Checkout section
        checkoutPage.getFirstNameField().sendKeys(FIRSTNAME);
        checkoutPage.getLastNameField().sendKeys(LASTNAME);
        checkoutPage.getZipOrPostalCodeField().sendKeys(ZIP_OR_POSTAL_CODE);
        checkoutPage.clickContinueButton();
        Assert.assertEquals(checkoutOverviewPage.getItemName().getText(), PRODUCT_NAME);
        checkoutOverviewPage.clickFinishButton();
        //Checking whether the user has succeeded
        Assert.assertEquals(checkoutSuccessPage.getThankYouHeader().getText(), "THANK YOU FOR YOUR ORDER");
        checkoutSuccessPage.clickBackHomeButton();
        Assert.assertEquals(driver.getCurrentUrl(), SAUCE_INVENTORY_URL);
    }

    /*
    Scenario 2
    1. Navigate to https://www.saucedemo.com/
    2. Log in with the correct username/password
    3. Go to cart
    4. Go to Checkout
    5. Check that FirstName/LastName/Zip code is required
    6. Check that the form displays the correct error message for each field not entered
     */

    @Test
    public void secondTestScenario() {
        driver.get(SAUCE_URL);
        //log in
        loginPage.getUsernameField().sendKeys(USERNAME);
        loginPage.getPasswordField().sendKeys(PASSWORD);
        loginPage.clickOnLoginButton();
        //head to the shopping cart
        inventoryPage.clickShoppingCartIcon();
        //head to the checkout
        cartPage.clickCheckoutButton();
        //check if displays the correct error message for each field not entered
        checkoutPage.clickContinueButton();
        Assert.assertEquals(checkoutPage.getErrorMessage().getText(), ERROR_MESSAGE_FIRST_NAME);
        checkoutPage.getFirstNameField().sendKeys(FIRSTNAME);
        checkoutPage.clickContinueButton();
        Assert.assertEquals(checkoutPage.getErrorMessage().getText(), ERROR_MESSAGE_LAST_NAME);
        checkoutPage.getLastNameField().sendKeys(LASTNAME);
        checkoutPage.clickContinueButton();
        Assert.assertEquals(checkoutPage.getErrorMessage().getText(), ERROR_MESSAGE_ZIP_POSTAL_CODE);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownTest() {
        System.out.println("Closing saucedemo.com webpage test");
        driver.close();
    }

}
