package com.amazon;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utils.CommonUtils;

import java.io.IOException;

public class e2eTest extends BaseTest {

    BasePage basePage = new BasePage();
    DashBoardPage dashBoardPage = new DashBoardPage();
    BasketPage basketPage = new BasketPage();
    ProductPage productPage = new ProductPage();
    SearchPage searchPage = new SearchPage();

    @Test
    public void userCatlogBrowseJourney() throws IOException {
        dashBoardPage.welcomeMessage().gotoProductPage();//select tablet product through category
        productPage.selectTablet();
        basketPage.checkItemsAdded().checkBasketProducts();
        Assert.assertTrue(basketPage.productQntity.equals("1"));//check product quantity is 1 for tablet
        Assert.assertTrue(CommonUtils.getText(By.linkText("Apple iPad 2 16GB (Black, Wi-Fi Only) - Genuine UK Stock")).contains("Apple iPad 2 16GB (Black, Wi-Fi Only) - Genuine UK Stock"));
    }


    @Test
    public void userSearchJourney() throws IOException {
        dashBoardPage.welcomeMessage().gotoProductPage();//select tablet product through category
        productPage.selectTablet();
        basketPage.checkItemsAdded().checkBasketProducts();
        Assert.assertTrue(basketPage.productQntity.equals("1"));//check product quantity is 1 for tablet
        searchPage.searchProduct();
        productPage.selectCasserolProduct();//search product with name
        basketPage.checkItemsAdded().checkBasketProducts();
        Assert.assertTrue(basketPage.productQntity.equals("1"));//check  product quantity 1 for casserole
        Assert.assertTrue(basketPage.totalQnty.contains("2"));//check total product quantity 2

    }


    @Test
    public void Searchcasserole() throws IOException {//search casserole and add to basket
        dashBoardPage.welcomeMessage();
        searchPage.searchProduct();
        productPage.selectCasserolProduct();
        basketPage.checkItemsAdded().checkBasketProducts();
        Assert.assertTrue(basketPage.productQntity.equals("1"));

    }

    @Test
    public void invalidProductSearch() throws IOException//search invalid product and get error message
    {
     //   dashBoardPage.welcomeMessage();
       // searchPage.searchInvalidProduct().errorMessage();

    }


}
