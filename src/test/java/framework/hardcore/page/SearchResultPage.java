package framework.hardcore.page;

import framework.hardcore.model.Search;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class SearchResultPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    @FindBy(xpath = "//a[@class='gs-title'and not(parent::*[contains(@class,'thumbnail')])]")
    private List<WebElement> searchResults;

    public SearchResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }

    @Override
    public SearchResultPage isPageLoaded() throws Error {
        ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        Assert.assertTrue(searchResults.size() > 0, "Search didn't return any results");
        logger.info("Search result page is opened");
        return this;
    }

    public CalculatorCountPage goToCalculatorPage(Search searchQuery) {
        for (WebElement results : searchResults) {
            if (results.getText().equals(searchQuery.getSearchQuery())) {
                results.click();
                break;
            }
        }
        new WebDriverWait(driver, 10).until(ExpectedConditions.urlContains("calculator"));
        new WebDriverWait(driver, 10).until(CustomCondition.waitForPageLoad());
        return new CalculatorCountPage(driver);
    }
}