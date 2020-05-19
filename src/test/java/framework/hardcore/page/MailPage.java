package framework.hardcore.page;

import framework.hardcore.model.Email;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MailPage extends AbstractPage{
    private final Logger logger = LogManager.getRootLogger();
    private static String messageBody = "//div[@class='message-body']";

    @FindBy(xpath = "//*[@class='message-list-entry list-group-item'][last()]")
    private WebElement emailButtonWithCalculation;

    @FindBy(xpath = "//div[@class='message-body']")
    private WebElement totalPriceEmail;


    public MailPage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }



    @Override
    protected AbstractPage openPage() {
        return null;
    }

    @Override
    protected AbstractPage isPageLoaded() throws Error {
        return null;
    }

    public MailPage isEmailBoxOpened(Email emailShort){
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains(emailShort.getEmail()), "Email service page was not open with url:  " + url);
        logger.info("Temporary email service page is loaded in new tab");
        return this;
    }

    public MailPage openReceivedEmail() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(emailButtonWithCalculation));
        emailButtonWithCalculation.click();
        waitForElementLocated(driver, By.xpath(messageBody));
        return this;
    }

    public String getTotalPriceFromEmail() {
        return totalPriceEmail.getText();
    }



}
