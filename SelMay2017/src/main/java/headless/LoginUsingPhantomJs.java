package headless;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class LoginUsingPhantomJs {

	@Test
	public void htmlUnit() throws HeadlessException, AWTException, IOException {
		//Step 1: Launch Browser
		System.setProperty("phantomjs.binary.path", "./drivers/phantomjs.exe");		
		RemoteWebDriver driver = new PhantomJSDriver();	

		// Maximize
		driver.manage().window().maximize();

		//Step 3: Load URL		
		driver.get("http://leaftaps.com/opentaps");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Step 4: Enter UserName
		driver.findElementById("username").sendKeys("DemoSalesManager");

		//Step 5: Enter Password
		driver.findElementById("password").sendKeys("crmsfa");

		//Step 6: Click Login Button
		driver.findElementByClassName("decorativeSubmit").click();

		driver.findElementByLinkText("CRM/SFA").click();

		// Print the title and the URL
		System.out.println(driver.getTitle());

		// Click on Create Lead
		driver.findElementByLinkText("Create Lead").click();
		System.out.println(driver.getTitle());

		// take snap
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snaps/phantomsnap.jpg");
		FileUtils.copyFile(src, dest);
	}
}
