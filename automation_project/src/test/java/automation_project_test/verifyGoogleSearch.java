package automation_project_test;

import org.testng.annotations.Test;

import automation_project_pages.GoogleSearchPage;

public class verifyGoogleSearch extends BaseClass{
	
	@Test
	public void verifyFlipkartGoogleSearch()
	{
		GoogleSearchPage g = new GoogleSearchPage();
		g.search(driver);
	}

}
