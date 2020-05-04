package com.zerobank.pages;

import com.zerobank.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    @FindBy(id = "user_login")
    private WebElement login_txt;

    @FindBy(id = "user_password")
    private WebElement password_txt;

    @FindBy(id = "user_remember_me")
    private WebElement keepMe;

    @FindBy(css = "input[name='submit']")
    private WebElement signButton;

    @FindBy(linkText = "Forgot your password ?")
    private WebElement forgotPass;

    @FindBy(css = "div[class='alert alert-error']")
    private WebElement errorMsg;

    public WebElement getError(){
        return errorMsg;
    }

    public String getErrorMsg()
    {
        return errorMsg.getText().trim();
    }

    public void login(String username,String password,boolean keepSignIn)
    {
        wait.until(ExpectedConditions.visibilityOf(login_txt));
        login_txt.sendKeys(username);
        wait.until(ExpectedConditions.visibilityOf(password_txt));
        password_txt.sendKeys(password);
        if(keepSignIn){
            wait.until(ExpectedConditions.visibilityOf(keepMe));
            keepMe.click();
        }
        signButton.click();
    }

    public void login(String username,String password)
    {
        wait.until(ExpectedConditions.visibilityOf(login_txt));
        login_txt.sendKeys(username);
        wait.until(ExpectedConditions.visibilityOf(password_txt));
        password_txt.sendKeys(password);
        signButton.click();
    }


    public void login (){
        wait.until(ExpectedConditions.visibilityOf(login_txt));
        login_txt.sendKeys(ConfigurationReader.getProperty("login"));
        wait.until(ExpectedConditions.visibilityOf(password_txt));
        password_txt.sendKeys(ConfigurationReader.getProperty("password"));
        signButton.click();
    }





}
