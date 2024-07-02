
package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class JmsListener implements ITestListener {
    public static ExtentReports extent;
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    static {

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("JMS Report.html");

        sparkReporter.config().setDocumentTitle("Extent Reports");
        sparkReporter.config().setReportName("Test Report");
        sparkReporter.config().setTheme(Theme.DARK);


        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Tester", "Hassan - Automation Tester");


    }

    @Override
    public void onStart(ITestContext context) {

        // Nil

    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getDescription());
        test.set(extentTest);
        // Log parameters (if any)
        Object[] parameters = result.getParameters();
        for (Object parameter : parameters) {
            test.get().log(Status.INFO, "Parameter: " + parameter);
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().log(Status.FAIL, "Test Failed");
        test.get().log(Status.FAIL, result.getThrowable());
        // Capture and add screenshot
        WebDriver currentDriver = driver.get();
        if (currentDriver != null) {
            try {
                String screenshotPath = "screenshots/" + result.getMethod().getDescription() + ".png";
                File screenshot = ((TakesScreenshot) currentDriver).getScreenshotAs(OutputType.FILE);
                Files.createDirectories(Paths.get("screenshots"));
                Files.copy(screenshot.toPath(), Paths.get(screenshotPath), StandardCopyOption.REPLACE_EXISTING);
                test.get().addScreenCaptureFromPath(screenshotPath);
            } catch (IOException e) {
                test.get().log(Status.WARNING, "Failed to capture screenshot: " + e.getMessage());
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
//        if (extent != null) {
//            extent.flush();
//
//        }
    }

    // Set the WebDriver object for Selenium
    public static void setDriver(WebDriver webDriver) {
        driver.set(webDriver);
    }

    public static void flushExtentReports() {
        if (extent != null) {
            extent.flush();
        }

    }
}
