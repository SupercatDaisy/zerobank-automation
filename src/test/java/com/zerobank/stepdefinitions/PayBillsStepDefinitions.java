package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.Wait;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class PayBillsStepDefinitions {

PayBillsPage payBillsPage = new PayBillsPage();

    @When("user enters following Data:")
    public void user_enters_following_Data(List<Map<String,String>> dataTable) {
        payBillsPage.setPayee(dataTable.get(0).get("Payee"));
        payBillsPage.setAccount(dataTable.get(0).get("Account"));
        payBillsPage.setAmount(dataTable.get(0).get("Amount"));
        payBillsPage.setDate(dataTable.get(0).get("Date"));
        payBillsPage.setDescription(dataTable.get(0).get("Description"));
    }

    @When("user click on Pay button")
    public void user_click_on_Pay_button() {
        payBillsPage.clickPaybtn();
    }

    @Then("user verifies {string} message displayed")
    public void user_verifies_message_displayed(String msg) {
        Assert.assertEquals(msg,payBillsPage.getMsg());
    }


    @When("user enters following missing Data:")
    public void user_enters_following_missing_Data(List<Map<String,String>> dataTable) {
        payBillsPage.setPayee(dataTable.get(0).get("Payee"));
        payBillsPage.setAccount(dataTable.get(0).get("Account"));
        payBillsPage.setDescription(dataTable.get(0).get("Description"));
    }

    @Then("user verifies {string} alert displayed")
    public void user_verifies_alert_displayed(String alertMsg) {
         Assert.assertEquals(alertMsg,payBillsPage.getAmountAlert());
         Assert.assertEquals(alertMsg,payBillsPage.getDateAlert());
    }

    @Then("user should verify that Amount and Date fields are incorrect.")
    public void user_should_verify_that_Amount_and_Date_fields_are_incorrect() {
        Assert.assertTrue(payBillsPage.getAmount().matches("[a-zA-Z0-9 ]*"));
        Assert.assertTrue(payBillsPage.getDate().matches("^[a-zA-Z]*$"));

    }

}
