package com.zerobank.pages;

import com.google.gson.internal.bind.util.ISO8601Utils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.util.List;

public class OnlineStatementsPage extends BasePage {

    @FindBy(xpath = "//ul[@class='nav nav-pills']//li//a")
    private List<WebElement> years;

    @FindBy(xpath = "//div[@class='tab-pane active']//tr//a")
    private List<WebElement> statements;


public void selectYears(Integer year)
{
    for (int i = 0; i <years.size() ; i++) {
        if(Integer.parseInt(years.get(i).getText())==year)
        years.get(i).click();
    }
}

public Integer getNumberStatements()
{
    return statements.size();
}

public void selectStatement(String statement)
{
    for (int i = 0; i <statements.size() ; i++) {
        if(statements.get(i).getText().equals(statement))
            statements.get(i).click();

    }
}


public boolean checkFile(String fileName) {
    String home = System.getProperty("user.home");
    String downloadFilepath = home + "/Downloads/";
    File dir = new File(downloadFilepath);
    File[] dirContents = dir.listFiles();
    for (int i = 0; i < dirContents.length; i++) {
        if (dirContents[i].getName().contains(fileName)) {
          // If I wanted to delete ---> dirContents[i].delete();
           //I will keep it for extension check
            return true;
        }
    }
    return false;
}


public boolean checkExtension(String fileName)
{
    String home = System.getProperty("user.home");
    String downloadFilepath = home + "/Downloads/";
    File dir = new File(downloadFilepath);
    File[] dirContents = dir.listFiles();
    //FilenameUtils is from Apache Commons IO library
    //There are other methods to check as well
    //File Path can be more dynamic if Requirements were not strict.
    String ext = FilenameUtils.getExtension(downloadFilepath+"8534567-"+fileName+".pdf");
    for (int i = 0; i < dirContents.length; i++) {
        if (dirContents[i].getName().contains(fileName) && ext.equals("pdf")) {
            return true;
            }
        }
    return false;
    }


}









