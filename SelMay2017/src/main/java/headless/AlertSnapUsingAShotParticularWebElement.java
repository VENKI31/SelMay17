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
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.aimmac23.node.ScreenshotSource;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class AlertSnapUsingAShotParticularWebElement {

	@Test
	public void takeSnap() throws HeadlessException, AWTException, IOException, InterruptedException{
		
		FirefoxDriverManager.getInstance().setup();
		//ChromeDriverManager.getInstance().setup();
		//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		//ChromeDriver driver = new ChromeDriver();
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://jqueryui.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement image = driver.findElementByLinkText("Download");
	//	image.getLocation().g
		Screenshot screen = new AShot().takeScreenshot(driver, image);
		ImageIO.write(screen.getImage(), "JPG", new File("./snaps/SingleElement.jpg"));

		driver.close();

	}















}
