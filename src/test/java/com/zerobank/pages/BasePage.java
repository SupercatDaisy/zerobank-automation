package com.zerobank.pages;

import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import com.zerobank.utilities.Wait;
import io.cucumber.java.cy_gb.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class BasePage {

protected WebDriverWait wait = new WebDriverWait(Driver.getDriver(ConfigurationReader.getProperty("browser")),10);
protected WebDriver driver = Driver.getDriver(ConfigurationReader.getProperty("browser"));

@FindBy(id = "signin_button")
private WebElement signButton;

@FindBy(linkText = "Account Summary")
private WebElement Account;

public String getTitle(){
    wait.until(ExpectedConditions.visibilityOf(Account));
    return Driver.getDriver(ConfigurationReader.getProperty("browser")).getTitle();
}

public String getGlobalTitle()
{
    return Driver.getDriver(ConfigurationReader.getProperty("browser")).getTitle();
}

public void clickmain()
{
    wait.until(ExpectedConditions.visibilityOf(signButton));
    signButton.click();
}

public BasePage()
{
    PageFactory.initElements(Driver.getDriver(ConfigurationReader.getProperty("browser")),this);
}


public void navigateTo(String tabName)
{
 WebElement tab= driver.findElement(By.linkText(tabName));
 wait.until(ExpectedConditions.elementToBeClickable(tab));
 tab.click();
Wait.wait(1);

}




}
