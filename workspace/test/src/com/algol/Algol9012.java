package com.algol;

import java.util.Scanner;
import java.util.Stack;

public class Algol9012 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		Stack stack = new Stack();
		
		int left = 0;
		int right = 0;
		
		String input = "";
		String[] temp;
		while(t-- > 0) {
			input = sc.nextLine();
			temp = input.split("");
			
			for(int i=0;i<temp.length;i++) {
				if(temp[0].equals(")")) System.out.println("NO");
				else {
					stack.push(temp[i]);
				}
			}
			
			
			
		}
	}
}
