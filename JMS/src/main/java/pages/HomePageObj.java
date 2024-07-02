package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObj {

    private WebDriver driver;

    public  HomePageObj(WebDriver driver) {


        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//img[@src='/jms/src/assets/GeneralIcons/shortcuts.svg'])[1]")
    public static WebElement menuTrigger;







}
