package wrappers;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WrapperMethods implements Wrappers{
	public RemoteWebDriver driver;
	int i=1;

	public void invokeApp(String browser, String url) {
		try {
			if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}else if(browser.equalsIgnoreCase("firefox")){
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
			driver.manage().window().maximize();	
			System.out.println("The browser "+browser+" is launched");
		} catch (WebDriverException e) {
			System.out.println("Unexpectedly browser "+browser+" closed");
		}finally {
			takeSnap();
		}
	}

	public void enterById(String idValue, String data) {

		try {
			driver.findElementById(idValue).clear();
			driver.findElementById(idValue).sendKeys(data);
			System.out.println("The text field "+idValue+" is entered with value :"+data);
			takeSnap();
		} catch (NoSuchElementException e) {
			System.err.println(idValue+" No Such element present");
			throw new RuntimeException();
		}catch(UnhandledAlertException e){
			System.err.println("Unhandled Alert Exception Error ");
		}catch (Exception e) {
			System.err.println("Below unknown error message occurs \n"+e.toString());	
			throw new RuntimeException();
		}
	}

	public void enterByName(String nameValue, String data) {
		try {
			driver.findElementByName(nameValue).clear();
			driver.findElementByName(nameValue).sendKeys(data);
			System.out.println("The text field "+nameValue+" is entered with value :"+data);
			takeSnap();
		} catch (NoSuchElementException e) {
			System.err.println(nameValue+" No Such element present");
			throw new RuntimeException();
		}catch(UnhandledAlertException e){
			System.err.println("Unhandled Alert Exception Error ");
		}catch (Exception e) {
			System.err.println("Below unknown error message occurs \n"+e.toString());	
			throw new RuntimeException();
		}

	}

	public void enterByXpath(String xpathValue, String data) {

		try {
			driver.findElementByXPath(xpathValue).sendKeys(data);;
			System.out.println("The text field "+xpathValue+" is entered with value :"+data);
			takeSnap();
		} catch (NoSuchElementException e) {
			System.err.println(xpathValue+" No Such element present");
			throw new RuntimeException();
		}catch(UnhandledAlertException e){
			System.err.println("Unhandled Alert Exception Error ");
		}catch (Exception e) {
			System.err.println("Below unknown error message occurs \n"+e.toString());	
			throw new RuntimeException();
		}

	}

	public void verifyTitle(String title) {
		String pgtitle = driver.getTitle();
		if(title.equals(pgtitle)== true)
		{
			System.out.println(title+" Text is exactly maching with "+pgtitle);
		}else{
			System.out.println(title+" Text is not exactly maching with "+pgtitle);

		}
	}

	public void verifyTextById(String id, String text) {
		try
		{
			String idtext= driver.findElementById(id).getText();
			if(idtext.equals(text)== true)
			{
				System.out.println(text+" Text is exactly maching with "+idtext);
			}else{
				System.out.println(text+" Text is not exactly maching with "+idtext);

			}
		}catch (NoSuchElementException e) {
			System.err.println(id+" No Such element present");
			throw new RuntimeException();
		}catch(UnhandledAlertException e){
			System.err.println("Unhandled Alert Exception Error ");
		}catch (Exception e) {
			System.err.println("Below unknown error message occurs \n"+e.toString());	
			throw new RuntimeException();
		}

	}

	public void verifyTextByXpath(String xpath, String text) {
		try{

			String str =driver.findElementByXPath(xpath).getText();
			if(str.equals(text) == true)
			{
				System.out.println(str+" text is euquals  "+ text);
			}else{
				System.out.println(str+" text is not equals "+ text);
			}	    	
		}catch (NoSuchElementException e) {
			System.err.println(xpath+" No Such element present");
			throw new RuntimeException();
		}catch(UnhandledAlertException e){
			System.err.println("Unhandled Alert Exception Error ");
		}catch (Exception e) {
			System.err.println("Below unknown error message occurs \n"+e.toString());	
			throw new RuntimeException();
		}
	}

	public void verifyTextContainsByXpath(String xpath, String text) {
		try{

			String str =driver.findElementByXPath(xpath).getText();
			if(str.contains(text) == true)
			{
				System.out.println(str+" text is contains  "+ text);
			}else{
				System.out.println(str+" text is not contains "+ text);
			}	    	
		}catch (NoSuchElementException e) {
			System.err.println(xpath+" No Such element present");
			throw new RuntimeException();
		}catch(UnhandledAlertException e){
			System.err.println("Unhandled Alert Exception Error ");
		}catch (Exception e) {
			System.err.println("Below unknown error message occurs \n"+e.toString());	
			throw new RuntimeException();
		}

	}

	public void clickById(String id) {
		try{
			driver.findElementById(id).click();
			System.out.println("The element "+id+" is clicked");
			takeSnap();
		}catch (NoSuchElementException e) {
			System.err.println(id+" No Such element present");
			throw new RuntimeException();
		}catch(UnhandledAlertException e){
			System.err.println("Unhandled Alert Exception Error ");
		}catch (Exception e) {
			System.err.println("Below unknown error message occurs \n"+e.toString());	
			throw new RuntimeException();
		}

	}

	public void clickByClassName(String classVal) {
		try{
			driver.findElementByClassName(classVal).click();
			System.out.println("The element "+classVal+" is clicked");
			takeSnap();
		}catch (NoSuchElementException e) {
			System.err.println(classVal +" No Such element present");
			throw new RuntimeException();
		}catch(UnhandledAlertException e){
			System.err.println("Unhandled Alert Exception Error ");
		}catch (Exception e) {
			System.err.println("Below unknown error message occurs \n"+e.toString());	
			throw new RuntimeException();
		}

	}

	public void clickByName(String name) {
		try{
			driver.findElementByName(name).click();
			System.out.println("The element "+name+" is clicked");
			takeSnap();
		}catch (NoSuchElementException e) {
			System.err.println(name +" No Such element present");
			throw new RuntimeException();
		}catch(UnhandledAlertException e){
			System.err.println("Unhandled Alert Exception Error ");
		}catch (Exception e) {
			System.err.println("Below unknown error message occurs \n"+e.toString());	
			throw new RuntimeException();
		}

	}

	public void clickByLink(String name) {

		try{
			driver.findElementByLinkText(name).click();
			System.out.println("The Link "+name+" is clicked");
			takeSnap();
		}catch (NoSuchElementException e) {
			System.err.println(name +" No Such element present");
			throw new RuntimeException();
		}catch(UnhandledAlertException e){
			System.err.println("Unhandled Alert Exception Error ");
		}catch (Exception e) {
			System.err.println("Below unknown error message occurs \n"+e.toString());	
			throw new RuntimeException();
		}

	}

	public void clickByLinkNoSnap(String name) {
		try{
			driver.findElementByLinkText(name).click();
			System.out.println("The Link "+name+" is clicked");
		}catch (NoSuchElementException e) {
			System.err.println(name +" No Such element present");
			throw new RuntimeException();
		}catch (Exception e) {
			System.err.println("Below unknown error message occurs \n"+e.toString());	
			throw new RuntimeException();
		}	}

	public void clickByXpath(String xpathVal) {
		try	{
			driver.findElementByXPath(xpathVal).click();
			System.out.println("The Link "+xpathVal+" is clicked");
			takeSnap();
		}catch (NoSuchElementException e) {
			System.err.println(xpathVal +" No Such element present");
			throw new RuntimeException();
		}catch (Exception e) {
			System.err.println("Below unknown error message occurs \n"+e.toString());	
			throw new RuntimeException();
		}	
	}

	public void clickByXpathNoSnap(String xpathVal) {
		try	{
			driver.findElementByXPath(xpathVal).click();
			System.out.println("The Link "+xpathVal+" is clicked");
		}catch (NoSuchElementException e) {
			System.err.println(xpathVal +" No Such element present");
			throw new RuntimeException();
		}catch (Exception e) {
			System.err.println("Below unknown error message occurs \n"+e.toString());	
			throw new RuntimeException();
		}	

	}

	public String getTextById(String idVal) {
		try{
			if(driver.findElementById(idVal).getAttribute("type").contains("text"))
			{
				return driver.findElementById(idVal).getAttribute("value");
			}
			else
			{
				return driver.findElementById(idVal).getText();
			}
		}catch (NoSuchElementException e) {
			System.err.println(idVal +" No Such element present");
			throw new RuntimeException();
		}catch(UnhandledAlertException e){
			System.err.println("Unhandled Alert Exception Error ");
		}catch (Exception e) {
			System.err.println("Below unknown error message occurs \n"+e.toString());	
			throw new RuntimeException();
		}
		return null;
	}

	public String getTextByXpath(String xpathVal) {

		try{
			if(driver.findElementById(xpathVal).getAttribute("type").contains("text"))
			{
				return driver.findElementById(xpathVal).getAttribute("value");
			}
			else
			{
				return driver.findElementById(xpathVal).getText();
			}
		}catch (NoSuchElementException e) {
			System.err.println(xpathVal +" No Such element present");
			throw new RuntimeException();
		}catch(UnhandledAlertException e){
			System.err.println("Unhandled Alert Exception Error ");
		}catch (Exception e) {
			System.err.println("Below unknown error message occurs \n"+e.toString());	
			throw new RuntimeException();
		}
		return null;
	}

	public void selectVisibileTextById(String id, String value) {
		try{
			Select se = new Select(driver.findElementById(id));
			se.selectByVisibleText(value);
			System.out.println("The Dropdown "+id+" is selected with value as "+value);
			takeSnap();
		}catch (NoSuchElementException e) {
			System.err.println(id +" No Such element present");
			throw new RuntimeException();
		}catch(UnhandledAlertException e){
			System.err.println("Unhandled Alert Exception Error ");
		}catch (Exception e) {
			System.err.println("Below unknown error message occurs \n"+e.toString());	
			throw new RuntimeException();
		}	
	}

	public void selectIndexById(String id, int value) {
		try{
			Select se = new Select(driver.findElementById(id));
			se.selectByIndex(value);
			System.out.println("The Dropdown "+id+" is selected with intex as "+value);
			takeSnap();
		}catch (NoSuchElementException e) {
			System.err.println(id +" No Such element present");
			throw new RuntimeException();
		}catch(UnhandledAlertException e){
			System.err.println("Unhandled Alert Exception Error ");
		}catch (Exception e) {
			System.err.println("Below unknown error message occurs \n"+e.toString());	
			throw new RuntimeException();
		}	

	}

	public void switchToParentWindow() {
		try{			
			Set<String> allwin = driver.getWindowHandles();
			for (String eachWin : allwin) {
				driver.switchTo().window(eachWin);
				break;
			}
			System.out.println("Switched to Parent Window "+driver.getTitle());
			takeSnap();
		}catch(NoSuchWindowException e){
			System.err.println("No Such Parent Window Present ");
			throw new RuntimeException();
		}catch(UnhandledAlertException e){
			System.err.println("Unhandled Alert Exception Error ");
		}catch(Exception e){
			System.err.println("Below unknown error message occurs \n"+e.toString());	
			throw new RuntimeException();
		}
	}

	public void switchToLastWindow() {
		try{
			Set<String> allwin = driver.getWindowHandles();
			for (String sw : allwin) {
				driver.switchTo().window(sw);
			}
			System.out.println("Switched to Latest Window "+driver.getTitle());
			takeSnap();
		}catch(NoSuchWindowException e){
			System.err.println("No Such Latest Window Present ");
			throw new RuntimeException();
		}catch(UnhandledAlertException e){
			System.err.println("Unhandled Alert Exception Error ");
		}catch(Exception e){
			System.err.println("Below unknown error message occurs \n"+e.toString());	
			throw new RuntimeException();
		}
	}

	public void acceptAlert() {
		try{
			driver.switchTo().alert().accept();
			System.out.println("Alert accepted");
			takeSnap();
		}catch(UnhandledAlertException e){
			System.err.println("Unhandled Alert Exception Error ");
			throw new RuntimeException();
		}catch (NoAlertPresentException e) {
			System.err.println("No Such Alert Present ");
			throw new RuntimeException();
		}catch(Exception e){
			System.err.println("Below unknown error message occurs \n"+e.toString());	
			throw new RuntimeException();
		}
	}

	public void dismissAlert() {
		try{
			driver.switchTo().alert().dismiss();
			System.out.println("Alert dismissed");
			takeSnap();
		}catch(UnhandledAlertException e){
			System.err.println("Unhandled Alert Exception Error ");
			throw new RuntimeException();
		}catch (NoAlertPresentException e) {
			System.err.println("No Such Alert Present ");
			throw new RuntimeException();
		}catch(Exception e){
			System.err.println("Below unknown error message occurs \n"+e.toString());	
			throw new RuntimeException();
		}

	}

	public String getAlertText() {
		try{
			return driver.switchTo().alert().getText();
		}catch(UnhandledAlertException e){
			System.err.println("Unhandled Alert Exception Error ");
			throw new RuntimeException();
		}catch (NoAlertPresentException e) {
			System.err.println("No Such Alert Present ");
			throw new RuntimeException();
		}catch(Exception e){
			System.err.println("Below unknown error message occurs \n"+e.toString());	
			throw new RuntimeException();
		}



	}

	public void takeSnap() {
		File srcFile = driver.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./snaps/snap"+i+".jpg");
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		i++;
	}

	public void closeBrowser() {
		try{
			driver.close();
			System.out.println("The browser is closed");
		}catch(Exception e)
		{
			System.err.println("Below unknown error message occurs \n"+e.toString());
		}
	}

	public void closeAllBrowsers() {
		try{
			driver.quit();
			System.out.println("All the browser tabs are closed");
		}catch(Exception e)
		{
			System.err.println("Below unknown error message occurs \n"+e.toString());
		}
	}

}
