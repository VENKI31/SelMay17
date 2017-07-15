package headless;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aimmac23.node.ScreenshotSource;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class AlertSnapUsingAShotParticularWebElements {

	@Test
	public void takeSnap() throws HeadlessException, AWTException, IOException, InterruptedException{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.get("http://legacy.crystalcruises.com/Calendar.aspx");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		List<WebElement> images = driver.findElementsByLinkText("Get-a-Quote");
		Screenshot screen = new AShot().takeScreenshot(driver, images);
		ImageIO.write(screen.getImage(), "JPG", new File("./snaps/webElement.jpg"));
		driver.close();
	}















}
