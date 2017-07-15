package week1Day1;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Login {
	//(invocationCount=10, timeOut = 25000)
	@Test(expectedExceptions = NoSuchElementException.class, successPercentage = 80)
	public void sample() throws InterruptedException{

		//Launch the Browser
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		//sys
		//ClassName obj = new ClassName();	
		//	FirefoxDriver driver = new FirefoxDriver();
		ChromeDriver driver = new ChromeDriver();		
		//Maximize
		driver.manage().window().maximize();
		//Load d URL
		driver.get("http://leaftaps.com/opentaps");
		//Enter the userName
		driver.findElementById("username").sendKeys("DemoSalesManager");
		//Enter the password
		driver.findElementById("password").sendKeys("crmsfa");
		//Click Login
		driver.findElementByClassName("decorativeSubmit").click();
		driver.close();

	}

}











