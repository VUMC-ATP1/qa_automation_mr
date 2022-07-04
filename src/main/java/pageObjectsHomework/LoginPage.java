package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebElement element;
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By clickOnLoginButton = By.id("login-button");


    public WebElement getUsernameField() {
        return driver.findElement(username);
    }

    public void setUsernameField(String value) {
        driver.findElement(username).sendKeys(value);
    }

    public WebElement getPasswordField() {
        return driver.findElement(password);
    }

    public void setPasswordField(String value) {
        driver.findElement(password).sendKeys(value);
    }

    public void clickOnLoginButton() {
        element = driver.findElement(clickOnLoginButton);
        element.click();
    }
}
