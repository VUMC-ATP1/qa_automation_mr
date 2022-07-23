package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WebDriverManager;

public class LoginPage {

    private WebElement element;

    //private WebDriver driver;
    WebDriver driver = WebDriverManager.getInstance();


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By user_name = By.id("user-name");
    private final By passwordd = By.id("password");
    private final By clickOnLoginButton = By.id("login-button");


    // Changes for Cucumber homework Cucumber test
    public void authorizeUsers(String username, String password) {
        driver.findElement(user_name).sendKeys(username);
        driver.findElement(passwordd).sendKeys(password);
    }
    // End of changes for Cucumber homework
    public WebElement getUsernameField() {
        return driver.findElement(user_name);
    }

    public void setUsernameField(String value) {
        driver.findElement(user_name).sendKeys(value);
    }

    public WebElement getPasswordField() {
        return driver.findElement(passwordd);
    }

    public void setPasswordField(String value) {
        driver.findElement(passwordd).sendKeys(value);
    }

    public void clickOnLoginButton() {
        element = driver.findElement(clickOnLoginButton);
        element.click();
    }
}
