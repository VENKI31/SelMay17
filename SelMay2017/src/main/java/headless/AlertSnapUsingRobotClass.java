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
import org.testng.annotations.Test;

public class AlertSnapUsingRobotClass {

	@Test
	public void takeSnap() throws HeadlessException, AWTException, IOException, InterruptedException{
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/eticketing/forgotPassword.jsf");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement ele = driver.findElementById("forgot_passwrd:checkDetails1");
		int w = ele.getSize().getWidth();
		int h = ele.getSize().getHeight();
		driver.findElementById("forgot_passwrd:checkDetails1").click();
		Thread.sleep(1000);
		// take snap
		//BufferedImage image = new Robot().createScreenCapture(new Rectangle(new Dimension(w,h)));
		BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write(image, "png", new File("./snaps/Alert.png"));
		
		//driver.getScreenshotAs(OutputType.FILE);

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
