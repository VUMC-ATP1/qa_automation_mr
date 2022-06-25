package mavenTestNGHomework;

import homework.CalculatorForHomework;
import org.testng.Assert;
import org.testng.annotations.*;



/*
TASK 1
-List the test methods for each Calculator method. Use Assert to check the values.
-Before each test, display on the screen that the test has started.
This information is output by a special method that has the annotation @BeforeMethod
-Use other TestNG annotations to, for example, create a calculator object only once in the whole class.
 */

public class CalculatorTest {

    CalculatorForHomework calculator;

    @BeforeClass
    public void beforeCalculatorTestH() {
        System.out.println("Calculator testing begins");
    }

    @BeforeMethod
    public void beforeAddMethod() {
        System.out.println("The test for adding functions starts.");
    }

    @Test
    public void testAddMethod() {
        calculator = new CalculatorForHomework();

        Assert.assertEquals(calculator.add(5, 4), 9);
    }

    @AfterMethod
    public void afterAddMethod() {
        System.out.println("The test for adding functions ended.");
    }

    @BeforeMethod
    public void beforeSubstractMethod() {
        System.out.println("The test for substract functions starts.");
    }

    @Test
    public void testSubstractMethod() {
        calculator = new CalculatorForHomework();
        Assert.assertEquals(calculator.substract(5, 3), 2);
    }

    @AfterMethod
    public void afterSubstractMethod() {
        System.out.println("The test for substract functions ended.");
    }

    @BeforeMethod
    public void beforeMultiplyMethod() {
        System.out.println("The test for multiply functions starts.");
    }

    @Test
    public void testMultiplyMethod() {
        calculator = new CalculatorForHomework();
        Assert.assertEquals(calculator.multiply(20, 2), 40);
    }

    @AfterMethod
    public void afterMultipyMethod() {
        System.out.println("The test for multiply functions ended.");
    }

    @BeforeMethod
    public void beforeDivideMethod() {
        System.out.println("The test for divide functions starts.");
    }

    @Test
    public void testDivideMethod() {
        calculator = new CalculatorForHomework();
        Assert.assertEquals(calculator.divide(6, 2), 3.0);
    }

    @AfterMethod
    public void afterDivideMethod() {
        System.out.println("The test for divide functions ended.");
    }

    @AfterClass
    public void afterCalculatorTestH() {
        System.out.println("Calculator testing ended.");
    }
}
