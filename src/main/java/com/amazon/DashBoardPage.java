package com.amazon;

import com.sun.xml.internal.ws.policy.AssertionSet;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonUtils;

import java.io.IOException;


public class DashBoardPage extends BasePage {

    @FindBy(how = How.CSS, using = ".a-size-extra-large.a-spacing-medium.a-spacing-top-extra-large")
    public WebElement WelcomeText;

    @FindBy(how = How.CSS, using = ".nav-line-2")
    public WebElement shopByDepartment ;

    public DashBoardPage() {

        PageFactory.initElements(driver, this);
    }
    public DashBoardPage welcomeMessage() throws IOException {
       try{ String welcomeText = WelcomeText.getText();
        Assert.assertTrue(welcomeText.contains("Welcome"));
       }catch (Exception e)
       {
           CommonUtils.captureScreenshot("NotOnDashboardPage");
       }

return this;
    }

    public void gotoProductPage() throws IOException {

      try {
          shopByDepartment.click();/////////click shop by department
          CommonUtils.waitAndClickOnLink("Tablets");//select tablets
      }catch (Exception e)
      {
          CommonUtils.captureScreenshot("failedToGoToTabletPage");
      }

    }
}
