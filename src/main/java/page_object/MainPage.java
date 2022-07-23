package page_object;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MainPage {
    //definēsim objektus
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By firstNameField = By.id("fNameID");
    private final By clickOnMeButton = By.xpath("//button[@id='checkDataID']");
    private final By studentCheckBox = By.xpath("//input[@id='studentID' and @type='checkbox']");
    private final By checkResult = By.id("checkDataResultID");
    private final By universities = By.name("universities");

    private final By javaRadioButton = By.name("fav_language");

    private final By linkedinURL = By.linkText("LinkedIN");

    private final By textArea = By.id("aboutMeID");


    public WebElement getTextAreaElement() {
        return driver.findElement(textArea);
    }

    public WebElement getLinkedinURL() {
        return driver.findElement(linkedinURL);
    }

    public WebElement getFirstNameField() {
        return driver.findElement(firstNameField);
    }

    public void setFirstNameField(String value) {
        driver.findElement(firstNameField).sendKeys(value);
    }

    public WebElement clickOnMe() {
        return driver.findElement(clickOnMeButton);
    }

    public WebElement clickOnMeButton() {
        return driver.findElement(clickOnMeButton);
    }

    public void selectStudentCheckBox() {
        WebElement element = driver.findElement(studentCheckBox);
        element.click();

    }

   public Select getUniversities() {
        return new Select(driver.findElement(universities));
   }

   public List<WebElement> getUniversitiesAsList() {
        return getUniversities().getOptions();
   }

   public WebElement getJavaRadioButton() {
        return driver.findElement(javaRadioButton);
   }

   public WebElement getCheckResult() {
        return driver.findElement(checkResult);
   }




}
