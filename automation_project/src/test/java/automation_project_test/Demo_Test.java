package automation_project_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo_Test {

	static WebDriver driver;

	// G:\Sheetal\Selenium_Project\automation_project\Driver\chromedriver.exe

	public static void main(String[] args) {

		
		try {
			launch_Browser();
			search();
			close_browser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void launch_Browser()  {
		
		try {
			System.setProperty("webdriver.chrome.driver",
					"G:\\Sheetal\\Selenium_Project\\automation_project\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
			// driver.get("https://www.google.com");
			driver.navigate().to("https://www.google.com");
			driver.manage().window().maximize();
			
			Thread.sleep(20);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void search() {
		try {
			WebElement searchbar = driver.findElement(By.xpath("//input[@title='Search']"));
			searchbar.sendKeys("Amazon");
			//(//input[@aria-label='Google Search'])[last()]
			WebElement searchbutton = driver.findElement(By.xpath("(//input[@aria-label='Google Search'])[2]"));
			searchbutton.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	public static void close_browser()
	{
		try {
			driver.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
