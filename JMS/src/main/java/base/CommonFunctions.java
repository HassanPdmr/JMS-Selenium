package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.LoginPageObj;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class CommonFunctions {

    public static WebDriver driver = null;
    public static String Username;
    public static String Password;
    public static Properties properties;
    public static ExtentReports extentReport;
    public static ExtentSparkReporter sparkReporter;
    public static ExtentTest testCase;

    public Properties initProperties() throws IOException {
        FileInputStream fio = new FileInputStream("Config.properties");
        properties = new Properties();
        properties.load(fio);
        return properties;
    }

    @BeforeSuite
    public void LaunchBrowser() throws IOException {


        initProperties();
//        extentReport = new ExtentReports();
//        sparkReporter = new ExtentSparkReporter("ExtentReport.html");
//        extentReport.attachReporter(sparkReporter);
//        sparkReporter.config().setTheme(Theme.DARK);


        String url = properties.getProperty("url");
        String browser = properties.getProperty("browser");
        Username = properties.getProperty("pmusername");
        Password = properties.getProperty("pmpassword");


        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("disable-features=NetworkService");

            driver.get(url);
            driver.manage().window().maximize();
            driver.findElement(By.xpath("//input[@type='text']")).sendKeys(Username);
            driver.findElement(By.xpath("//input[@type='password']")).sendKeys(Password);
            driver.findElement(By.xpath("//button")).click();

        } else {
            System.out.println("chrome not displayed");
            return;
        }


    }

//    public String takeScreenshot(String testName) {
//        TakesScreenshot ts = (TakesScreenshot) driver;
//        File srcFile = ts.getScreenshotAs(OutputType.FILE);
//        String destPath = testName + ".png";
//        //  FileHandler.copy();
//        try {
//            Files.createDirectories(Paths.get("screenshots"));
//            Files.copy(srcFile.toPath(), Paths.get(destPath));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return destPath;


//    @AfterSuite
//    public void teardown() {
//
//        driver.close();
//
//    }
}