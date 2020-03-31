package automation_project_utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadDataFromFile {

	public static String file_path = "C:\\Users\\shakti\\git\\repository\\SeleniumPracticeProject\\automation_project\\TestData\\credentials.txt";

	public static void readLoginData(String email, String password) throws IOException {

		BufferedReader in = new BufferedReader(new FileReader(file_path));
		String line;
		while ((line = in.readLine()) != null) {
			// System.out.println(line);
			String right = line.substring(line.lastIndexOf("=") + 1);
			String left = line.substring(0, line.lastIndexOf("="));

			if (left.contains("email")) {
				email = right;

			}
			
			else {
				password = right;
				//passwordEncryption();

			}

		}

		in.close();

	}

}
