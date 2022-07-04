package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

    private WebElement element;
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By checkoutButton = By.id("checkout");
    private final By continueShoppingButton = By.id("continue-shopping");
    private final By removeButtonForBikeLight = By.id("remove-sauce-labs-bike-light");
    private final By productName = By.id("item_0_title_link");

    public void clickCheckoutButton() {
        element = driver.findElement(checkoutButton);
        element.click();
    }

    public void clickContinueShoppingButton() {
        element = driver.findElement(continueShoppingButton);
        element.click();
    }

    public void clickRemoveButtonForBikeLight() {
        element = driver.findElement(removeButtonForBikeLight);
        element.click();
    }

    public WebElement getProductName() {
        return driver.findElement(productName);
    }
}
