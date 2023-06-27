package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";

    //Running @Before Annotation before test
    @Before
    public void setUp() {
        OpenBrowser(baseUrl); //Open Browser Setup
    }


    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        driver.findElement(By.xpath("//li[@class='header__nav-item" +
                " header__nav-sign-in']")).click();
        //expected text
        String expectedText = "Welcome Back!";
        String actualText = driver.findElement(By.xpath("//h2[@class='" +
                "page__heading']")).getText();
        Assert.assertEquals(expectedText, actualText);

    }

    @Test
    public void verifyTheErrorMessage() throws InterruptedException {
        driver.findElement(By.xpath("//li[@class='header__nav-item" +
                " header__nav-sign-in']")).click();
        //Entering Incorrect Username with sendKey method
        driver.findElement(By.id("user[email]")).sendKeys("saragama");

        //Entering Incorrect Password
        driver.findElement(By.id("user[password]")).sendKeys("sara");
        //Clicking Sign in button
        driver.findElement(By.xpath("//button[@class='button button-primary g-recaptcha']")).click();
        //Expected Text verification
        String expectedText = "Invalid email or password.";
        //Actual Text Verification
        String actualText = driver.findElement(By.xpath("//div[@id='notice']")).getText();
        Assert.assertEquals(expectedText, actualText);

        Thread.sleep(5000);

    }

    @After
    public void tearDown() {


    }
}
