package testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import testcases.TestBaseClass;
import pages.HomePage;
import utility.Helper;

public class SuomiTest extends TestBaseClass {

	@Test(priority = 0)
	public void SuomiApp() throws InterruptedException {
		String testName = new Throwable().getStackTrace()[0].getMethodName();

		extentTest = extent.createTest(testName);

		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		
		System.out.println("Starting: "+testName);

		homePage.assertTitle();

		Helper.captureScreenshot(driver, testName, "01_Browser_Started");

		homePage.mouseoverLang();

		Helper.captureScreenshot(driver, testName, "02_MouseOver_Menu_Button");

		homePage.mouseoverLang("Suomi");

		Helper.captureScreenshot(driver, testName, "03_Select_Suomi");

		homePage.changeLang("Suomi");

		Helper.captureScreenshot(driver, testName, "04_Suomi_Homepage");

		homePage.assertSuomi();
		
		System.out.println("Ending: "+testName +"\n");

	}
}
