package framework.hardcore.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class CustomCondition {
    protected static ExpectedCondition<Boolean> waitForPageLoad() {
        return (WebDriver driver) -> ((JavascriptExecutor) driver)
                .executeScript("return document.readyState").equals("complete");
    }
}