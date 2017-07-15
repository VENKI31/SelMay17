package testCases;


import org.testng.annotations.Test;

import wrappers.LeafTapsWrapper;

public class Login extends LeafTapsWrapper{

	@Test(dataProvider = "fetchData")
	public void login(String un, String pwd, String firstName) throws Exception {
		//Launch the Browser
		invokeApp("chrome", "http://leaftaps.com");
		//Enter the userName
		enterById("username", un);
		//	driver.findElementById("username").sendKeys("DemoSalesManager");		
		//Enter the password
		enterById("password", pwd);
		//	driver.findElementById("password").sendKeys("crmsfa");	
		//Click Login
		clickByClassName("decorativeSubmit");
		//	driver.findElementByClassName("decorativeSubmit").click();
		// Java Wait

		//Click LogOut
		clickByClassName("decorativeSubmit");
		//	driver.findElementByClassName("decorativeSubmit").click();

		closeAllBrowsers();
	}
/*
	@DataProvider(name="fetchData", parallel = true)
	public static String[][] getData() {
		
		String[][] data = new String[2][2];
		
		data[0][0] = "DemoSalesManager";
		data[0][1] = "crmsfa";

		data[1][0] = "DemoCSR";
		data[1][1] = "crmsfa";
		

		return data;

	}*/
}











