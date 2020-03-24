package automation_project_test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatePicker {


	public static WebDriver driver;
	public static WebDriverWait wait;

	public static void main(String[] args) {
		launch_Browser();
		selectDate();
		close_browser();

	}
	
	public static void selectDate() {
		
		WebElement datefield = driver.findElement(By.xpath("(//input[@placeholder='Departure Date'])[position()=1]"));
		datefield.click();
		
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)", "");
		WebElement date = driver.findElement(By.xpath("(//table[@class='ui-datepicker-calendar'])[position()=1]"));
		List<WebElement> col = date.findElements(By.tagName("td"));
		for (WebElement cell: col) {
			if (cell.getText().equals("28")) {
				 cell.click();
			}
		}
			
			
		
	}
	
	public static void launch_Browser() {

		try {
			System.setProperty("webdriver.chrome.driver",
					"G:\\Sheetal\\Selenium_Project\\automation_project\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
			//driver.get("https://www.google.com");
			driver.get("https://www.goindigo.in/");
			driver.manage().window().maximize();
			
			Thread.sleep(20);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

		
	public static void close_browser() {
			try {
				driver.close();
			} catch (Exception e) {

				e.printStackTrace();
			}
		}

	

}
