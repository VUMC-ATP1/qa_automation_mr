package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage {

    private WebElement element;
    private WebDriver driver;


    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    //Products add to cart buttons
    private final By addSauceLabsBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private final By addSauceLabsBoltTShirt = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private final By addSauceLabsOnesie = By.id("add-to-cart-sauce-labs-onesie");
    private final By addSauceLabsBikeLight = By.id("add-to-cart-sauce-labs-bike-light");
    private final By addSauceLabsFleeceJacket = By.id("add-to-cart-sauce-labs-fleece-jacket");
    private final By addTestAllTheTingsTShirtRed = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");

    private final By shoppingCartIcon = By.xpath("//div[@id='shopping_cart_container']");

    public void addSauceLabsBackpack() {
        element = driver.findElement(addSauceLabsBackpack);
        element.click();
    }

    public void addSauceLabsBoltTShirt() {
        element = driver.findElement(addSauceLabsBoltTShirt);
        element.click();
    }

    public void addSauceLabsOnesie() {
        element = driver.findElement(addSauceLabsOnesie);
        element.click();
    }

    public void addSauceLabsBikeLight() {
        element = driver.findElement(addSauceLabsBikeLight);
        element.click();
    }

    public void addSauceLabsFleeceJacket() {
        element = driver.findElement(addSauceLabsFleeceJacket);
        element.click();
    }

    public void addTestAllTheTingsTShirtRed() {
        element = driver.findElement(addTestAllTheTingsTShirtRed);
        element.click();
    }

    public void clickShoppingCartIcon() {
        element = driver.findElement(shoppingCartIcon);
        element.click();
    }
}
