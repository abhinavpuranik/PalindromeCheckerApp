/*
 * @author Developer
 * @version 12.0
 * Using strategy pattern by creating an interface
 */

package com.seveneleven.palindromecheckerapp;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class UseCalseTwelvePalindromeCheckerApp {
	public static void main(String[] args) {
		String input = "civic";
		
		//runtime dependency injection
		PalindromeStrategy stackStrategy = new StackStrategy();
		PalindromeStrategy dequeueStrategy = new DequeueStrategy();
		
		PalindromeService stackService = new PalindromeService(stackStrategy);
		PalindromeService dequeueService = new PalindromeService(dequeueStrategy);
		
		boolean isPalindrome_stack = stackService.checkPalindrome(input);
		
		boolean isPalindrome_dequeue = dequeueService.checkPalindrome(input);
		
		System.out.println("Input: " + input);
		System.out.println("Using Stack Strategy, Is Palindrome? " + isPalindrome_stack);
		System.out.println("Using Dequeue Strategy, Is Palindrome? " + isPalindrome_dequeue);
 
		
		
	}
	
}

//interface defines construct for all palindrome checking algorithm

interface PalindromeStrategy {
	public boolean checkPalindrome(String input);
}

//Dequeue Strategy 
class DequeueStrategy implements PalindromeStrategy{

	@Override
	public boolean checkPalindrome(String input) {
		
		Deque<Character> deque = new ArrayDeque<>();
		
		
		for(char c: input.toCharArray()) {
			deque.add(c);
		}
		boolean isPalindrome = true;
		
		while(deque.size() > 1) {
			if(deque.removeLast() != deque.removeFirst()) {
				isPalindrome = false;
				break;
				
			}
		}
		
		
		
		return isPalindrome;
	}
	
}
//Stack Strategy
class StackStrategy implements PalindromeStrategy{

	@Override
	public boolean checkPalindrome(String input) {
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
		return isPalindrome;
	}
	
}

//Service class to allow runtime injection
class PalindromeService{
	private PalindromeStrategy palindromeStrategy;
	
	public PalindromeService(PalindromeStrategy palindromeStrategy) {
		this.palindromeStrategy = palindromeStrategy;
	}
	
	public boolean checkPalindrome(String input) {
		return palindromeStrategy.checkPalindrome(input);
	}
	
}
