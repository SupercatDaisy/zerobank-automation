package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AccountSummaryPage extends BasePage {


@FindBy(tagName = "h2")
    private List<WebElement> AccountTypes;

@FindBy(xpath = "//th[contains(text(),'Credit')]/../th")
private List<WebElement> credit_column;


public void clickAccounts(String accountType)
{
   WebElement type = Driver.getDriver("chrome").findElement(By.linkText(accountType));
   wait.until(ExpectedConditions.elementToBeClickable(type));
   type.click();
}


public List<String> getAccountTypes(){
    wait.until(ExpectedConditions.visibilityOfAllElements(AccountTypes));
    return BrowserUtils.getTextFromWebElements(AccountTypes);
}

public List<String> getcredit_column()
{
    wait.until(ExpectedConditions.visibilityOfAllElements(credit_column));
    return BrowserUtils.getTextFromWebElements(credit_column);
}

}
