package automation_project_utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectDate {
	
	public static void selectDate(WebDriver driver, LocalDate date) {
		// Looking at the markup the attribute data-date is formatted as an
		// ISO_LOCAL_DATE
		DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
		WebDriverWait wait = new WebDriverWait(driver, 15, 100);
		// Programmatically generate dateLocator based on date passed in
		By dateLocator = By.xpath(String.format("//td[@data-date='%s']", formatter.format(date)));
		// Wait for date element to be visible, then click on it
		wait.until(ExpectedConditions.visibilityOfElementLocated(dateLocator)).click();
	}


}
