package framework.hardcore.page;

import framework.hardcore.model.Calculator;
import framework.hardcore.model.Email;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;


public class CalculatorCountPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private static String emailForm = "//form[@name='emailForm']";

    @FindBy(xpath = "//iframe[parent::devsite-iframe]")
    private WebElement iFrameMain;

    @FindBy(id = "myFrame")
    private WebElement iFrameChild;

    @FindBy(xpath = "(.//div[@title='Compute Engine'])[1]")
    private WebElement btnComputerEngine;

    @FindBy(xpath = ".//input[@name='quantity' and contains(@ng-model,'computeServer.quantity')]")
    private WebElement numberOfInstances;

    @FindBy(xpath = "//md-select[contains(@aria-label,'Operating System / Software:')]//md-select-value[@id='select_value_label_51']")
    private WebElement dropDownOperatingSystem;

    @FindBy(xpath = "//md-option/*[text()[contains(.,'Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS')]]")
    private WebElement dropDownOperatingSystemValue;

    @FindBy(xpath = ".//md-select[@placeholder='VM Class']/md-select-value[@id='select_value_label_52']")
    private WebElement dropDownVMClass;

    @FindBy(xpath = "//md-option[@id='select_option_72']/*[text()[contains(.,'Regular')]]")
    private WebElement dropDownVMClassValue;

    @FindBy(xpath = ".//md-select[@placeholder='Instance type']/md-select-value[@id='select_value_label_55']")
    private WebElement dropDownMachineType;

    @FindBy(xpath = "//md-option[@id='select_option_212']/*[text()[contains(.,'n1-standard-8 (vCPUs: 8, RAM: 30GB)')]]")
    private WebElement dropDownMachineTypeValue;

    @FindBy(xpath = "(//*[@class='md-container md-ink-ripple'])[1]")
    private WebElement checkboxAddGPUs;

    @FindBy(xpath = ".//md-select[@placeholder='Number of GPUs']/md-select-value[@id='select_value_label_332']")
    private WebElement dropDownNumberOfGPU;

    @FindBy(xpath = "//md-option[@id='select_option_339']/*[text()[contains(.,'1')]]")
    private WebElement dropDownNumberOfGPUValue;

    @FindBy(xpath = ".//md-select[@placeholder='GPU type']/md-select-value[@id='select_value_label_333']")
    private WebElement dropDownGPUType;

    @FindBy(xpath = "//md-option[@id='select_option_346']/*[text()[contains(.,'NVIDIA Tesla V100')]]")
    private WebElement dropDownGPUTypeValue;

    @FindBy(xpath = ".//md-select[@placeholder='Local SSD']/md-select-value[@id='select_value_label_169']")
    private WebElement dropDownLocalSSD;

    @FindBy(xpath = "//md-option[@id='select_option_233']/*[text()[contains(.,'2x375 GB')]]")
    private WebElement dropDownLocalSSDValue;

    @FindBy(xpath = ".//md-select[@placeholder='Datacenter location']/md-select-value[@id='select_value_label_56']")
    private WebElement dropDownDataCenter;

    @FindBy(xpath = "//md-option[@id='select_option_181']/*[text()[contains(.,'Frankfurt (europe-west3)')]]")
    private WebElement dropDownDataCenterValue;

    @FindBy(xpath = ".//md-select[@placeholder='Committed usage']/md-select-value[@id='select_value_label_57']")
    private WebElement dropDownCommittedUsage;

    @FindBy(xpath = "//md-option[@id='select_option_90']/*[text()[contains(.,'1 Year')]]")
    private WebElement dropDownCommittedUsageValue;

    @FindBy(xpath = "//button[@aria-label='Add to Estimate' and contains(@ng-click,'ComputeEngineForm')]")
    private WebElement estimateButton;

    @FindBy(xpath = "//*[@id='compute']//*[text()[contains(.,'VM class:')]]")
    private WebElement vMClassResult;

    @FindBy(xpath = "//*[@id='compute']//*[text()[contains(.,'Commitment term:')]]")
    private WebElement timeUsageResult;

    @FindBy(xpath = "//*[@id='compute']//*[text()[contains(.,'Instance type:')]]")
    private WebElement machineTypeResult;

    @FindBy(xpath = "//*[@id='compute']//*[text()[contains(.,'Region:')]]")
    private WebElement regionResult;

    @FindBy(xpath = "//*[@id='compute']//*[text()[contains(.,'Total available local SSD space')]]")
    private WebElement localSSDResult;

    @FindBy(xpath = "//*[@id='resultBlock']//h2[@class='md-title']/*[text()[contains(.,'Total Estimated Cost')]]")
    private WebElement totalPriceResult;

    @FindBy(xpath = "//button[@id='email_quote']")
    private WebElement buttonEmailResults;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailAreaToEnter;

    @FindBy(xpath = "//form[@name='emailForm']")
    private WebElement companyAreaToEnter;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement buttonEmailFormSubmit;
    //button[@aria-label='Add to Estimate' and contains(@ng-click,'ComputeEngineForm')]

    @FindBy(xpath = "//form[@name='emailForm']")
    private WebElement emailFormMove;

    protected CalculatorCountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public CalculatorCountPage isPageLoaded() {
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.endsWith("/calculator"), "Not on the issue entry page: " + url);
        logger.info("Calculator page is opened");
        return this;
    }

    public CalculatorCountPage switchToiFrame() {
        driver.switchTo().frame(iFrameMain);
        driver.switchTo().frame(iFrameChild);
        return this;
    }

    public CalculatorCountPage chooseComputerEngine() {
        btnComputerEngine.click();
        waitForElementLocated(driver, By.xpath("//div[@class='compute-engine-block']"));
        return this;
    }

    public CalculatorCountPage chooseNumberOfInstances(Calculator calculator) {
        numberOfInstances.sendKeys(calculator.getNumber());
        waitForElementLocated(driver, By.
                xpath("//md-input-container[contains(@class,'md-input-has-value')][input[contains(@ng-model,'computeServer.quantity')]]"));
        return this;
    }

    public CalculatorCountPage chooseOperatingSystem() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        clickViaJs(executor, dropDownOperatingSystem);
        clickViaJs(executor, dropDownOperatingSystemValue);
        clickViaJs(executor, waitForElementLocated(driver, By.
                id("select_option_61")));
        clickViaJs(executor, dropDownOperatingSystemValue);
        waitForElementLocated(driver, By.
                xpath("//md-select[contains(@aria-label,'Operating System / Software:') and @aria-expanded='false']"));
        return this;
    }

    public CalculatorCountPage chooseVMClass() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        clickViaJs(executor, dropDownVMClass);
        clickViaJs(executor, waitForElementLocated(driver, By.
                id("select_option_73")));
        clickViaJs(executor, dropDownVMClassValue);
        waitForElementLocated(driver, By.
                xpath("//md-select[@placeholder='VM Class' and @aria-expanded='false']"));
        return this;
    }

    public CalculatorCountPage chooseMachineType() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        clickViaJs(executor, dropDownMachineType);
        clickViaJs(executor, dropDownMachineTypeValue);
        clickViaJs(executor, dropDownMachineTypeValue);
        waitForElementLocated(driver, By.
                xpath("//md-select[@placeholder='Instance type' and @aria-expanded='false']"));
        return this;
    }

    public CalculatorCountPage chooseGPU() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        if (!checkboxAddGPUs.isSelected()) {
            clickViaJs(executor, checkboxAddGPUs);
        }
        clickViaJs(executor, dropDownNumberOfGPU);
        clickViaJs(executor, dropDownNumberOfGPUValue);
        clickViaJs(executor, dropDownNumberOfGPUValue);
        clickViaJs(executor, dropDownGPUType);
        clickViaJs(executor, dropDownGPUTypeValue);
        clickViaJs(executor, dropDownGPUTypeValue);
        waitForElementLocated(driver, By.
                xpath("//md-select[@placeholder='Number of GPUs' and @aria-expanded='false']"));
        waitForElementLocated(driver, By.
                xpath("//md-select[@placeholder='GPU type' and @aria-expanded='false']"));
        return this;
    }

    public CalculatorCountPage chooseLocalSSD() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        clickViaJs(executor, dropDownLocalSSD);
        clickViaJs(executor, dropDownLocalSSDValue);
        clickViaJs(executor, dropDownLocalSSDValue);
        waitForElementLocated(driver, By.
                xpath("//md-select[@placeholder='Local SSD' and @aria-expanded='false']"));
        return this;
    }

    public CalculatorCountPage chooseDataCenterLocation() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        clickViaJs(executor, dropDownDataCenter);
        clickViaJs(executor, dropDownDataCenterValue);
        clickViaJs(executor, dropDownDataCenterValue);
        waitForElementLocated(driver, By.
                xpath("//md-select[@placeholder='Datacenter location' and @aria-expanded='false']"));
        return this;
    }

    public CalculatorCountPage chooseCommittedUsage() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        clickViaJs(executor, dropDownCommittedUsage);
        clickViaJs(executor, dropDownCommittedUsageValue);
        clickViaJs(executor, dropDownCommittedUsageValue);
        waitForElementLocated(driver, By
                .xpath("//md-select[@placeholder='Committed usage' and @aria-expanded='false']"));
        return this;
    }

    public CalculatorCountPage performCalculation() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        clickViaJs(executor, estimateButton);
        logger.info("Calculation form is filled in");
        return this;
    }

    public String getVMClass() {
        return vMClassResult.getText();
    }

    public String getTimeUsage() {
        return timeUsageResult.getText();
    }

    public String getMachineType() {
        return machineTypeResult.getText();
    }

    public String getRegion() {
        return regionResult.getText();
    }

    public String getLocalSSD() {
        return localSSDResult.getText();
    }

    public String getTotalPrice() {
        return totalPriceResult.getText();
    }

    public CalculatorCountPage fillInMailPage(Email emailFull){
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(buttonEmailResults));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        clickViaJs(executor, buttonEmailResults);
        waitForElementLocated(driver, By.xpath(emailForm));
        emailAreaToEnter.sendKeys(emailFull.getEmail());
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.attributeToBe(emailAreaToEnter,"aria-invalid","false"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", buttonEmailFormSubmit);
        clickViaJs(executor, buttonEmailFormSubmit);
        logger.info("Email form is sent to " + emailFull.getEmail());
        return this;
    }

    public MailPage openMailPageInNewTab(Email emailShort) {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get(TEMPORARY_EMAIL_SERVICE_URL + emailShort.getEmail());
        new WebDriverWait(driver, 10).until(ExpectedConditions.urlContains(TEMPORARY_EMAIL_SERVICE_URL));
        new WebDriverWait(driver, 10).until(CustomCondition.waitForPageLoad());
        logger.info("Temporary email service page is loaded in new tab for email " + emailShort.getEmail());
        return new MailPage(driver);
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }
}