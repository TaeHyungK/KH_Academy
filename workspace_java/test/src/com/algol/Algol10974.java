package com.algol;

import java.util.Scanner;

public class Algol10974 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int how = sc.nextInt();
		int[] soon = new int[how];
		
		for(int i=0;i<how;i++) {
			soon[i] = i+1;
		}
		
		do {
			for(int i=0;i<how;i++) {
				System.out.print(soon[i] + " ");
			}
			System.out.println();
		}while(next(soon));
		
	}
	
	public static boolean next(int[] temp) {
		int i = temp.length-1;
		
		while(i>0 && temp[i-1] >= temp[i]) {
			i -= 1;
		}
		
		if(i<=0) {
			return false;
		}
		
		int j= temp.length-1;
		
		while(temp[j] <= temp[i-1]) {
			j-=1;
		}
		
		int changed = temp[i-1];
		temp[i-1] = temp[j];
		temp[j] = changed;
		
		j = temp.length-1;
		while(i < j) {
			changed = temp[i];
			temp[i] = temp[j];
			temp[j] = changed;
			i+= 1;
			j-= 1;
		}
		
		return true;
	}
	

}
