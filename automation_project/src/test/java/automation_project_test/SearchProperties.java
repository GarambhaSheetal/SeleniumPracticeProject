package automation_project_test;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchProperties extends BaseClass {

	
	public static void main(String args[]) throws InterruptedException {

		launch_Browser();
		searchProperties();
		searchResult();
		close_browser();
	}

	public static void searchProperties() throws InterruptedException {
		
		wait = new WebDriverWait(driver, 20);
		
		//Wait for search field to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Where are you going?']")));
		
		//Enter pune in search field
		WebElement dest = driver.findElement(By.xpath("//input[@placeholder='Where are you going?']"));
		dest.clear();
		dest.sendKeys("Pune");

		// Selecting from auto suggestion
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']//li")));
		List<WebElement> listofdest = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
		for (WebElement e : listofdest) {
			System.out.println(e.getText());
			if (e.getText().contains("Pune")) {
				e.click();
				System.out.println("Pune clicked");
				break;
			} else {
				System.out.println("Pune not found");
			}
		}

		//Scroll the page
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,550)", "");
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Check-in - Check-out']")));

		//By checkInLocator = By.xpath("//div[contains(@class, 'b-datepicker')][@data-mode='checkin']");
		//By calendarLocator = By.cssSelector(".bui-calendar__content");
		// Wait until checkIn element is displayed and then click on it
		// wait.until(ExpectedConditions.visibilityOfElementLocated(checkInLocator)).click();
		// Wait until calendar is displayed
		// wait.until(ExpectedConditions.visibilityOfElementLocated(calendarLocator));

		// Work out today and tomorrow
		LocalDate today = LocalDate.now();
		System.out.println(today);
		LocalDate tomorrow = today.plusDays(1L);
		System.out.println(tomorrow);

		// Use selectDate method to click on the relevant dates
		selectDate(driver, today);
		selectDate(driver, tomorrow);

		WebElement adult = driver.findElement(By.xpath("//span[text()='2 adults']"));
		adult.click();
		WebElement incease_adult = driver.findElement(By.xpath("(//span[text()='+'])[position()=1]"));
		incease_adult.click();

		WebElement search_button = driver.findElement(By.xpath("//div/button[@data-sb-id='main']"));
		search_button.click();

	}

	private static void selectDate(WebDriver driver, LocalDate date) {
		// Looking at the markup the attribute data-date is formatted as an
		// ISO_LOCAL_DATE
		DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
		WebDriverWait wait = new WebDriverWait(driver, 15, 100);
		// Programmatically generate dateLocator based on date passed in
		By dateLocator = By.xpath(String.format("//td[@data-date='%s']", formatter.format(date)));
		// Wait for date element to be visible, then click on it
		wait.until(ExpectedConditions.visibilityOfElementLocated(dateLocator)).click();
	}
	
	public static void searchResult()
	{
		
		
	}	
}
