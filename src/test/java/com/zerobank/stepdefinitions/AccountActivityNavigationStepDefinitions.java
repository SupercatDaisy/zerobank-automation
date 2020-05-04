package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AccountActivityNavigationStepDefinitions {


    AccountSummaryPage accountSummaryPage= new AccountSummaryPage();
    AccountActivityPage accountActivityPage = new AccountActivityPage();

    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String accountType) {
        accountSummaryPage.clickAccounts(accountType);
    }
    @Then("the {string} page should be displayed")
    public void the_page_should_be_displayed(String module) {
        Assert.assertTrue(accountSummaryPage.getGlobalTitle().contains(module));
    }
    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String accountType) {
        Assert.assertEquals(accountActivityPage.getAccountDropDown(), accountType);
    }
}
