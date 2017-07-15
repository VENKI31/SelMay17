package leaftaps.Contact;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import wrappers.LeafTapsWrapper;

public class CreateContact extends LeafTapsWrapper{
	
	@Test(dataProvider = "fetch")
	public void  createContact(String fName, String lName) throws Exception {				
		clickByLink("Contacts");
		clickByLink("Create Contact");
		enterById("firstNameField", fName);
		enterById("lastNameField", lName);
		clickByName("submitButton");		
	}		
	

	@DataProvider(name = "fetch")
	public Object[][] getData(){
		Object[][] data = new Object[3][2];
		data[0][0] = "Gopinath";
		data[0][1] = "Jayakumar";
		data[1][0] = "Raj";
		data[1][1] = "Thilak";
		data[2][0] = "Saravanan";
		data[2][1] = "Annan";
		
		return data;
		
	}
}
