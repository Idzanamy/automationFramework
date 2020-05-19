package framework.hardcore.page;

import framework.hardcore.model.Search;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainApplicationPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//*[@data-label='Tab: Pricing' and not(@role='button')]")
    private WebElement pricingMenuButton;

    @FindBy(xpath = "//*[@track-metadata-eventdetail='calculators']")
    private WebElement calculatorMenuButton;

    @FindBy(xpath = "//input[@class='devsite-search-field devsite-search-query']")
    private WebElement searchIcon;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//h1[@class='devsite-search-title']")
    private WebElement searchTitle;


    public MainApplicationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public MainApplicationPage openPage() {
        driver.get(HOMEPAGE_URL);
        logger.info("Main application page is opened");
        return this;
    }

    @Override
    protected AbstractPage isPageLoaded() throws Error {
        return null;
    }

    public SearchResultPage goToSearchPage(Search searchQuery) {
        searchIcon.click();
        searchIcon.sendKeys(searchQuery.getSearchQuery());
        waitForVisibilityOfWebElement(driver, searchButton);
        searchButton.click();
        new WebDriverWait(driver, 10).until(CustomCondition.waitForPageLoad());
        waitForVisibilityOfWebElement(driver, searchTitle);
        return new SearchResultPage(driver);
    }
}