package leaftaps.Contact;

import org.testng.annotations.Test;

import wrappers.LeafTapsWrapper;


public class MergeContact extends LeafTapsWrapper {
		
	@Test
	public void mergeContact() throws Exception{
		clickByLink("Contacts");
		clickByLink("Merge Contacts");
		clickByXpath("(//img[@alt='Lookup'])[1]");
		switchToLastWindow();
		String sText = getTextByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a");
		System.out.println(sText);
		clickByXpathNoSnap("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a");
		switchToParentWindow();
		clickByXpath("(//img[@alt='Lookup'])[2]");
		switchToLastWindow();
		clickByXpathNoSnap("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a");
		switchToParentWindow();
		clickByLinkNoSnap("Merge");
		acceptAlert();
		clickByLink("Find Contacts");
		enterByXpath("//label[contains(text(),'Contact Id:')]/following::input", sText);
		clickByXpath("//button[contains(text(),'Find Contacts')]");
		verifyTextContainsByXpath("//div[@class='x-paging-info']", "No records to display");
			
	}

}
