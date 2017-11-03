package com.algol;

import java.util.Scanner;

public class Algol1476 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int e = sc.nextInt(); //1~15 -> 16 -> 1
		int s = sc.nextInt(); //1~28 -> 29 -> 1
		int m = sc.nextInt(); //1~19 -> 20 -> 1
		
		int eTemp=1,sTemp=1, mTemp=1;
		
		for(int i=1;i<=7981;i++) {
			if(e==eTemp && s==sTemp && m==mTemp) {
				System.out.println(i);
				break;
			}
			
			eTemp++;
			sTemp++;
			mTemp++;
			
			if(eTemp==16) eTemp=1;
			if(sTemp==29) sTemp=1;
			if(mTemp==20) mTemp=1;
		}
	}
}
