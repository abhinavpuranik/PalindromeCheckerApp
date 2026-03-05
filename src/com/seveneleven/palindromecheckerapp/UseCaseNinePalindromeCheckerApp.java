
/*
 * @author Developer
 * @version 9.0
 * 
 */

package com.seveneleven.palindromecheckerapp;

public class UseCaseNinePalindromeCheckerApp {
	
	public static void main(String[] args) {
		
		String input = "civic";
		
		boolean isPalindrome = check(input, 0, input.length()-1);
		
		System.out.println("Input: " + input);
		System.out.println("Is Palindrome? " + isPalindrome);
 
		
	}
	
	public static boolean check(String s, int start, int end) {
		if(start == end) return true;
		
		if(s.charAt(start) != s.charAt(end)) {
			return false;
		}else {
			return check(s, start+1, end-1);
		}
	}

}
