package tests;

import base.CommonFunctions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddJournalPageObj;
import pages.HomePageObj;
import utilities.JmsListener;

import static utilities.ExcelReader.readExcel;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AddJournalTest extends CommonFunctions {


    AddJournalPageObj addJournalPageObj;
    WebDriverWait wait;
    String addJournalPageTxt;

    @BeforeClass
    public void setupPage() {

        addJournalPageObj = new AddJournalPageObj(driver);
        PageFactory.initElements(driver, addJournalPageObj);
        JmsListener.setDriver(driver);
        wait = new WebDriverWait(driver, 60);


    }

    @AfterClass
    public void flushReport() {

        JmsListener.flushExtentReports();


    }

    @DataProvider(name = "Journal Acronym")
    public static Object[][] getAddUSerData() throws IOException {
        return readExcel("D:\\zonetest\\Readtestdata.xlsx", 0);
    }

    @DataProvider(name = "Journal details")
    public static Object[][] getJournalData() throws IOException {
        return readExcel("D:\\zonetest\\Readtestdata.xlsx", 1);
    }


    @DataProvider(name = "General and FastTrack")
    public static Object[][] getGeneralFastTrackTypeData() throws IOException {
        return readExcel("D:\\zonetest\\Readtestdata.xlsx", 2);
    }

    //    private void scrollIntoView(WebDriver driver, WebElement element) {
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//    }


    @Test(priority = 1, description = "Check & verify add journal page model")
    public void verifyAddJournalModel() throws InterruptedException {


        WebElement triggerIcon = wait.until(ExpectedConditions.visibilityOf(HomePageObj.menuTrigger));
        triggerIcon.click();
        Thread.sleep(4000);

        boolean journalIcon = AddJournalPageObj.addJournalButton.isDisplayed();
        System.out.println("Add_Journal icon displayed " + journalIcon);
        Assert.assertTrue(journalIcon, "Add journal not displayed");

        Thread.sleep(4000);

        wait.until(ExpectedConditions.visibilityOf(AddJournalPageObj.addJournalButton)).click();
        Thread.sleep(3000);

        addJournalPageTxt = AddJournalPageObj.addJournalPage.getText();
        Assert.assertEquals(addJournalPageTxt, "Add Journal", "Add Journal page was not displayed");
        System.out.println("Add journal page displayed title as " + addJournalPageTxt);


    }

    @Test(priority = 2, description = "Check & verify add journal details", dataProvider = "Journal Acronym")
    public void verifyAddJournalDetails(String journalAcronym, String journalName) throws InterruptedException {


        Thread.sleep(2000);
        AddJournalPageObj.publisher_1.click();
        WebElement EMS_Press = wait.until(ExpectedConditions.visibilityOf(AddJournalPageObj.publisher_2));
        EMS_Press.click();
        AddJournalPageObj.journal_acrm.sendKeys(journalAcronym);
        System.out.println("This is Journal Acronym: " + journalAcronym);
        Thread.sleep(2000);

        AddJournalPageObj.journal_fullName.sendKeys(journalName);
        System.out.println("This is Journal Fullname: " + journalName);
        Thread.sleep(2000);

        WebElement checkbox = AddJournalPageObj.recto_facingPage;

        if (checkbox.isEnabled()) {

            System.out.println("Checkbox is clickable.");

        } else {

            System.out.println("Checkbox is not clickable.");

        }

        WebElement rectoCheckbox = wait.until(ExpectedConditions.visibilityOf(AddJournalPageObj.recto_facingPage));
        rectoCheckbox.click();

        AddJournalPageObj.journal_received_date.click();
        LocalDate currentDate = LocalDate.now();

        // Define the date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Format the date
        String formattedDate = currentDate.format(formatter);

        WebElement dateInputField = AddJournalPageObj.journal_received_date;

        dateInputField.sendKeys(formattedDate);

        // Print the formatted date
        System.out.println("Current date in dd-MM-yyyy format: " + formattedDate);


    }

    @Test(priority = 3, description = "Check & verify journal work details", dataProvider = "Journal details")
    public void verifyJournalWorkDetails(String TrimWidth, String TrimHeight, String remarkDetails) throws InterruptedException {

        Thread.sleep(1500);
        AddJournalPageObj.layout_1.click();

        WebElement singleLayout = wait.until(ExpectedConditions.visibilityOf(AddJournalPageObj.layout_2));
        singleLayout.click();

        Thread.sleep(2000);
        AddJournalPageObj.trimSizeWidth.sendKeys(TrimWidth);
        AddJournalPageObj.trimSizeHeight.sendKeys(TrimHeight);
        WebElement reMarks = wait.until(ExpectedConditions.visibilityOf(AddJournalPageObj.remarks));
        reMarks.sendKeys(remarkDetails);

        AddJournalPageObj.category_1.click();

        WebElement typesetting = wait.until(ExpectedConditions.visibilityOf(AddJournalPageObj.category_2_typeSetting));
        typesetting.click();

        WebElement technicalEdit = wait.until(ExpectedConditions.visibilityOf(AddJournalPageObj.category_2_TechnicalEdit));
        technicalEdit.click();

        WebElement copyEdit = wait.until(ExpectedConditions.visibilityOf(AddJournalPageObj.category_2_CopyEdit));
        copyEdit.click();

        Thread.sleep(2000);
        AddJournalPageObj.copyEditLevel_1.click();
        WebElement copyEdit_L1 = wait.until(ExpectedConditions.visibilityOf(AddJournalPageObj.copyEditLevel_2));
        copyEdit_L1.click();

        Thread.sleep(2000);
        AddJournalPageObj.pubType_1.click();
        WebElement pubType_All = wait.until(ExpectedConditions.visibilityOf(AddJournalPageObj.pubType_CheckAll));
        pubType_All.click();


    }


    @Test(priority = 4, description = "Check & verify General track type details", dataProvider = "General and FastTrack")
    public void verifyGeneralAndFastTrackType(String GrFP_Lx, String GrFP_Grp, String GrFP_PE,
                                              String GrFP_CE, String GrFP_Typ, String GrFP_Qc,
                                              String GrAR_pg, String GrAR_qc, String GrPE_pg,
                                              String GrPE_qc, String GrON_pg, String GrON_qc,
                                              String GrON_xml, String GrIS_pg, String GrIS_qc,
                                              String GrPrint_pg, String GrPrint_qc, String GrPrint_xml,
                                              String FsFP_Lx, String FsFP_Grp, String FsFP_PE,
                                              String FsFP_CE, String FsFP_Typ, String FsFP_Qc,
                                              String FsAR_pg, String FsAR_qc, String FsPE_pg,
                                              String FsPE_qc, String FsON_pg, String FsON_qc,
                                              String FsON_xml, String FsIS_pg, String FsIS_qc,
                                              String FsPrint_pg, String FsPrint_qc, String FsPrint_xml) throws InterruptedException {


        addJournalPageObj.zoomOut(driver);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,490);");

        WebElement GFP_latex = wait.until(ExpectedConditions.visibilityOf(AddJournalPageObj.FProof_general_daysOfLatex));
        GFP_latex.sendKeys(GrFP_Lx);
        AddJournalPageObj.FProof_general_daysOfGraphics.sendKeys(GrFP_Grp);
        AddJournalPageObj.FProof_general_daysOfPreEdit.sendKeys(GrFP_PE);
        AddJournalPageObj.FProof_general_daysOfCopyEdit.sendKeys(GrFP_CE);
        AddJournalPageObj.FProof_general_Typesetting.sendKeys(GrFP_Typ);
        AddJournalPageObj.FProof_general_daysOfQC.sendKeys(GrFP_Qc);

        WebElement FFP_latex = wait.until(ExpectedConditions.visibilityOf(AddJournalPageObj.FProof_fastTrack_daysOfLatex));
        FFP_latex.sendKeys(FsFP_Lx);
        AddJournalPageObj.FProof_fastTrack_daysOfGraphics_.sendKeys(FsFP_Grp);
        AddJournalPageObj.FProof_fastTrack_daysOfPreEdit.sendKeys(FsFP_PE);
        AddJournalPageObj.FProof_fastTrack_daysOfCopyEdit.sendKeys(FsFP_CE);
        AddJournalPageObj.FProof_fastTrack_Typesetting.sendKeys(FsFP_Typ);
        AddJournalPageObj.FProof_fastTrack_daysOfQC.sendKeys(FsFP_Qc);

        WebElement G_AR_pg = wait.until(ExpectedConditions.visibilityOf(AddJournalPageObj.AURevises_general_daysOfPagination));
        G_AR_pg.sendKeys(GrAR_pg);
        AddJournalPageObj.AURevises_general_daysOfQC.sendKeys(GrAR_qc);
        AddJournalPageObj.PERevises_general_daysOfPagination.sendKeys(GrPE_pg);
        AddJournalPageObj.PERevises_general_daysOfQC.sendKeys(GrPE_qc);
        AddJournalPageObj.OnlineFirst_general_daysOfPagination.sendKeys(GrON_pg);
        AddJournalPageObj.OnlineFirst_general_daysOfQC.sendKeys(GrON_qc);
        AddJournalPageObj.OnlineFirst_general_daysOfXML.sendKeys(GrON_xml);

        WebElement F_AR_pg = wait.until(ExpectedConditions.visibilityOf(AddJournalPageObj.AURevises_fastTrack_daysOfPagination));
        F_AR_pg.sendKeys(FsAR_pg);
        AddJournalPageObj.AURevises_fastTrack_daysOfQC.sendKeys(FsAR_qc);
        AddJournalPageObj.PERevises_fastTrack_daysOfPagination.sendKeys(FsPE_pg);
        AddJournalPageObj.PERevises_fastTrack_daysOfQC.sendKeys(FsPE_qc);
        AddJournalPageObj.OnlineFirst_fastTrack_daysOfPagination.sendKeys(FsON_pg);
        AddJournalPageObj.OnlineFirst_fastTrack_daysOfQC.sendKeys(FsON_qc);
        AddJournalPageObj.OnlineFirst_fastTrack_daysOfXML.sendKeys(FsON_xml);

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,320);");
        AddJournalPageObj.ForIssue_general_daysOfPage.sendKeys(GrIS_pg);
        AddJournalPageObj.ForIssue_general_daysOfQC.sendKeys(GrIS_qc);
        AddJournalPageObj.Print_web_general_daysOfPagination.sendKeys(GrPrint_pg);
        AddJournalPageObj.Print_web_general_daysOfQC.sendKeys(GrPrint_qc);
        AddJournalPageObj.Print_web_general_daysOfXML.sendKeys(GrPrint_xml);

        WebElement F_Is_pg = wait.until(ExpectedConditions.visibilityOf(AddJournalPageObj.ForIssue_fastTrack_daysOfPage));
        F_Is_pg.sendKeys(FsIS_pg);
        AddJournalPageObj.ForIssue_fastTrack_daysOfQC.sendKeys(FsIS_qc);
        AddJournalPageObj.Print_web_fastTrack_daysOfPagination.sendKeys(FsPrint_pg);
        AddJournalPageObj.Print_web_fastTrack_daysOfQC.sendKeys(FsPrint_qc);
        AddJournalPageObj.Print_web_fastTrack_daysOfXML.sendKeys(FsPrint_xml);




    }

}
