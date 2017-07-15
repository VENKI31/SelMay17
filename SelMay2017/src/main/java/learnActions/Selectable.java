package learnActions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class Selectable {

	public static void main(String[] args) {
		
			
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://jqueryui.com/selectable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.switchTo().frame(driver.findElementByClassName("demo-frame"));
		WebElement first = driver.findElementByXPath("//ol[@id='selectable']/li[1]");
		WebElement fourth = driver.findElementByXPath("//ol[@id='selectable']/li[4]");
		
		Actions builder = new Actions(driver);
		builder.clickAndHold(first)
		.clickAndHold(fourth)
		.release()
		.build()
		.perform();

		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
