package automation_project_test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static String email;
	public static String password;

	public static void launch_Browser() {

		try {
			System.setProperty("webdriver.chrome.driver",
					"G:\\Sheetal\\Selenium_Project\\automation_project\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
			//driver.get("https://www.google.com");
			driver.get("https://www.booking.com/");
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
	
	

	public static void readLoginData() throws IOException {

		BufferedReader in = new BufferedReader(new FileReader(
				"C:\\Users\\shakti\\git\\repository\\SeleniumPracticeProject\\automation_project\\TestData\\credentials.txt"));
		String line;
		while ((line = in.readLine()) != null) {
			// System.out.println(line);
			String right = line.substring(line.lastIndexOf("=") + 1);
			String left = line.substring(0, line.lastIndexOf("="));

			if (left.contains("email")) {
				email = right;

			} else {
				password = right;
				//passwordEncryption();

			}

		}

		in.close();

	}

	/*
	 * public static String passwordEncryption() {
	 * 
	 * byte[] encode = Base64.encodeBase64(password.getBytes()); byte[] decode =
	 * Base64.decodeBase64(encode); return new String(decode);
	 * 
	 * }
	 */

}
