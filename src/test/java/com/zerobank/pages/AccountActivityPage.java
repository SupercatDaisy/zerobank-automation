package com.zerobank.pages;

import com.google.gson.internal.bind.util.ISO8601Utils;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import com.zerobank.utilities.Wait;
import io.github.bonigarcia.wdm.SeleniumServerStandaloneManager;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AccountActivityPage extends BasePage {

    @FindBy(id = "aa_accountId")
    private WebElement accountDropDown;

    @FindBy(id = "aa_description")
    private WebElement description;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr//td[2]")
    private List<WebElement> resultDescription;

    @FindBy(linkText = "Find Transactions")
    private WebElement findTransaction;

    @FindBy(xpath = "//th[contains(text(),'Date')]/../th")
    private List<WebElement> transactionColumn;

    @FindBy(id = "aa_fromDate")
    private WebElement fromDate;

    @FindBy(id = "aa_toDate")
    private WebElement toDate;

    @FindBy(css = "button[type='submit']")
    private WebElement findBtn;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr//td[1]")
    private List<WebElement> resultDates;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr//td[3]")
    private List<WebElement> resultDeposit;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr//td[4]")
    private List<WebElement> resultWithdrawl;

    @FindBy(id = "aa_type")
    private WebElement type;

    public void selectType(String type)
    {
        wait.until(ExpectedConditions.elementToBeClickable(this.type));
        Select drop = new Select(this.type);
        drop.selectByVisibleText(type);
        Wait.wait(2);
    }
    public boolean checkresultDeposit()
    {
        int count=0;
        for (WebElement w:resultDeposit) {
            if(w.getText().length()>=1)
                count++;
            if(count>=1)
                return true;
        }return false;}

    public boolean checkresultWithdrawal()
    {
        int count=0;
        for (WebElement w:resultWithdrawl) {
            if(w.getText().length()>=1)
                count++;
            if(count>=1)
                return true;
        }return false;}

    public void setDescription(String desc)
    {
        wait.until(ExpectedConditions.visibilityOf(description));
        description.clear();
        description.sendKeys(desc);
    }

    public boolean checkDescription(String con)
    {
        List<String> check = BrowserUtils.getTextFromWebElements(resultDescription);
        for (String s : check) {
            if (!s.contains(con)) {
                return false;
            }
        }
        return true;
    }

    public String getResultDates(String con)
    {
        if(con.equals("end"))
            return resultDates.get(0).getText();
        else if(con.equals("begin"))
            return resultDates.get(resultDates.size()-1).getText();
        else
            return "Choose either begin or end";
    }
    public boolean transDate(String date)
    {
        List<String> ResultDates = BrowserUtils.getTextFromWebElements(resultDates);
        return ResultDates.contains(date);
    }

    public boolean dateInterval (String begin,String end)
    {
        String newBegin= begin.replace("-","");
        String newEnd = end.replace("-","");
        List<String> ResultDates = BrowserUtils.getTextFromWebElements(resultDates);
        int size = ResultDates.size();
        wait.until(ExpectedConditions.visibilityOfAllElements(resultDates));
        String resultEnd = ResultDates.get(0).replace("-","");
        String resultBegin=ResultDates.get(size-1).replace("-","");
        if (Integer.parseInt(resultEnd) == Integer.parseInt(newEnd) && Integer.parseInt(resultBegin)>=Integer.parseInt(newBegin))
            return true;
        else
            return false; }

    public boolean isSorted()
    { List<String> sortedList = new ArrayList<>();
       List<String> change = BrowserUtils.getTextFromWebElements(resultDates);
        sortedList.addAll(change);
        sortedList.sort(Collections.reverseOrder());
        return sortedList.equals(change);
    }

    public void clickfindBtn()
    {
        wait.until(ExpectedConditions.elementToBeClickable(findBtn));
        findBtn.click();
        Wait.wait(1);
    }

    public void setFromDate(String date)
    {
        wait.until(ExpectedConditions.visibilityOf(fromDate));
        fromDate.clear();
        fromDate.sendKeys(date, Keys.ENTER);
    }

    public void setToDate(String date)
    {
        wait.until(ExpectedConditions.visibilityOf(toDate));
        toDate.clear();
        toDate.sendKeys(date,Keys.ENTER);
    }




    public List<String> getTransactionColumn()
    {
        wait.until(ExpectedConditions.visibilityOfAllElements(transactionColumn));
        return BrowserUtils.getTextFromWebElements(transactionColumn);
    }

    public void clickFindTransaction()
    {
        wait.until(ExpectedConditions.elementToBeClickable(findTransaction));
        findTransaction.click();
    }

    public String getAccountDropDown() {
        {
            Select dropDown = new Select(accountDropDown);
            return dropDown.getFirstSelectedOption().getText().trim();
        }
    }

    public List<String> getAllAccountDropDown() {
        {
            Select dropDown = new Select(accountDropDown);
            return BrowserUtils.getTextFromWebElements(dropDown.getOptions());
        }


    }
}