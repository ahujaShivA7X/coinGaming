package StepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

@RunWith(Cucumber.class)
public class Logout {

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

    
    @Given("^User logs in$")
    public void user_logs_in() throws Throwable {
        Init();
        waitAndType("//input[@id='user-name']", "standard_user");
        waitAndType("//input[@id='password']", "secret_sauce");
        waitAndClick("//input[@id='login-button']");
    }
    
    @And("^Logs out$")
    public void logs_out() throws Throwable {
        waitAndClick("//button[normalize-space()='Open Menu']");
        waitAndClick("//a[normalize-space()='Logout']");
    }
    
    @Then("^the user should be on login page$")
    public void the_user_should_be_on_login_page() throws Throwable {
        String loginPage = driver.getCurrentUrl();
        Assert.assertEquals("https://www.saucedemo.com/", loginPage);
        driver.close();
    }
}
