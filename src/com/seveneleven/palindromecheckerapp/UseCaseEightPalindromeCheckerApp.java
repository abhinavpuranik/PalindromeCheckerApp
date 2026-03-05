/*
 * @author Developer
 * version 8.0
 * 
 * Checks Palindrome by reversing second half using linked list
 */

package com.seveneleven.palindromecheckerapp;

public class UseCaseEightPalindromeCheckerApp {
	
	static class Node{
		char data;
		Node next;
		
		Node(char data) {
			this.data = data;
			this.next = null;
			
		}
	}
	
	public static void main(String[] args) {
		
		String input = "level";
		
		Node head = null;
		Node tail = null;
		
		for(char c : input.toCharArray()) {
			
			Node newNode = new Node(c);
			if(head == null) {
				head = newNode;
				tail = newNode;
			}else {
				tail.next = newNode;
				tail = newNode;
				
			}
		}
		
		boolean isPalindrome = true;
		Node slow = head;
		Node fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
		}
		
		//reversing the second half
		Node prev = null;
		Node curr = slow;
		
		while(curr != null) {
			Node nextTemp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextTemp;
			
		}
		//comparing both the halves
		
		Node firstHalf = head;
		Node secondHalf = prev;
		
		while(secondHalf != null) {
			if(firstHalf.data != secondHalf.data) {
				isPalindrome = false;
				break;
			}
			
			firstHalf = firstHalf.next;
			secondHalf = secondHalf.next;
			
		} 
		
		System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
		
		
		
		
	}
	
	
	
	

}
