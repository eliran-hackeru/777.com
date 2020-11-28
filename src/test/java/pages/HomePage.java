package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy (className = "langBUtton") WebElement langBUtton;
	
	@FindBy (css = "a[onclick*='Languages-']") List<WebElement> langList;
	
	WebElement english;
	
	WebElement deutsch;
	
	WebElement suomi;
		
	//To display languages menu
	public void mouseoverLang()
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(langBUtton).perform();
	}
	
	//To get the languages menu size
		public void printLangSize()
		{
			System.out.println(langList.size());
		}
		
	//To get the amount of languages 
	public String getLangsSize()
	{
		return "There are "+langList.size()+" languages:\n";
	}
	
	//To get all the different languages
	public String getAllLangs()
	{	
		String languages ="";
		for (int i=0; i<langList.size(); i++)
		{
			languages = languages + langList.get(i).getText() +"\n";
		}
		return languages;
	}
	
	//Set the langList elements by name
	public void setLangList()
	{
		for(int i=0; i<langList.size(); i++)
		{
			switch (langList.get(i).getText())
			{
			case "English": english = langList.get(i);
			break;
			
			case "Deutsch": deutsch = langList.get(i);
			break;
			
			case "Suomi": suomi = langList.get(i);
			break;
			}
		}
	}
	
	//To move the mouse over the languages in the menu
	public void mouseoverLang(String lang)
	{
		setLangList();
		
		Actions builder = new Actions(driver);
		
		switch (lang)
		{
		case "English": builder.moveToElement(english).build().perform();
		break;
		
		case "Deutsch": builder.moveToElement(deutsch).build().perform();
		break;
		
		case "Suomi": builder.moveToElement(suomi).build().perform();
		break;
		}
	}
		
	//To change the language
	public void changeLang(String lang)
	{
		setLangList();
		
		switch (lang)
		{
		case "English": english.click();
		break;
		
		case "Deutsch": deutsch.click();
		break;
		
		case "Suomi": suomi.click();
		break;
		}
	}
	
	//To assert the title, which will be changed according to the language 
	public void assertTitle()
	{
		Assert.assertTrue(driver.getTitle().contains("777 Casino"));
		System.out.println("Assert Title passed");
	}
	
	//Assertions based on the URl prefix and the Languages shortcut: EN, DE & FI
	public void assertEnglish()
	{
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.777"));
		Assert.assertEquals(langBUtton.getText(), "EN");
		System.out.println("Assert English passed");
	}
		
	public void assertDeutsch()
	{
		Assert.assertTrue(driver.getCurrentUrl().contains("https://de.777"));
		Assert.assertEquals(langBUtton.getText(), "DE");
		System.out.println("Assert Deutsch passed");
	}
	public void assertSuomi()
	{
		Assert.assertTrue(driver.getCurrentUrl().contains("https://fi.777"));
		Assert.assertEquals(langBUtton.getText(), "FI");
		System.out.println("Assert Suomi passed");
	}
	
	//To assert we have all the 3 Languages
	public void assertAllLanguages()
	{
		Assert.assertEquals(langList.size(), 3);
		System.out.println("Assert All Languages passed");
	}
}
