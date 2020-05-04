package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class AccountSummaryStepDefinitions {

AccountSummaryPage accountSummaryPage= new AccountSummaryPage();

    @When("user navigates to {string} page")
    public void user_navigates_to_page(String tabName) {
        accountSummaryPage.navigateTo(tabName);
    }

    @Then("user verifies that title is {string}")
    public void user_verifies_that_title_is(String title) {
        Assert.assertEquals(Driver.getDriver(ConfigurationReader.getProperty("browser")).getTitle(),title);
    }

    @Then("user verifies that page has following account types:")
    public void user_verifies_that_page_has_following_account_types(List<String> dataTable) {
        Assert.assertEquals(dataTable,accountSummaryPage.getAccountTypes());

    }

    @Then("user verifies following credit account columns:")
    public void user_verifies_following_credit_account_columns(List<String> dataTable) {
        Assert.assertEquals(dataTable,accountSummaryPage.getcredit_column());
    }
}