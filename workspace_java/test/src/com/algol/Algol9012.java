package com.algol;

import java.util.Scanner;
import java.util.Stack;

public class Algol9012 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		String s[] = new String[t];
		for(int i= 0; i<t; i++) {
			s[i] = sc.next();
		}
		
		for(int i=0; i<t;i++) {
			check(s[i]);
		}
	}

	private static void check(String string) {
		// TODO Auto-generated method stub
		int x=0;
		for(int i=0; i<string.length();i++) {
			if(string.toCharArray()[i]=='(') {
				x++;
			}else {
				x--;
			}
			if(x<0) {
				System.out.println("NO");
				return;
			}
		}
		if(x==0) System.out.println("YES");
		else System.out.println("NO");
	}
}
