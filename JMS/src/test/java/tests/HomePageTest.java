package tests;

import base.CommonFunctions;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePageObj;
import utilities.JmsListener;

public class HomePageTest extends CommonFunctions {

    HomePageObj homePageObj;
    WebDriverWait wait;

    @BeforeClass
    public void setupPage() {

        homePageObj = new HomePageObj(driver);
        PageFactory.initElements(driver, homePageObj);
        JmsListener.setDriver(driver);
        wait = new WebDriverWait(driver, 60);

    }

    @Test(description = "Check & verify menu icon is enabled")
    public void verifyHomePage() {

        WebElement baseIcon = wait.until(ExpectedConditions.visibilityOf( HomePageObj.menuTrigger));
        boolean chk = baseIcon.isDisplayed();
        System.out.println("Menu icon: "+chk);

        Assert.assertTrue(chk, "Icon not displayed");

        JmsListener.test.get().info("verifying the Add Publisher icon_2 ");





    }


}
