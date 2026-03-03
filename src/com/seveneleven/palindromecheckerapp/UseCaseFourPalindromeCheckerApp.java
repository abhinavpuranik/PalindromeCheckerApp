//Use Case 4: Character Array Based Validation

/*This class validates a palindrome by converting the string into a character array and comparing characters using the two pointer technique
 * 
 * @author Developer
 * @version 4.0
 * 
 */

package com.seveneleven.palindromecheckerapp;

public class UseCaseFourPalindromeCheckerApp {
	//Application entry point for UC4
	
	public static void main(String[] args) {
		
		String input = "radar";
		char[] chars = input.toCharArray();
		
		int start = 0;
		int end = chars.length - 1;
		
		boolean isPalindrome = true;
		
		while(start < end) {
			if(chars[start] != chars[end]) isPalindrome = false;
			start++;
			end--;
		}
		
		System.out.println("Input: " + input);
		System.out.println("Is Palindrome? "+ isPalindrome);
		
	}

}
