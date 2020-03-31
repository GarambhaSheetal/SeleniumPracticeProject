package automation_project_utilities;

import org.apache.commons.codec.binary.Base64;

public class PasswordEncryptionDecryption {

	 public static String passwordEncryption(String password) {
		  
		  byte[] encode = Base64.encodeBase64(password.getBytes()); 
		  byte[] decode = Base64.decodeBase64(encode); return new String(decode);
		  
		  }
}
