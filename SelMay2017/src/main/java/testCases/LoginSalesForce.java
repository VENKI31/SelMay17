package testCases;

import org.junit.Test;

import wrappers.WrapperMethods;

public class LoginSalesForce extends WrapperMethods{

	@Test
	public void login() throws Exception{
		invokeApp("chrome", "https://developer.salesforce.com/signup?d=70130000000td6N");
		enterById("first_name", "Gopi");
		enterById("last_name", "J");
		enterById("email", "gopi@testleaf.com");
//		clickById("eula");
	}
	
	
}
