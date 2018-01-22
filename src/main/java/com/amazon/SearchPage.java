package com.amazon;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;

import java.io.IOException;


public class SearchPage extends BasePage {

    @FindBy(how = How.ID, using = "twotabsearchtextbox")
    public WebElement searchBox;

    @FindBy(how = How.CSS, using = ".nav-input")
    public WebElement search;


    public SearchPage() {

        PageFactory.initElements(driver, this);
    }

    public SearchPage searchProduct() throws IOException {
        try {
            searchBox.sendKeys("Le Creuset Classic Cast Iron Heart Casserole");//search Le creuset casserole
            search.click();//click search
        } catch (Exception e) {
            CommonUtils.captureScreenshot("FaledToGetCasserolProduct");
        }
        return this;
    }



    public BasePage errorMessage() throws IOException {

        try {
            Assert.assertTrue(CommonUtils.isTextPresent(" did not match any products."));//check the error message for invalid  product search

        } catch (Exception e) {
            CommonUtils.captureScreenshot("FailedToSearchInvalidProduct");
        }
        return this;
    }

    @Test
    public void invalidProductSearch() throws IOException//search invalid product and get error message
    {
       // dashBoardPage.welcomeMessage();
       // searchPage.searchInvalidProduct().errorMessage();

    }
}
