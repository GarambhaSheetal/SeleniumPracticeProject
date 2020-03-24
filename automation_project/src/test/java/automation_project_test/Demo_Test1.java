package automation_project_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo_Test1 {

	static WebDriver driver;

	// G:\Sheetal\Selenium_Project\automation_project\Driver\chromedriver.exe

	public static void main(String[] args) {

		try {
			launch_Browser();
			search();
			// close_browser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void launch_Browser() {

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
			searchbar.sendKeys("Flipkart");
			
			WebElement searchbutton = driver.findElement(By.xpath("(//input[@aria-label='Google Search'])[last()]"));
			searchbutton.click();
			
			Thread.sleep(10);
			
			WebElement flipkartlink = driver.findElement(By.xpath("(//*[contains(text(),'www.flipkart.com')])[1]"));
			flipkartlink.click();
			
			Thread.sleep(10);
			
			WebElement flipkart_searchbar = driver
					.findElement(By.xpath("(//input[contains(@title,'Search for products, brands and more')])"));
			flipkart_searchbar.sendKeys("Mobile");
			
			WebElement flipkart_searchbutton = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
			Thread.sleep(10);

			WebElement closeicon = driver.findElement(By.xpath("//button[contains(text(),'✕')]"));

			if (closeicon.isDisplayed()) {
				closeicon.click();
				flipkart_searchbutton.click();
			} else {
				flipkart_searchbutton.click();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void close_browser() {
		try {
			driver.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
