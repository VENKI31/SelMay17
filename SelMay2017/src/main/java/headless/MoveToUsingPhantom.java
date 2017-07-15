package headless;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MoveToUsingPhantom {

	public static void main(String[] args) throws InterruptedException, IOException {

		//Step 1: Launch Browser
		System.setProperty("phantomjs.binary.path", "./drivers/phantomjs.exe");		
		RemoteWebDriver driver = new PhantomJSDriver();	

		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

		// Maximize the browser
		driver.manage().window().maximize();

		// Navigate to URL
		driver.get("http://www.flipkart.com/");

		WebElement element =driver.findElementByXPath("//span[contains(text(),'Electronics')]");

		Actions builder = new Actions(driver);
		builder.moveToElement(element).build().perform();
		Thread.sleep(3000);
		WebElement apple = driver.findElementByXPath("//span[contains(text(),'Apple')]");
		builder.click(apple).build().perform();

		Thread.sleep(3000);

		// take snap
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snaps/phantomapple.jpg");
		FileUtils.copyFile(src, dest);

		System.out.println(driver.getTitle());










	}

}
