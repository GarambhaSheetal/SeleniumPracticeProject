package automation_project_base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static String email;
	public static String password;
	public static String path = "G:\\Sheetal\\Selenium_Project\\automation_project\\Driver\\chromedriver.exe";
	public static String url = "https://www.google.com/";

	@BeforeMethod
	public static void launch_Browser() {

		try {
			System.setProperty("webdriver.chrome.driver", path);
			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			Thread.sleep(20);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@AfterMethod
	public static void close_browser() {
		try {
			driver.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	
	
	 
	 

}
