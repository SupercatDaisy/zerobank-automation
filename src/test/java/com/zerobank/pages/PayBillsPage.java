package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import com.zerobank.utilities.Wait;
import io.cucumber.java.eo.Se;
import io.cucumber.java.sk.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class PayBillsPage  extends BasePage{


    @FindBy(id = "sp_payee")
    private WebElement Payee;

    @FindBy(id = "sp_account")
    private WebElement Account;

    @FindBy(id = "sp_amount")
    private WebElement Amount;

    @FindBy(id = "sp_date")
    private WebElement Date;

    @FindBy(id = "sp_description")
    private WebElement Description;

    @FindBy(id = "pay_saved_payees")
    private WebElement payBtn;

    @FindBy(id = "alert_content")
    private WebElement msg;

    @FindBy(linkText = "5")
    public WebElement CalendarConfirm;

    @FindBy(linkText = "Add New Payee")
    private WebElement addNewPayee;

    @FindBy(id = "np_new_payee_name")
    private WebElement payeeName;

    @FindBy(id = "np_new_payee_address")
    private WebElement textArea;

    @FindBy(id = "np_new_payee_account")
    private WebElement newAccount;

    @FindBy(id = "np_new_payee_details")
    private WebElement newPayeeDetails;

    @FindBy(id = "add_new_payee")
    private WebElement Add;

    @FindBy(linkText = "Purchase Foreign Currency")
    private WebElement PurchaseForeignCurrency;

    @FindBy(id = "pc_currency")
    private WebElement CurrencyList;

    @FindBy(id = "purchase_cash")
    private WebElement purchase;

    public String getAlertMsg()
    {
        return driver.switchTo().alert().getText();
    }



    public void clickPurchase()
    {
        wait.until(ExpectedConditions.elementToBeClickable(purchase));
        purchase.click();
    }

    public List<String> getCurrencyList()
    {
        wait.until(ExpectedConditions.visibilityOf(CurrencyList));
        Select get = new Select(CurrencyList);
        return BrowserUtils.getTextFromWebElements(get.getOptions());
    }

    public boolean CheckList(List<String> currency)
    {
            if(getCurrencyList().containsAll(currency))
                return true;
            else
                return false;
        }

    public void clickPurchaseForeign (){
        wait.until(ExpectedConditions.elementToBeClickable(PurchaseForeignCurrency));
        PurchaseForeignCurrency.click();
    }

    public void clickAdd()
    {
        wait.until(ExpectedConditions.elementToBeClickable(Add));
        Add.click();
    }
    public void setPayeeName(String name)
    {
        wait.until(ExpectedConditions.visibilityOf(payeeName));
        payeeName.sendKeys(name);
    }

    public void setPayeeAddress(String address)
    {
        wait.until(ExpectedConditions.visibilityOf(textArea));
        textArea.sendKeys(address);
    }

    public void setnewAccount(String acc)
    {
        wait.until(ExpectedConditions.visibilityOf(newAccount));
        newAccount.sendKeys(acc);
    }

    public void setNewPayeeDetails(String detail)
    {
        wait.until(ExpectedConditions.visibilityOf(newPayeeDetails));
        newPayeeDetails.sendKeys(detail);
    }



    public void clickAddNewPayee()
    {
        wait.until(ExpectedConditions.elementToBeClickable(addNewPayee));
        addNewPayee.click();
    }

    public String getAmount()
    {
        return Amount.getAttribute("value");
    }

    public String getDate()
    {
        return Date.getAttribute("value");
    }


    public String getAmountAlert()
    {
        return Amount.getAttribute("validationMessage");
    }

    public String getDateAlert()
    {
        return Date.getAttribute("validationMessage");
    }


    public String getMsg()
    {
        return msg.getText();
    }

    public void clickPaybtn()
    {
        wait.until(ExpectedConditions.elementToBeClickable(payBtn));
        payBtn.click();
    }
    public void setDescription(String desc)
    {
        wait.until(ExpectedConditions.visibilityOf(Description));
        Description.sendKeys(desc);
    }

    public void setDate (String date)
    {
        wait.until(ExpectedConditions.visibilityOf(Date));
        Date.sendKeys(date);
        CalendarConfirm.click();

    }

    public void setAmount (String amount)
    {
        wait.until(ExpectedConditions.visibilityOf(Account));
        Amount.sendKeys(amount);
    }

    public void setAccount(String account_txt)
    {
        wait.until(ExpectedConditions.visibilityOfAllElements(Account));
        Select account = new Select(Account);
        account.selectByVisibleText(account_txt);
    }

    public void setPayee(String payee_txt)
    {
        wait.until(ExpectedConditions.visibilityOfAllElements(Payee));
        Select pay = new Select(Payee);
        pay.selectByVisibleText(payee_txt);
    }


}
