package com.zerobank.stepdefinitions;

import com.zerobank.pages.OnlineStatementsPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import com.zerobank.utilities.Wait;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StatementsAndDocumentsStepDefinitions {

    OnlineStatementsPage onlineStatementsPage=new OnlineStatementsPage();


    @When("the user selects the Recent Statements Year {int}")
    public void the_user_selects_the_Recent_Statements_Year(Integer year) {
        onlineStatementsPage.selectYears(year);
    }

    @Then("{int} statements should be displayed for that year")
    public void statements_should_be_displayed_for_that_year(Integer numberOf) {
        Assert.assertEquals(numberOf,onlineStatementsPage.getNumberStatements());
    }

    @When("the user clicks on statement {string}")
    public void the_user_clicks_on_statement(String statement) {
        onlineStatementsPage.selectStatement(statement);
        Wait.wait(10);

    }

    @Then("the downloaded file name should contain {string}")
    public void the_downloaded_file_name_should_contain(String name) {
        Assert.assertTrue(onlineStatementsPage.checkFile(name));
    }

   /* @Then("the file type should be pdf")
    public void the_file_type_should_be_pdf() {

    }*/

    @Given("user is on landing page")
    public void userIsOnLandingPage() {
        Driver.getDriver("chromeDownload").get(ConfigurationReader.getProperty("url"));
    }

    @And("the file {string} type should be pdf")
    public void theFileTypeShouldBePdf(String fileName) {
        Assert.assertTrue(onlineStatementsPage.checkExtension(fileName));
    }
}
