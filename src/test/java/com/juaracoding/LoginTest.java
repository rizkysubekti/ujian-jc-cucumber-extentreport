package com.juaracoding;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.juaracoding.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private ExtentTest extentTest;

    public LoginTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
        extentTest.log(LogStatus.PASS,"I am on the login page");
    }

    @When("I enter valid username and password")
    public void i_enter_valid_username_and_password() {
        delay(1);
        loginPage.enterUsername("standard_user");
        delay(1);
        loginPage.enterPassword("secret_sauce");
        extentTest.log(LogStatus.PASS,"I enter valid username and password");
    }

    @When("I enter invalid username and valid password")
    public void i_enter_invalid_username_and_valid_password() {
        delay(1);
        loginPage.enterUsername("invalid_user");
        delay(1);
        loginPage.enterPassword("secret_sauce");
        extentTest.log(LogStatus.PASS,"I enter invalid username and valid password");
    }

    @When("I enter valid username and invalid password")
    public void i_enter_valid_username_and_invalid_password() {
        delay(1);
        loginPage.enterUsername("standard_user");
        delay(1);
        loginPage.enterPassword("invalid_password");
        extentTest.log(LogStatus.PASS,"I enter valid username and invalid password");
    }

    @When("I enter invalid username and password")
    public void i_enter_invalid_username_and_password() {
        delay(1);
        loginPage.enterUsername("invalid_user");
        delay(1);
        loginPage.enterPassword("invalid_password");
        extentTest.log(LogStatus.PASS,"I enter invalid username and password");
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        loginPage.clickLoginButton();
        extentTest.log(LogStatus.PASS,"I click the login button");
    }

    @Then("I should be redirected to the main page")
    public void i_should_be_redirected_to_the_main_page() {
        delay(1);
        String actualTitle = loginPage.getPageTitle();
        Assert.assertEquals(actualTitle, "Swag Labs");
        extentTest.log(LogStatus.PASS,"I should be redirected to the main page");
    }

    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        delay(1);
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(loginPage.getErrorMessageText(), expectedErrorMessage);
        extentTest.log(LogStatus.PASS,"I should see an error message");
    }

    public static void delay(long detik) {
        try {
            Thread.sleep(detik * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}