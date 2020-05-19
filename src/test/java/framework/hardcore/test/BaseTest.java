package framework.hardcore.test;

import framework.hardcore.driver.DriverSingleton;
import framework.hardcore.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners({TestListener.class})
public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod()
    public void browserSetup() {
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void BrowserTearDown() {
        DriverSingleton.closeDriver();
    }
}
