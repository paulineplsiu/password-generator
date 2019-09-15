import java.security.SecureRandom;
import java.util.*;


public class Generator {
	
	private static String Lower_Char= "abcdefghijklmnopqrstuvwxyz";
	private static String Upper_Char = Lower_Char.toUpperCase();
	private static String Number = "1234567890";
	private static String Other_Char = "!$%^&*()[]@,.?+-*/";
	private static String Password_String = Lower_Char + Upper_Char + Number + Other_Char;
	
	private static SecureRandom rand = new SecureRandom();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int passwordLength = 10;
		System.out.println("PASSWORD STRING: " +  Password_String);
		System.out.println("===== SHUFFLING ==== ");
		String password = generatePassword(passwordLength);
		System.out.println("Secure Password: " + password);
		
	}
	
	
	public static String generatePassword(int length)
	{
		StringBuilder pword_string = new StringBuilder(length);
		System.out.println("Generating password of length: " + length);
		for (int i = 0; i < length; i++)
		{
			pword_string.append(Password_String.charAt(rand.nextInt(Password_String.length())));
		}
		return new String(pword_string);
	}

}
