package testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import testcases.TestBaseClass;
import pages.HomePage;
import utility.Helper;

public class DeutschTest extends TestBaseClass {

	@Test(priority = 0)
	public void DeutschApp() throws InterruptedException {
		String testName = new Throwable().getStackTrace()[0].getMethodName();

		extentTest = extent.createTest(testName);

		HomePage homePage = PageFactory.initElements(driver, HomePage.class);

		homePage.assertTitle();

		Helper.captureScreenshot(driver, testName, "01_Browser_Started");

		homePage.mouseoverLang();

		Helper.captureScreenshot(driver, testName, "02_MouseOver_Menu_Button");

		homePage.mouseoverLang("Deutsch");

		Helper.captureScreenshot(driver, testName, "03_Select_Deutsch");

		homePage.changeLang("Deutsch");

		Helper.captureScreenshot(driver, testName, "04_Deutsch_Homepage");

		homePage.assertDeutsch();

	}
}
