package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class AddNewPayeeStepDefinitions {

    PayBillsPage payBillsPage= new PayBillsPage();


    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {
       payBillsPage.clickAddNewPayee();
    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String> dataTable) {
        payBillsPage.setPayeeName(dataTable.get("Payee Name"));
        payBillsPage.setPayeeAddress(dataTable.get("Payee Address"));
        payBillsPage.setnewAccount(dataTable.get("Account"));
        payBillsPage.setNewPayeeDetails(dataTable.get("Payee details"));
        payBillsPage.clickAdd();
    }

    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String msg) {
        Assert.assertEquals(msg,payBillsPage.getMsg());
    }
}
