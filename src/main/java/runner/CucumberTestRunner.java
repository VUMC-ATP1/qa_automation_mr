package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterMethod;
import utils.WebDriverManager;


    @CucumberOptions(features = "src/test/resources/features/homework.feature", glue = {"steps_defs"}, plugin = {"pretty", "html:target/cucumber-reports/cucumberHomework-report.html"}, publish = true)
    public class CucumberTestRunner extends AbstractTestNGCucumberTests {

        @AfterMethod(alwaysRun = true)
        public void after() {
            WebDriverManager.closeBrowser();
        }
    }

