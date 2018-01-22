package com.amazon;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;

import java.io.IOException;


public class BasketPage extends BasePage {

    @FindBy(how = How.CSS, using = "#nav-cart-count")
    public WebElement basketButton;

    @FindBy(how = How.CSS, using = ".a-dropdown-prompt")
    public WebElement productQuantity;
    @FindBy(how = How.CSS, using = ".a-size-medium.a-text-bold")
    public WebElement totalProductQuantity;


    public String productQntity;
    public String totalQnty;

    public BasketPage() {

        PageFactory.initElements(driver, this);

    }


    public BasketPage checkItemsAdded() throws IOException {

      try {
          Assert.assertTrue(CommonUtils.isTextPresent("Added to"));//check product added to basket

      }catch (Exception e)
      {
          CommonUtils.captureScreenshot("failedToAdd");
      }
        return this;
    }




    public BasketPage checkBasketProducts() throws IOException {

       try {
           CommonUtils.sleep(1);

           basketButton.click();//click on basket

           Assert.assertTrue(CommonUtils.isTextPresent("Shopping Basket"));//check the page is shopping basket page
           productQntity = productQuantity.getText();//get the product quantity
           totalQnty = totalProductQuantity.getText();//get the total product quantity

       }catch (Exception e)
       {
           CommonUtils.captureScreenshot("Failed BasketProduct");
       }
        return this;

    }
}
