package ParallelRunProblemWithStaticWebDriver;

import java.lang.reflect.Method;

import ThreadLocalUsageInSelenium.SolvingWebDriverParallelRunProblem.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestOneWithStaticWebDriver{
	WebDriver driver;
	@BeforeClass
	public void setUp()
	{
		WebDriverFactoryStatic webDriverFactoryStatic = new WebDriverFactoryStatic();
		webDriverFactoryStatic.intableBrowser();
		driver = WebDriverFactoryStatic.getDriver();
			System.out.println("Browser setup by Thread "+Thread.currentThread().getId()+" and Driver reference is : ");
	}

	@Test
	public void GoogleTest(Method m) throws InterruptedException
	{
		System.out.println(m.getName()+" of class TestOneWithStaticWebDriver Executed by Thread "+Thread.currentThread().getId()+" on driver reference "+driver);
		driver.get("https://www.google.com/");
		Thread.sleep(15000);
		System.out.println("Title printed by Thread "+Thread.currentThread().getId()+" - "+driver.getTitle()+" on driver reference "+driver);
		driver.manage().deleteAllCookies();
	}
	
	@Test
	public void FacebookTest(Method m) throws InterruptedException
	{
		System.out.println(m.getName()+" of class TestOneWithStaticWebDriver Executed by Thread "+Thread.currentThread().getId()+" on driver reference "+driver);
		driver.get("https://www.facebook.com/");
		Thread.sleep(15000);
		System.out.println("Title printed by Thread "+Thread.currentThread().getId()+" - "+driver.getTitle()+" on driver reference "+driver);
		driver.manage().deleteAllCookies();
		
	}
	
	@AfterClass
	public void tearDown()
	{
		System.out.println("Browser closed by Thread "+Thread.currentThread().getId() + " and Closing driver reference is :"+driver);
		WebDriverFactoryStatic.setDriver(null);
		WebDriverFactoryStatic.getDriver().close();
	}
}
