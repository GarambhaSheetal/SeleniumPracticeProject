package automation_project_test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoTest2 {

	static WebDriver driver;

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
			searchbar.sendKeys("corona");
			// Thread.sleep(10);
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']//li")));

			List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li"));
					

			System.out.println("Total no of suggestions in search box:::====> " + list.size());

			for (int i = 0; i < list.size(); i++) {

				System.out.println(list.get(i).getText());

				if (list.get(i).getText().contains("coronavirus symptoms")) {
					 JavascriptExecutor js = (JavascriptExecutor)driver;
					 js.executeScript("arguments[0].click();", list.get(i));

					//list.get(i).click();

					break;

				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
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
