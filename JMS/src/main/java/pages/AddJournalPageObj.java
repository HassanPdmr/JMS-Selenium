package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddJournalPageObj {


    private WebDriver driver;

    public AddJournalPageObj(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public void zoomOut(WebDriver driver) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='80%'");
    }



    @FindBy(xpath = "//img[@src='/jms/src/assets/GeneralIcons/shortcuts.svg']")
    public static WebElement menuTrigger_1;

    @FindBy(id = "add_journal")
    public static WebElement addJournalButton;

    @FindBy(xpath = "(//*[text()='Add Journal'])[1]")
    public static WebElement addJournalPage;

    @FindBy(xpath = "//input[@id='publisher']")
    public static WebElement publisher_1;

    @FindBy(xpath = "(//p[normalize-space()='EMS Press'])[1]")
    public static WebElement publisher_2;

    @FindBy(xpath = "(//input[contains(@data-testid,'journal-acronym')])[1]")
    public static WebElement journal_acrm;

    @FindBy(xpath = "(//input[@data-testid='journal-full-name'])[1]")
    public static WebElement journal_fullName;

    @FindBy(xpath = "(//span[@class='_checkmark_1cql0_1703'])[1]")
    public static WebElement recto_facingPage;

    @FindBy(xpath = "(//input[@placeholder='dd-mm-yyyy'])[1]")
    public static WebElement journal_received_date;

    @FindBy(id = "layout")
    public static WebElement layout_1;

    @FindBy(xpath = "//p[text()='Single']")
    public static WebElement layout_2;

    @FindBy(xpath = "//label[text()='Trim Size Width']/../input")
    public static WebElement trimSizeWidth;

    @FindBy(xpath = "//label[text()='Trim Size Height']/../input")
    public static WebElement trimSizeHeight;

    @FindBy(id = "remarks")
    public static WebElement remarks;

    @FindBy(xpath = "//label[text()='Category']/../input")
    public static WebElement category_1;

    @FindBy(xpath = "//p[normalize-space()='Typesetting']")
    public static WebElement category_2_typeSetting;

    @FindBy(xpath = "//p[normalize-space()='Technical Editing']")
    public static WebElement category_2_TechnicalEdit;

    @FindBy(xpath = "//p[normalize-space()='Copy Editing']")
    public static WebElement category_2_CopyEdit;

    @FindBy(id = "copyEditingLevel")
    public static WebElement copyEditLevel_1;

    @FindBy(xpath = "//p[@for='L1']")
    public static WebElement copyEditLevel_2;

    @FindBy(xpath = "//label[text()='Publishing Type']/../input")
    public static WebElement pubType_1;

    @FindBy(xpath = "//div[text()='Check All']")
    public static WebElement pubType_CheckAll;

    @FindBy(id = "trackType")
    public static WebElement trackType;

    @FindBy(xpath = "//*[text()='General']")
    public static WebElement trackType_General;

    //-----General TAT for First Proof-----//

    @FindBy(xpath = "//*[text()='General']/..//*[text()='TAT for First Proof']/../..//*[text()='Days for Latex Normalization']/../input")
    public static WebElement FProof_general_daysOfLatex;

    @FindBy(xpath = "//*[text()='General']/..//*[text()='TAT for First Proof']/../..//*[text()='Days for Graphics']/../input")
    public static WebElement FProof_general_daysOfGraphics;

    @FindBy(xpath = "//*[text()='General']/..//*[text()='TAT for First Proof']/../..//*[text()='Days for Pre-Editing']/../input")
    public static WebElement FProof_general_daysOfPreEdit;

    @FindBy(xpath = "//*[text()='General']/..//*[text()='TAT for First Proof']/../..//*[text()='Days for Copyediting']/../input")
    public static WebElement FProof_general_daysOfCopyEdit;

    @FindBy(xpath = "//*[text()='General']/..//*[text()='TAT for First Proof']/../..//*[text()='Days for Typesetting']/../input")
    public static WebElement FProof_general_Typesetting;

    @FindBy(xpath = "//*[text()='General']/..//*[text()='TAT for First Proof']/../..//*[text()='Days for QC']/../input")
    public static WebElement FProof_general_daysOfQC;

    //------General TAT for AU Revises------//

    @FindBy(xpath = "//*[text()='General']/..//*[text()='TAT for AU Revises ']/../..//*[text()='Days for Pagination']/../input")
    public static WebElement AURevises_general_daysOfPagination;

    @FindBy(xpath = "//*[text()='General']/..//*[text()='TAT for AU Revises ']/../..//*[text()='Days for QC']/../input")
    public static WebElement AURevises_general_daysOfQC;

    //------General TAT for PE Revises------//

    @FindBy(xpath = "//*[text()='General']/..//*[text()=' TAT for PE Revises ']/../..//*[text()='Days for Pagination']/../input")
    public static WebElement PERevises_general_daysOfPagination;

    @FindBy(xpath = "//*[text()='General']/..//*[text()=' TAT for PE Revises ']/../..//*[text()='Days for QC']/../input")
    public static WebElement PERevises_general_daysOfQC;

    //------General TAT for Online First------//

    @FindBy(xpath = "//*[text()='General']/..//*[text()=' TAT for Online First ']/../..//*[text()='Days for Pagination']/../input")
    public static WebElement OnlineFirst_general_daysOfPagination;

    @FindBy(xpath = "//*[text()='General']/..//*[text()=' TAT for Online First ']/../..//*[text()='Days for QC']/../input")
    public static WebElement OnlineFirst_general_daysOfQC;

    @FindBy(xpath = "//*[text()='General']/..//*[text()=' TAT for Online First ']/../..//*[text()='Days for XML']/../input")
    public static WebElement OnlineFirst_general_daysOfXML;

    //------General TAT for Issue------//

    @FindBy(xpath = "//*[text()='General']/..//*[text()=' TAT for Issue']/../..//*[text()='Days for Pagination']/../input")
    public static WebElement ForIssue_general_daysOfPage;

    @FindBy(xpath = "//*[text()='General']/..//*[text()=' TAT for Issue']/../..//*[text()='Days for QC']/../input")
    public static WebElement ForIssue_general_daysOfQC;

    //------General TAT for Print/Web------//

    @FindBy(xpath = "//*[text()='General']/..//*[text()=' TAT for Print/Web ']/../..//*[text()='Days for Pagination']/../input")
    public static WebElement Print_web_general_daysOfPagination;

    @FindBy(xpath = "//*[text()='General']/..//*[text()=' TAT for Print/Web ']/../..//*[text()='Days for QC']/../input")
    public static WebElement Print_web_general_daysOfQC;

    @FindBy(xpath = "//*[text()='General']/..//*[text()=' TAT for Print/Web ']/../..//*[text()='Days for XML']/../input")
    public static WebElement Print_web_general_daysOfXML;

    //------Style Template------//

    @FindBy(xpath = "(//div[@class='_dandd-container_30nmz_11'][normalize-space()='Drag and Drop Files Here or Upload'])[1]")
    public static WebElement styleTemplate_uploadButton;

    //------Guidelines Template------//

    @FindBy(xpath = "(//div[@class='_dandd-container_30nmz_11'][normalize-space()='Drag and Drop Files Here or Upload'])[1]")
    public static WebElement GuidelinesDocument_uploadButton;

    //------Forward & Backward Button------//

    @FindBy(xpath = "(//img[@title='Replicate values from General to Fasttrack'])[1]")
    public static WebElement Replicate_General_To_FastTrack;

    @FindBy(xpath = "(//img[@title='Replicate values from Fasttrack to General'])[1]")
    public static WebElement Replicate_FastTrack_To_General;

    //------Import Operations------//

    @FindBy(xpath = "(//div[@title='Import tats from Publisher'])[1]")
    public static WebElement importTAT_button;

    @FindBy(xpath = "//*[text()='Yes']")
    public static WebElement importTAT_yes;

    @FindBy(xpath = "(//img[@class='_import-icon_1cql0_937'])[2]")
    public static WebElement importStyleTemplate;

    @FindBy(xpath = "(//img[@class='_import-icon_1cql0_937'])[3]")
    public static WebElement importGuideLinesDocument;

    //-----FastTrack TAT for First Proof-----//

    @FindBy(xpath = "//*[text()='Fasttrack']/..//*[text()='TAT for First Proof']/../..//*[text()='Days for Latex Normalization']/../input")
    public static WebElement FProof_fastTrack_daysOfLatex;

    @FindBy(xpath = "//*[text()='Fasttrack']/..//*[text()='TAT for First Proof']/../..//*[text()='Days for Graphics']/../input")
    public static WebElement FProof_fastTrack_daysOfGraphics_;

    @FindBy(xpath = "//*[text()='Fasttrack']/..//*[text()='TAT for First Proof']/../..//*[text()='Days for Pre-Editing']/../input")
    public static WebElement FProof_fastTrack_daysOfPreEdit;

    @FindBy(xpath = "//*[text()='Fasttrack']/..//*[text()='TAT for First Proof']/../..//*[text()='Days for Copyediting']/../input")
    public static WebElement FProof_fastTrack_daysOfCopyEdit;

    @FindBy(xpath = "//*[text()='Fasttrack']/..//*[text()='TAT for First Proof']/../..//*[text()='Days for Typesetting']/../input")
    public static WebElement FProof_fastTrack_Typesetting;

    @FindBy(xpath = "//*[text()='Fasttrack']/..//*[text()='TAT for First Proof']/../..//*[text()='Days for QC']/../input")
    public static WebElement FProof_fastTrack_daysOfQC;

    //------FastTrack TAT for AU Revises------//

    @FindBy(xpath = "//*[text()='Fasttrack']/..//*[text()='TAT for AU Revises ']/../..//*[text()='Days for Pagination']/../input")
    public static WebElement AURevises_fastTrack_daysOfPagination;

    @FindBy(xpath = "//*[text()='Fasttrack']/..//*[text()='TAT for AU Revises ']/../..//*[text()='Days for QC']/../input")
    public static WebElement AURevises_fastTrack_daysOfQC;

    //------FastTrack TAT for PE Revises------//

    @FindBy(xpath = "//*[text()='Fasttrack']/..//*[text()=' TAT for PE Revises ']/../..//*[text()='Days for Pagination']/../input")
    public static WebElement PERevises_fastTrack_daysOfPagination;

    @FindBy(xpath = "//*[text()='Fasttrack']/..//*[text()=' TAT for PE Revises ']/../..//*[text()='Days for QC']/../input")
    public static WebElement PERevises_fastTrack_daysOfQC;

    //------FastTrack TAT for Online First------//

    @FindBy(xpath = "//*[text()='Fasttrack']/..//*[text()=' TAT for Online First ']/../..//*[text()='Days for Pagination']/../input")
    public static WebElement OnlineFirst_fastTrack_daysOfPagination;

    @FindBy(xpath = "//*[text()='Fasttrack']/..//*[text()=' TAT for Online First ']/../..//*[text()='Days for QC']/../input")
    public static WebElement OnlineFirst_fastTrack_daysOfQC;

    @FindBy(xpath = "//*[text()='Fasttrack']/..//*[text()=' TAT for Online First ']/../..//*[text()='Days for XML']/../input")
    public static WebElement OnlineFirst_fastTrack_daysOfXML;

    //------FastTrack TAT for Issue------//

    @FindBy(xpath = "//*[text()='Fasttrack']/..//*[text()=' TAT for Issue']/../..//*[text()='Days for Pagination']/../input")
    public static WebElement ForIssue_fastTrack_daysOfPage;

    @FindBy(xpath = "//*[text()='Fasttrack']/..//*[text()=' TAT for Issue']/../..//*[text()='Days for QC']/../input")
    public static WebElement ForIssue_fastTrack_daysOfQC;

    //------FastTrack TAT for Print/Web------//

    @FindBy(xpath = "//*[text()='Fasttrack']/..//*[text()=' TAT for Print/Web ']/../..//*[text()='Days for Pagination']/../input")
    public static WebElement Print_web_fastTrack_daysOfPagination;

    @FindBy(xpath = "//*[text()='Fasttrack']/..//*[text()=' TAT for Print/Web ']/../..//*[text()='Days for QC']/../input")
    public static WebElement Print_web_fastTrack_daysOfQC;

    @FindBy(xpath = "//*[text()='Fasttrack']/..//*[text()=' TAT for Print/Web ']/../..//*[text()='Days for XML']/../input")
    public static WebElement Print_web_fastTrack_daysOfXML;


}
