package testcases;

import org.testng.annotations.Test;

import com.beust.jcommander.internal.Console;

import org.openqa.selenium.support.PageFactory;
import testcases.TestBaseClass;
import pages.HomePage;
import utility.Helper;

/*
* Contains all the test cases in one flow.
* Print to extent report all the languages.
* The report is located at: /test-output/Report_ + yyyy-mm-dd +.html
*/
public class AllLangsTest extends TestBaseClass {

	@Test(priority = 0)
	public void PrintAllLanguagesApp() {
		String testName = new Throwable().getStackTrace()[0].getMethodName();

		extentTest = extent.createTest(testName);

		HomePage homePage = PageFactory.initElements(driver, HomePage.class);

		homePage.assertTitle();

		Helper.captureScreenshot(driver, testName, "01_Browser_Started");

		homePage.mouseoverLang();

		Helper.captureScreenshot(driver, testName, "02_MouseOver_Menu_Button");
		
		extentTest.createNode(homePage.printLangsSize());
		
		extentTest.createNode(homePage.printAllLangs());
		
		System.out.println(homePage.printLangsSize());
		
		System.out.println(homePage.printAllLangs());
		
		homePage.assertAllLanguages();
	}

	@Test(priority = 1)
	public void DeutschApp() {
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

	@Test(priority = 2)
	public void SuomiApp() {
		String testName = new Throwable().getStackTrace()[0].getMethodName();

		extentTest = extent.createTest(testName);

		HomePage homePage = PageFactory.initElements(driver, HomePage.class);

		homePage.assertTitle();

		Helper.captureScreenshot(driver, testName, "01_Browser_Started");

		homePage.mouseoverLang();

		Helper.captureScreenshot(driver, testName, "02_MouseOver_Menu_Button");

		homePage.mouseoverLang("Suomi");

		Helper.captureScreenshot(driver, testName, "03_Select_Suomi");

		homePage.changeLang("Suomi");

		Helper.captureScreenshot(driver, testName, "04_Suomi_Homepage");

		homePage.assertSuomi();

	}

	@Test(priority = 3)
	public void EnglishApp() {
		String testName = new Throwable().getStackTrace()[0].getMethodName();

		extentTest = extent.createTest(testName);

		HomePage homePage = PageFactory.initElements(driver, HomePage.class);

		homePage.assertTitle();

		Helper.captureScreenshot(driver, testName, "01_Browser_Started");

		homePage.mouseoverLang();

		Helper.captureScreenshot(driver, testName, "02_MouseOver_Menu_Button");

		homePage.mouseoverLang("English");

		Helper.captureScreenshot(driver, testName, "03_Select_English");

		homePage.changeLang("English");

		Helper.captureScreenshot(driver, testName, "Homepage");

		homePage.assertEnglish();

	}
}
