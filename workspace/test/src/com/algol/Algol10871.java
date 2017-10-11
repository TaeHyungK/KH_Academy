package com.algol;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Algol10871 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int x = sc.nextInt();

		ArrayList<Integer> data = new ArrayList<Integer>();

		for(int i =0; i<n; i++) {
			data.add(sc.nextInt());
		}
		for(int i=n-1; i>=0; i--) {
			if(x<=data.get(i)) {
				data.remove(i);
			}
		}
		
		for(Integer a : data) {
			System.out.print(a+" ");
		}
		


	}
}
