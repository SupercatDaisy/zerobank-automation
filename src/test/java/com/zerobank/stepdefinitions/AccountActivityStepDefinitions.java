package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class AccountActivityStepDefinitions {

    AccountActivityPage accountActivityPage = new AccountActivityPage();


    @Then("user verifies account dropdown has {string} default option")
    public void user_verifies_account_dropdown_has_default_option(String defaultOption) {
        Assert.assertEquals(defaultOption,accountActivityPage.getAccountDropDown());
    }
    @Then("user verifies account dropdown has following options :")
    public void user_verifies_account_dropdown_has_following_options(List<String> dataTable) {
      Assert.assertEquals(dataTable,accountActivityPage.getAllAccountDropDown());
    }


    @Then("user verfies Transaction table have following column names:")
    public void user_verfies_Transaction_table_have_following_column_names(List<String> dataTable) {
    Assert.assertEquals(dataTable,accountActivityPage.getTransactionColumn());


    }
}
