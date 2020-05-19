package framework.hardcore.test;

import framework.hardcore.model.Calculator;
import framework.hardcore.model.Email;
import framework.hardcore.model.Search;
import framework.hardcore.page.CalculatorCountPage;
import framework.hardcore.page.MailPage;
import framework.hardcore.page.MainApplicationPage;
import framework.hardcore.service.CalculatorCreator;
import framework.hardcore.service.EmailCreator;
import framework.hardcore.service.SearchCreator;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestRunCalculatorCount extends BaseTest {

    @Test(description = "Product Calculation")
    public void calculatePrice(){
        Search testSearch = new SearchCreator().withQueryFromProperty();
        Email emailFull = new EmailCreator().withFullEmailFromProperty();
        Email emailShort = new EmailCreator().withShortEmailFromProperty();
        Calculator calculator = new CalculatorCreator().withQueryFromProperty();
        CalculatorCountPage newProductCalculation = new MainApplicationPage(driver)
                .openPage()
                .goToSearchPage(testSearch)
                .isPageLoaded()
                .goToCalculatorPage(testSearch)
                .isPageLoaded()
                .switchToiFrame()
                .chooseComputerEngine()
                .chooseNumberOfInstances(calculator)
                .chooseOperatingSystem()
                .chooseVMClass()
                .chooseMachineType()
                .chooseGPU()
                .chooseLocalSSD()
                .chooseDataCenterLocation()
                .chooseCommittedUsage()
                .performCalculation();

        Assert.assertTrue(newProductCalculation.getVMClass()
                .contains(calculator.getClassVM()), "Wrong VM class");
        Assert.assertTrue(newProductCalculation.getTimeUsage()
                .contains(calculator.getTimeUsage()), "Wrong time usage");
        Assert.assertTrue(newProductCalculation.getMachineType()
                .contains(calculator.getTypeIns()), "Wrong Instance type");
        Assert.assertTrue(newProductCalculation.getRegion()
                .contains(calculator.getRegion()), "Wrong region");
        Assert.assertTrue(newProductCalculation.getLocalSSD()
                .contains(calculator.getLocalSSD()), "Wrong local SSD");
        Assert.assertTrue(newProductCalculation.getTotalPrice()
                .contains(calculator.getTotalPrice()), "Wrong total price per month");

        newProductCalculation.fillInMailPage(emailFull);
        MailPage mailPage = newProductCalculation.openMailPageInNewTab(emailShort)
                .isEmailBoxOpened(emailShort)
                .openReceivedEmail();
        Assert.assertTrue(mailPage.getTotalPriceFromEmail()
                .contains(calculator.getEmailTotalPrice()), "Wrong total price per month");
    }
}