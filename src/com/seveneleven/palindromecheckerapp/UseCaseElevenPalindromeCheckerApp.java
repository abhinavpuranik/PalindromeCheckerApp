/*
 * @author Developer
 * @version 11.0
 * Creating a stack service with an exposed check palindrome method
 */

package com.seveneleven.palindromecheckerapp;

public class UseCaseElevenPalindromeCheckerApp {
	
	public static void main(String[] args) {
		String input = "civic";
		PalindromeService palindromeChecker = new PalindromeService();
		//call the method
		boolean isPalindrome = palindromeChecker.checkPalindrome(input);
		
		System.out.println("Input: " + input);
		System.out.println("Is Palindrome? " + isPalindrome);
 
	}

}

//encapsulated service class
class PalindromeService {
	public boolean checkPalindrome(String input) {
		
		
		int start = 0;
		int end = input.length() - 1;
		
		while(start < end) {
			if(input.charAt(start) != input.charAt(end)) {
				return false;
			}
			
			start++;
			end--;
		}
		
		return true;
		
	}
}







