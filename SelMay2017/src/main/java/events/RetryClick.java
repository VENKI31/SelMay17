package events;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class RetryClick {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		EventFiringWebDriver eDriver = new EventFiringWebDriver(driver);
		 
		EventChange handler = new EventChange();
		eDriver.register(handler);
	
		// Step 2: Maximize
		eDriver.manage().window().maximize();

		// Step 3: Set the Url
		eDriver.get("http://leaftaps.com/opentaps");

		// Step 4: Set implicit wait
		eDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Step 5: Find the element of user name
		eDriver.findElement(By.id("username")).sendKeys("DemoSalesManager");

		// Step 7: Find the element of password and enter
		eDriver.findElement(By.id("password")).sendKeys("crmsfa");

		// Step 8: Find the element of login button and click
		eDriver.findElement(By.className("decorativeSubmit")).click();
	
		eDriver.findElement(By.className("decorativeSubmit")).click();
	
	}

}


