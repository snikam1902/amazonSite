package com.amazon;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;

import java.io.IOException;
import java.util.List;


public class ProductPage extends BasePage {

    public String casseroleProductName;

    @FindBy(how = How.CSS, using = "#add-to-cart-button-ubb")
    public WebElement addToCart;

    @FindBy(how = How.CSS, using = "#add-to-cart-button")
    public WebElement addToBasket;


    public ProductPage() {

        PageFactory.initElements(driver, this);
    }

    public void selectTablet() throws IOException {

        try {
            CommonUtils.waitAndClickOnLink("Apple");//select Apple brand
            CommonUtils.sleep(2);
            CommonUtils.waitAndClickOnLink("iPad 2");//select model ipad2
            driver.findElement(By.cssSelector("#s-results-list-atf li h2[data-attribute='" + "Apple iPad 2 16GB (Black, Wi-Fi Only) - Genuine UK Stock" + "']")).click();
            CommonUtils.sleep(1);
            addToCart.click();//click add to cart button
        } catch (Exception e) {
            CommonUtils.captureScreenshot("faiedToSelectTablet");
        }
    }

    public ProductPage selectCasserolProduct() throws IOException {
        try {
            WebElement casseroleProduct = driver.findElement(By.cssSelector("#s-results-list-atf li h2[data-attribute='" + "Le Creuset Classic Cast Iron Heart Casserole, 1.9 L - Cerise" + "']"));
            casseroleProductName = casseroleProduct.getText();
            casseroleProduct.click();
            CommonUtils.sleep(1);
            addToBasket.click();// click add to Basket
        } catch (Exception e) {
            CommonUtils.captureScreenshot("FailedToSelectCasserol");
        }

        return this;
    }

}


