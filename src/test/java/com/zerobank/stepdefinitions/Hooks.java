package com.zerobank.stepdefinitions;

import com.google.gson.internal.bind.util.ISO8601Utils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Hooks {


    @Before
    public void setup(Scenario scenario) {
        System.out.println("Test Setup for");
    }

    @After()
    public void teardown(Scenario scenario){
        if(scenario.isFailed())
        {
            TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver(ConfigurationReader.getProperty("browser"));
            // cucumber requires array of bytes for ss but test ng requires FILE
            byte[] image = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            //attach ss to report
            scenario.embed(image,"image/png",scenario.getName());
        }
        System.out.println("Test Clean Up");
        Driver.closeDriver();
    }

 /*   @Before(value = "@download")
    public void specialSetup() {

        folder = new File(UUID.randomUUID().toString());
        folder.mkdir();

//  System.setProperty("webdriver.chrome.driver","/Users/ilhan/Downloads/chromedriver");
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("download.default_directory", folder.getAbsolutePath());

        options.setExperimentalOption("prefs", prefs);
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(ChromeOptions.CAPABILITY, options);*/


 /*  @After(value = "@download")
        public void SpecialTearDown()
        {
            Driver.DownloadClose();
        }
*/


}
