package com.algol;

import java.util.Scanner;

public class Algol1152 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] temp;
		String se = sc.nextLine();
		temp = se.split(" ");

		int size=0;
		
		for(int i=0; i<temp.length;i++) {
			if(temp[0].equals("") || temp[0].equals(" ")) size = 0;
			if(temp[i].equals("")) {}
			else if(temp[i].equals(" ")) { System.out.println("in����: " + size);}
			else {
				size++;
			}
		}
		
		System.out.println(size);
	}
}
