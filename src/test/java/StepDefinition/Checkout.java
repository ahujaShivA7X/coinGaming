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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

@RunWith(Cucumber.class)
public class Checkout {

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

    @Test
    @Given("^Go to the website$")
    public void go_to_the_website() throws Throwable {
        Init();
    }

    @And("^enter username and password$")
    public void enter_username_and_password() throws Throwable {
        waitAndType("//input[@id='user-name']", "standard_user");
        waitAndType("//input[@id='password']", "secret_sauce");
    }

    @Then("^Click on the Sign In button$")
    public void click_on_the_sign_in_button() throws Throwable {
        waitAndClick("//input[@id='login-button']");
    }


    @And("^User is on the home page$")
    public void user_is_on_the_home_page() throws Throwable {
        String homePage = driver.getCurrentUrl();
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", homePage);
    }

    @And("^add an item to the cart$")
    public void add_an_item_to_the_cart() throws Throwable {
        waitAndClick("//div[@class='inventory_list']//div[1]//div[3]//button[1]");
    }

    @And("^Go to the cart$")
    public void go_to_the_cart() throws Throwable {
        waitAndClick("//*[name()='path' and contains(@fill,'currentCol')]");
    }

    @And("^click on Checkout$")
    public void click_on_checkout() throws Throwable {
        waitAndClick("//a[normalize-space()='CHECKOUT']");
    }

    @And("^enter firstname, lastname and Zip and click continue$")
    public void enter_firstname_lastname_and_zip_and_click_continue() throws Throwable {
        waitAndType("//input[@id='first-name']", "secret_sauce");
        waitAndType("//input[@id='last-name']", "secret_sauce");
        waitAndType("//input[@id='postal-code']", "12345");
        waitAndClick("//input[@value='CONTINUE']");
    }

    @Then("^click on Finish$")
    public void click_on_finish() throws Throwable {
        waitAndClick("//a[normalize-space()='FINISH']");
        Thread.sleep(2000);
        String confimation = driver.findElement(By.xpath("//h2[normalize-space()='THANK YOU FOR YOUR ORDER']")).getText();
        Assert.assertEquals("THANK YOU FOR YOUR ORDER", confimation);
        driver.quit();
    }


}

