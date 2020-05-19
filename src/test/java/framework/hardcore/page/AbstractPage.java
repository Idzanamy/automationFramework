package framework.hardcore.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

    protected static final String HOMEPAGE_URL = "https://cloud.google.com/";
    protected final int WAIT_TIMEOUT_SECONDS = 10;
    protected final String TEMPORARY_EMAIL_SERVICE_URL = "http://mail.as-aws-dev.com/mailbox?name=";
    protected WebDriver driver;

    protected abstract AbstractPage openPage();

    protected abstract AbstractPage isPageLoaded() throws Error;


    protected AbstractPage(WebDriver driver)
    {
        this.driver = driver;

    }

    protected WebElement waitForElementLocated(WebDriver driver, By by) {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected void clickViaJs(JavascriptExecutor executor, WebElement element) {
        executor.executeScript("arguments[0].click();", element);
    }

    protected WebElement waitForVisibilityOfWebElement(WebDriver driver,WebElement element) {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
    }
}