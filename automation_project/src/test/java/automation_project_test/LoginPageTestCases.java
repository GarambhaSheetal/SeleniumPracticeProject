package automation_project_test;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageTestCases extends BaseClass {

	

	public static void main(String[] args) throws IOException {

		launch_Browser();
		GoogleSearchPage.search();
		readLoginData();
		LoginPageTestCases.verifyBlankLogin();
		LoginPageTestCases.verifyInvalidLogin();
		LoginPageTestCases.verifyValidLogin(email, password);
		close_browser();
	}



	public static void verifyBlankLogin() {
		try {

			System.out.println("<<<<<In verifyBlankLogin method>>>>>");
			Thread.sleep(15);
			WebElement email = driver.findElement(By.xpath("(//form/div/input[@type='text'])"));
			email.clear();
			email.sendKeys("");
			WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
			password.clear();
			password.sendKeys("");
			WebElement login_button = driver.findElement(By.xpath("(//button[@type='submit'])[last()]"));
			login_button.click();
			WebElement error_msg = driver
					.findElement(By.xpath("//span[text()='Please enter valid Email ID/Mobile number']"));
			String message = error_msg.getText();
			System.out.println(message);

			if (message.contains("Please enter valid Email ID/Mobile number")) {
				System.out.println("Verify blank email & password test case is>> passed");
			} else {
				System.out.println("Verify blank email & password test case is>> failed");
			}

		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public static void verifyValidLogin(String uemail, String upassword) {
		try {

			System.out.println("<<<<<In verifyValidLogin method>>>>>");
			Thread.sleep(15);
			WebElement email = driver.findElement(By.xpath("(//form/div/input[@type='text'])"));
			email.clear();
			email.sendKeys(uemail);
			WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
			System.out.println(upassword);
			password.clear();
			password.sendKeys(upassword);
			WebElement login_button = driver.findElement(By.xpath("(//button[@type='submit'])[last()]"));
			login_button.click();
			String expected_title = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
			System.out.println("expected_title: " + expected_title);
			String actual_title = driver.getTitle();
			System.out.println("actual_title: " + actual_title);
			if (actual_title.equals(expected_title)) {
				System.out.println("Verify valid email & password test case is>> passed");
			} else {
				System.out.println("Verify valid email & password test case is>> failed");
			}

		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public static void verifyInvalidLogin() {
		try {

			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//form/div/input[@type='text'])")));
			System.out.println("<<<<<In verifyInvalidLogin method>>>>>");
			Thread.sleep(15);
			WebElement email = driver.findElement(By.xpath("(//form/div/input[@type='text'])"));
			email.clear();
			email.sendKeys("@%#^^@^@@test.com");
			WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
			password.clear();
			password.sendKeys("@^^^^^^^^^^^^54546");
			WebElement login_button = driver.findElement(By.xpath("(//button[@type='submit'])[last()]"));
			login_button.click();
			WebElement error_msg = driver
					.findElement(By.xpath("//span[text()='Please enter valid Email ID/Mobile number']"));
			String message = error_msg.getText();
			System.out.println(message);

			if (message.contains("Please enter valid Email ID/Mobile number")) {
				System.out.println("Verify invalid email & password test case is>> passed");
			} else {
				System.out.println("Verify invalid email & password test case is>> failed");
			}

		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

}
