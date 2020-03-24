package automation_project_test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckPageLoaded extends BaseClass{
	
	public static WebDriver wait;
	
	public static void main(String args[])
	{
		launch_Browser();
		verifyPageLoad();
		close_browser();
	}
	
	public static  void verifyPageLoad()
	{
		((JavascriptExecutor) driver)
	     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='extranet_link']")));
		System.out.println("VerifyPageLoad test case: page is loaded completeley");
	}

}
