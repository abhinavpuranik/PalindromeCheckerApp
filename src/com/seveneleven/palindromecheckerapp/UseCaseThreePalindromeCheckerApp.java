//Use case 3: Reverse String Based Palindrome Check
//This class checks whether a string is a palindrome by reversing the string and comparing it with the original value.

//@author Developer
//@version 3.0
package com.seveneleven.palindromecheckerapp;

public class UseCaseThreePalindromeCheckerApp {
	//Application Entry Point for UC3
	
	public static void main(String[] args) {
		
		String input = "civic";
		String checkString = "";
		for(int i = input.length() - 1; i>= 0; i--) {
			char current = input.charAt(i);
			checkString = checkString + current;
		}
		
		boolean result = false;
		if(input.equals(checkString)) result = true;
		
		System.out.println("Original: " + input);
		System.out.println("Reversed: " + checkString);
		System.out.println("Is Palindrome? : " + result);
		
		
		
	}
	
}
