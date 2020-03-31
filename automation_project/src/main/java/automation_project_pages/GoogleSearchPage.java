package automation_project_pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation_project_base.BaseClass;

public class GoogleSearchPage extends BaseClass{
	
	
	public static void search(WebDriver driver) {
		try {
			WebElement searchbar = driver.findElement(By.xpath("//input[@title='Search']"));
			searchbar.sendKeys("flipkart");
			// Thread.sleep(10);
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']//li")));

			List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li"));
					

			System.out.println("Total no of suggestions in search box:::====> " + list.size());

			for (int i = 0; i < list.size(); i++) {

				System.out.println(list.get(i).getText());

				if (list.get(i).getText().contains("flipkart")) {
					 JavascriptExecutor js = (JavascriptExecutor)driver;
					 js.executeScript("arguments[0].click();", list.get(i));

					//list.get(i).click();

					break;
					}
			}
			
			System.out.println("above");
			WebElement flipkartlink = driver.findElement(By.xpath("(//*[contains(text(),'www.flipkart.com')])[1]"));
			flipkartlink.click();
			System.out.println("below");
			Thread.sleep(10);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		}

	}


}
