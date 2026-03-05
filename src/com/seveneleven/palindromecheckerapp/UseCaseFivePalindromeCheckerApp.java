/*
 * @author Developer
 * @version 5.0
 * pushes characters in a stack and pops them in reverse order
 */
package com.seveneleven.palindromecheckerapp;
import java.util.Stack;



public class UseCaseFivePalindromeCheckerApp {
	
	public static void main(String[] args) {
		String input = "noon";
		
		Stack<Character> stack = new Stack<>();
		boolean isPalindrome = true;
		
		for(char c : input.toCharArray()) {
			
			stack.push(c);
		}
		
		for(char c: input.toCharArray()) {
			if(c != stack.pop()) {
				isPalindrome = false;
				break;
			}
		}
		
		
		System.out.println("Input: " + input);
		System.out.println("Is Palindrome? " + isPalindrome);
		
		
		
		
		
	}

	
}
