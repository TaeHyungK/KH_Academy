package com.algol;

import java.util.Scanner;
import java.util.Stack;

public class Algol1874{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] arrayStack = new int[n];
		String result = "";

		int top = 0;
		int index = 0;
		int data;

		int[] datas = new int[n];

		while(n-- > 0) {
			data = sc.nextInt();

			if(data > top) 
				for(int i=top; i<top;i++) {
					arrayStack[index] = i+1;
					index++;
					result += "+\n";
				}
			else {
				if(arrayStack[index-1] != data) { 
					System.out.println("NO"); 
					return ; 
				}
			}
			index--;
			result += "-\n";
			if (data > top) top = data;
		}
		System.out.println(result);

	}	
}
