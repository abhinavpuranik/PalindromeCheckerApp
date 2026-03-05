/*                                                                                                
 * @author Developer                                                                              
 * @version 13.0                                                                                  
 * Using strategy pattern by creating an interface   
 * Measuring execution time of various strategies                                             
 */                                                                                               
                                                                                                  
package com.seveneleven.palindromecheckerapp;                                                     
                                                                                                  
import java.util.ArrayDeque;                                                                      
import java.util.Deque;                                                                           
import java.util.Stack;                                                                           
                                                                                                  
public class UseCaseThirteenPalindromeCheckerApp {                                                 
	public static void main(String[] args) {                                                      
		String input = "civic";                                                                   
		                                                                                          
		//runtime dependency injection                                                            
		PalindromeStrategy stackStrategy = new StackStrategy();                                   
		PalindromeStrategy dequeueStrategy = new DequeueStrategy();                               
		                                                                                          
		PalindromeService stackService = new PalindromeService(stackStrategy);                    
		PalindromeService dequeueService = new PalindromeService(dequeueStrategy);                
		                                     
		System.out.println("Input: " + input);
		stackService.checkPalindrome(input);                         
		                                                                                          
		dequeueService.checkPalindrome(input);                     
		                                                                                          
		                                                    
		        
		
		                                                                                          
	}                                                                                             
	                                                                                              
}                                                                                                 
                                                                                                  
//interface defines construct for all palindrome checking algorithm                               
                                                                                                  
interface PalindromeStrategy {                                                                    
	public void checkPalindrome(String input);                                                 
}                                                                                                 
                                                                                                  
//Dequeue Strategy                                                                                
class DequeueStrategy implements PalindromeStrategy{                                              
                                                                                                  
	@Override                                                                                     
	public void checkPalindrome(String input) {  
		long start = System.nanoTime();
		                                                                                          
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
		
		long end = System.nanoTime();
		System.out.println("Using Dequeue Strategy, Is Palindrome? " + isPalindrome);
		long duration = end - start;
		
		System.out.println("Execution Time using Dequeue strategy : " + duration + " ms");
		
		                                                                                          
		                                                                                                                                                               
	}                                                                                             
	                                                                                              
}                                                                                                 
//Stack Strategy                                                                                  
class StackStrategy implements PalindromeStrategy{                                                
                                                                                                  
	@Override                                                                                     
	public void checkPalindrome(String input) {
		long start = System.nanoTime();
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
		long end = System.nanoTime();
		
		System.out.println("Using Stack Strategy, Is Palindrome? " + isPalindrome);
		
		long duration = end - start;
		System.out.println("Execution Time using Stack strategy : " + duration + " ms");
		
		                                                                    
	}                                                                                             
	                                                                                              
}                                                                                                 
                                                                                                  
//Service class to allow runtime injection                                                        
class PalindromeService{                                                                          
	private PalindromeStrategy palindromeStrategy;                                                
	                                                                                              
	public PalindromeService(PalindromeStrategy palindromeStrategy) {                             
		this.palindromeStrategy = palindromeStrategy;                                             
	}                                                                                             
	                                                                                              
	public void checkPalindrome(String input) {                                                
		palindromeStrategy.checkPalindrome(input);                                         
	}                                                                                             
	                                                                                              
}                                                                                                 
                                                                                                  