package com.algol;

import java.util.Scanner;

public class Algol2439 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		
		for(int i=0;i<count;i++) {
            for(int j=count-i-1;j>0;j--) {
                System.out.print("0");
            }
            for(int k=0;k<=i;k++) {
                System.out.print("*");
            }
            System.out.println();
        }
		
	}
}
