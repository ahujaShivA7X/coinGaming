package StepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


@RunWith(Cucumber.class)
public class Locked_User {

    public WebDriver driver;

    public void waitAndClick(String object) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath(object))).click();
    }

    public void waitAndType(String object, String text) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(object))).sendKeys(text);
    }

    public void Init() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/");
    }

    @Given("^User logs in using locked out user credentials$")
    public void user_logs_in_using_locked_out_user_credentials() throws Throwable {
        Init();
        waitAndType("//input[@id='user-name']", "locked_out_user");
        waitAndType("//input[@id='password']", "secret_sauce");
        waitAndClick("//input[@id='login-button']");
    }

    @Then("^The user should get an error$")
    public void the_user_should_get_an_error() throws Throwable {
        String confimation = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertEquals("Epic sadface: Sorry, this user has been locked out.", confimation);
        driver.quit();
    }
}
