package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.Wait;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FindTransactionStepDefinitions {

AccountActivityPage accountActivityPage= new AccountActivityPage();

    @When("user clicks on {string} tab")
    public void user_clicks_on_tab(String string) {
       accountActivityPage.clickFindTransaction();
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String start, String end) {
        accountActivityPage.setFromDate(start);
        accountActivityPage.setToDate(end);
    }

    @When("clicks search")
    public void clicks_search() {
       accountActivityPage.clickfindBtn();
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String start, String end) {
       Assert.assertTrue(accountActivityPage.dateInterval(start,end));

    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        Assert.assertTrue(accountActivityPage.isSorted());

    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String date) {
        Assert.assertFalse(accountActivityPage.transDate(date));
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String string) {
     accountActivityPage.setDescription(string);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String search) {
        Assert.assertTrue(accountActivityPage.checkDescription(search));
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String search) {
        Assert.assertFalse(accountActivityPage.checkDescription(search));
    }

    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {
        Assert.assertTrue(accountActivityPage.checkresultDeposit());
    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {
        Assert.assertTrue(accountActivityPage.checkresultWithdrawal());
    }

    @When("user selects type {string}")
    public void user_selects_type(String type) {
        accountActivityPage.selectType(type);
    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
        Assert.assertTrue(accountActivityPage.checkresultWithdrawal());
    }

    @Then("results table should show at least one result under Withdraw")
    public void results_table_should_show_at_least_one_result_under_Withdraw() {
        Assert.assertTrue(accountActivityPage.checkresultWithdrawal());

    }

}
