package mavenTestNGHomework;


import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class BrowserTestHomework {

      /*
    TASK-2
    1. Write 2 tests that will open a Website of your choice, read its title and compare it with the title you specify.
      Use Assert to check the values.
    2. It is recommended to use annotated methods in the test that will create a new ChromeDriver before each test
    and close the closed ChromeDriver after each test.
     */

    ChromeDriver driver;

    private final String SS_COM_URL = "https://www.ss.com";

    @BeforeMethod(alwaysRun = true)
    public void openBrowserTest() {
        System.out.println("Initializing ChromeDriver webpage test");
        driver = new ChromeDriver();
        driver.get(SS_COM_URL);
    }

    @Test
    public void firstChromeDriverTest() {
        Assert.assertEquals(driver.getTitle(), "Sludinājumi - SS.COM");
    }

    @Test
    public void secondChromeDriverTest() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.ss.com/");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownTest() {
        System.out.println("Closing ChromeDriver for webpage test");
        driver.close();
    }
}
