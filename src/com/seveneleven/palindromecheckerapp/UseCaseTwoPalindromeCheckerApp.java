//@author Developer
//version 2.0

package com.seveneleven.palindromecheckerapp;

public class UseCaseTwoPalindromeCheckerApp {
	//application entry for UC2
	public static void main(String[] args) {
		boolean result = true;
		String checkPalindrome = "civic";
		//Looping until half the word and checking the corresponding character from the other side
		for(int i = 0; i < checkPalindrome.length() / 2; i++) {
			char current = checkPalindrome.charAt(i);
			char opposite = checkPalindrome.charAt(checkPalindrome.length() - i - 1);
			
			if(current != opposite)
				result = false;
				break;
		}
		
		System.out.println("Input text: " + checkPalindrome);
		System.out.println("Is it a Palindrome? " + result);		
	}

}
