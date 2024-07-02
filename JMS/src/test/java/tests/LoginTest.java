package tests;

import base.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPageObj;
import utilities.JmsListener;

import java.io.IOException;

import static utilities.ExcelReader.readExcel;

public class LoginTest extends CommonFunctions {

    LoginPageObj loginPageObj;
    WebDriverWait wait;

    @BeforeClass
    public void setupPage() {

        loginPageObj = new LoginPageObj(driver);
        PageFactory.initElements(driver, loginPageObj);
        wait = new WebDriverWait(driver, 50);
        JmsListener.setDriver(driver);

        WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Logout']")));
        logout.click();


    }


    @DataProvider(name = "LoginCredentials")
    public static Object[][] getLoginData() throws IOException {
        return readExcel("D:\\newUpload\\Readlogindata.xlsx", 0);
    }


    @Test(priority = 1,dataProvider = "LoginCredentials", description = "verify and validate the login functionality by providing valid data")
    public void verifyLoginJMS(String username, String Pwd) throws InterruptedException {

        testCase.info(username + " " + Pwd + " ");
        LoginPageObj.username.sendKeys(username);
        LoginPageObj.password.sendKeys(Pwd);
        LoginPageObj.signIn.click();
        System.out.println("Login done");
        testCase.info("JMS login completed");
        Thread.sleep(5000);


        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='* Invalid username or password.']")));
        String actualtext = errorMessage.getText();

        Assert.assertEquals(actualtext, "* Invalid username or password.", "Login should not success");

        testCase.info("Error message is showing " + ":" + actualtext);


    }

    @AfterMethod
    public void  afterLogin()
    {

        driver.navigate().refresh();
//         LoginPageObj.logout.click();

    }
    @AfterClass
    public void loginFinally(){

        LoginPageObj.username.sendKeys(properties.getProperty("pmusername"));
        LoginPageObj.password.sendKeys(properties.getProperty("pmpassword"));
        LoginPageObj.signIn.click();


    }

}
















