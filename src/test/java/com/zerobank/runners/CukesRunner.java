package com.zerobank.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/zerobank/stepdefinitions",
         features = "src/test/resources/features/Login.feature",
         dryRun = false,
         strict = false,
         tags = "",
         plugin= {
         "html:target/normal-report",
         "json:target/cucumber1.json",
         }
)
public class CukesRunner {

}
