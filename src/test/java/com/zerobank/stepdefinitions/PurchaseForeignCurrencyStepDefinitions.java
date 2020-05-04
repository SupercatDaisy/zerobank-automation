package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class PurchaseForeignCurrencyStepDefinitions {

    PayBillsPage payBillsPage= new PayBillsPage();

    @Then("user select {string} tab")
    public void user_select_tab(String string) {
     payBillsPage.clickPurchaseForeign();
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> dataTable) {
        Assert.assertTrue(payBillsPage.CheckList(dataTable));
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        payBillsPage.clickPurchase();
    }

   @Then("error message {string} should be displayed")
    public void error_message_should_be_displayed(String msg) {
       Assert.assertEquals(msg,payBillsPage.getAlertMsg());
    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        payBillsPage.clickPurchase();
    }
}
