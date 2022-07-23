package steps_defs;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjectsHomework.*;
import utils.WebDriverManager;


public class CucumberHomework {


    @Then("I receive {string}")
    public void iReceiveError_message() {
    }

    class Constant {
        private static final String SAUCE_URL = "https://www.saucedemo.com/";
        private static final String SAUCE_INVENTORY_URL = "https://www.saucedemo.com/inventory.html";
        private static final String SAUCE_CART_PAGE_URL = "https://www.saucedemo.com/cart.html";
        private static final String SAUCE_CHECKOUT_STEP_ONE_URL = "https://www.saucedemo.com/checkout-step-one.html";
        private static final String SAUCE_CHECKOUT_STEP_TWO_URL = "https://www.saucedemo.com/checkout-step-two.html";
        private static final String SAUCE_CHECKOUT_COMPLETE_URL = "https://www.saucedemo.com/checkout-complete.html";
        private static final String PRODUCT_NAME = "Sauce Labs Bike Light";
        private static final String FIRSTNAME = "Pete";
        private static final String LASTNAME = "Pen";
        private static final String ZIP_OR_POSTAL_CODE = "LV-1111";
    }

    WebDriver driver = WebDriverManager.getInstance();
    LoginPage loginPage = new LoginPage(driver);
    InventoryPage inventoryPage = new InventoryPage(driver);
    CartPage cartPage = new CartPage(driver);
    CheckoutPagee checkoutPage = new CheckoutPagee(driver) ;
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
    CheckoutSuccessPage checkoutSuccessPage = new CheckoutSuccessPage(driver);

    @Given("I have to navigate to SauceDemo web site")
    public void navigateToLoginPage() {
        driver.get(Constant.SAUCE_URL);
    }

    @When("I login with the {string} and {string}")
    public void login(String username, String password) {
        loginPage.authorizeUsers(username,password);
        loginPage.clickOnLoginButton();
    }

    @Then("I am successfully logged in SauceDemo")
    public void successfullyLoggedIn() {
        Assert.assertEquals(driver.getCurrentUrl(), Constant.SAUCE_INVENTORY_URL);
    }

    @Given("I am logged in SauceDemo")
    public void loggedIn() {
        Assert.assertEquals(driver.getCurrentUrl(), Constant.SAUCE_INVENTORY_URL);
    }

    @When("I add to cart one Sauce Labs Bike Light pressing Add to Cart button")
    public void addItemToCart() {
        inventoryPage.addSauceLabsBikeLight();
        inventoryPage.clickShoppingCartIcon();
    }

    @Then("I go to check the Cart page")
    public void goToCartPage() {
        inventoryPage.clickShoppingCartIcon();
    }

    @Given("I am successfully redirected to Cart page")
    public void cartPage() {
        Assert.assertEquals(driver.getCurrentUrl(), Constant.SAUCE_CART_PAGE_URL);
    }

    @Given("I check if one Sauce Labs Bike Light is added in the shopping cart")
    public void checkingIfItemIsInCart() {
        Assert.assertEquals(cartPage.getProductName().getText(), Constant.PRODUCT_NAME);
    }

    @When("I press Checkout button")
    public void clickOnCheckoutButton() {
        cartPage.clickCheckoutButton();
    }

    @Then("I am redirected to Checkout page")
    public void goToCheckoutPage() {
        Assert.assertEquals(driver.getCurrentUrl(), Constant.SAUCE_CHECKOUT_STEP_ONE_URL);
    }

    @Given("I am successfully redirected to Checkout page")
    public void checkoutPage() {

    }

    @When("I populate all field with the required information")
    public void populateAllField() {
        checkoutPage.getFirstNameField().sendKeys(Constant.FIRSTNAME);
        checkoutPage.getLastNameField().sendKeys(Constant.LASTNAME);
        checkoutPage.getZipOrPostalCodeField().sendKeys(Constant.ZIP_OR_POSTAL_CODE);
    }

    @When("Press Continue button")
    public void clickOnContinueButton() {
        checkoutPage.clickContinueButton();
    }

    @Then("I am redirected to Checkout: Overview page")
    public void goToCheckoutOverviewPage() {
        Assert.assertEquals(driver.getCurrentUrl(), Constant.SAUCE_CHECKOUT_STEP_TWO_URL);
    }

    @Given("I am successfully redirected to Checkout: Overview page")
    public void checkoutOverviewPage() {
        Assert.assertEquals(driver.getCurrentUrl(), Constant.SAUCE_CHECKOUT_STEP_TWO_URL);
    }

    @When("I press Finish button")
    public void clickFinishButton() {
        checkoutOverviewPage.clickFinishButton();
    }

    @Then("I am redirected to Checkout: Complete page")
    public void gotToCheckoutCompletePage() {
        Assert.assertEquals(driver.getCurrentUrl(), Constant.SAUCE_CHECKOUT_COMPLETE_URL);
    }

    @Given("I am successfully redirected to Checkout: Complete page")
    public void checkoutCompletePage() {
        Assert.assertEquals(checkoutSuccessPage.getThankYouHeader().getText(), "THANK YOU FOR YOUR ORDER");
    }

    @When("I press Back Home button")
    public void clickOnBackHomeButton() {
        checkoutSuccessPage.clickBackHomeButton();
    }

    @Then("I am redirected to the first page")
    public void homePage() {
        Assert.assertEquals(driver.getCurrentUrl(), Constant.SAUCE_INVENTORY_URL);
    }


    // Missing steps for second scenario
    @When("I populate all required fields {string}, {string} and {string}")
    public void populateAllFields(String firstname, String lastname, String zip_postalcode) {
        checkoutPage.populateFields(firstname,lastname,zip_postalcode);
    }

    @When("I click on Cart icon")
    public void iClickOnCartIcon() {
        inventoryPage.clickShoppingCartIcon();

    }

    @Then("I am redirected to Cart page")
    public void redirectedToCartPage() {
        Assert.assertEquals(driver.getCurrentUrl(), Constant.SAUCE_CART_PAGE_URL);
    }

    @Given("I am at Cart page")
    public void atCartPage() {
        Assert.assertEquals(driver.getCurrentUrl(), Constant.SAUCE_CART_PAGE_URL);
    }

    @Then("I receive Error message: {string}")
    public void receiveErrorMessage(String error_message ) {
        checkoutPage.receiveErrorMessage(error_message);
    }


}


