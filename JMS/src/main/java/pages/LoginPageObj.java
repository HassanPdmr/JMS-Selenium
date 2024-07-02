package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObj {

    private WebDriver driver;

    public LoginPageObj(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    @FindBy(id = "siginIn_id")
    public static WebElement username;

    @FindBy(id = "signin_pwd")
    public static WebElement password;

    @FindBy(xpath = "//*[text()='Sign in']")
    public static WebElement signIn;






    @FindBy(xpath = "//*[text()='Logout']")
    public static WebElement logout;














}
