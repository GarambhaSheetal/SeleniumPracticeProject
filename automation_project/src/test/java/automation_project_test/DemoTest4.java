package automation_project_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoTest4 {
	static WebDriver driver;

	public static void main(String args[]) {
		launch_Browser();
		verifyJavaPageTitle();
		close_Browser();

	}

	public static void launch_Browser() {
		System.setProperty("webdriver.chrome.driver",
				"G:\\Sheetal\\Selenium_Project\\automation_project\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		String url = "https://www.techlistic.com/";
		driver.get(url);
		driver.manage().window().maximize();
	}

	public static void verifyJavaPageTitle() {
		WebElement javalink = driver.findElement(By.xpath("(//ul[@class='tabs']/li/a[text()='Java'])[last()-2]"));
		javalink.click();
		String actual = driver.getTitle();
		String expected = "Java Tutorials Series - Java For Selenium";
		if (actual.equals(expected)) {
			System.out.println("Java page title test case is passed");
		} else {
			System.out.println("Java page title test case is failed");
		}

		driver.navigate().back();
		WebElement seleniumlink = driver
				.findElement(By.xpath("(//ul[@class='tabs']/li/a[text()='Selenium'])[last()-2]"));
		seleniumlink.click();
		String actual1 = driver.getTitle();
		String expected1 = "Selenium Tutorial - Learn Selenium from Comprehensive Series of 40 Coding Tutorials";
		if (actual1.equals(expected1)) {
			System.out.println("Selenium page title test case is passed");
		} else {
			System.out.println("Selenium page title test case is failed");
		}

	}

	public static void close_Browser() {
		driver.close();
	}

}
