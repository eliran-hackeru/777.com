package testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import testcases.TestBaseClass;
import pages.HomePage;
import utility.Helper;

public class EnglishTest extends TestBaseClass {

	@Test(priority = 0)
	public void EnglishApp() throws InterruptedException {
		String testName = new Throwable().getStackTrace()[0].getMethodName();

		extentTest = extent.createTest(testName);

		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		
		System.out.println("Starting: "+testName);

		homePage.assertTitle();

		Helper.captureScreenshot(driver, testName, "01_Browser_Started");

		homePage.mouseoverLang();

		Helper.captureScreenshot(driver, testName, "02_MouseOver_Menu_Button");

		homePage.mouseoverLang("English");

		Helper.captureScreenshot(driver, testName, "03_Select_English");

		homePage.changeLang("English");

		Helper.captureScreenshot(driver, testName, "Homepage");

		homePage.assertEnglish();
		
		System.out.println("Ending: "+testName +"\n");

	}
}
