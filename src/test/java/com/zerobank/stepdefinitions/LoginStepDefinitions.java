package com.zerobank.stepdefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {

LoginPage loginPage = new LoginPage();

    @Given("User is on landing page")
    public void user_is_on_landing_page() {
        Driver.getDriver(ConfigurationReader.getProperty("browser")).get(ConfigurationReader.getProperty("url"));
    }

    @When("User click on Signin button")
    public void user_click_on_Signin_button() {
        loginPage.clickmain();
    }

    @Given("User logs in with valid credentials")
    public void userLogsInWithValidCredentials() {
        loginPage.login();
    }

    @Then("User should be able to see {string} page displayed")
    public void userShouldBeAbleToSeePageDisplayed(String title) {
        Assert.assertTrue(loginPage.getTitle().contains(title));
    }

    @Given("User logs in with incorrect {string} and {string}")
    public void user_logs_in_with_incorrect_and(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("Error message {string} should be displayed")
    public void error_message_should_be_displayed(String string) {
        Assert.assertTrue(loginPage.getError().isDisplayed());
        Assert.assertEquals(ConfigurationReader.getProperty("msg"),loginPage.getErrorMsg());
    }



}
