package wrappers;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class LeafTapsWrapper extends WrapperMethods {

	public LeafTapsWrapper(){

	}

	public LeafTapsWrapper(int index){

	}

	@BeforeMethod
	public void login(){
		invokeApp("chrome","http://leaftaps.com");
		enterById("username", "DemoSalesManager");
		enterById("password", "crmsfa");
		clickByClassName("decorativeSubmit");
		clickByLink("CRM/SFA");
	}

	@AfterMethod
	protected void closeApplication(){
		closeBrowser();
	}



}






