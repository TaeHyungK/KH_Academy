package com.algol;

import java.util.ArrayList;
import java.util.Scanner;

public class Algol10974 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int how = sc.nextInt();
		int[] soon = new int[how];

		ArrayList<int[]> list = new ArrayList<int[]>();

		for(int i=0;i<how;i++) {
			soon[i] = i+1;
		}
		list.add(soon);

		System.out.println();

		for(int k=0; k<soon.length; k++) {
			for(int i=soon.length-1; i>0; i--) {
				if(soon[i] > soon[i-1]) {
					for(int j=soon.length-1; j>=i-1; j--) {
						if(soon[i-1] < soon[j]) {
							swap(soon, i-1, j);
							reverseArrayInt(soon, i, soon.length);

						}
					}
				}
			}	
			
			list.add(soon);

			for(int temp : soon) {
				System.out.print(temp + " ");
			}
			System.out.println();
		}



	}

	public static void swap(int[] soon, int index1, int index2) {
		int temp = soon[index1];
		soon[index1] = soon[index2];
		soon[index2] = temp;
	}

	public static void reverseArrayInt(int[] soon, int start, int end) {
		int left = start;
		int right = end-1;

		while(left < right) {
			int temp = soon[left];
			soon[left] = soon[right];
			soon[right] = temp;

			left++;
			right--;
		}
	}
}
