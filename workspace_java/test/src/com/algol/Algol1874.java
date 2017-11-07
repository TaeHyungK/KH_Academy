package com.algol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Algol1874{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] arrayStack = new int[n];
		StringBuilder sb = new StringBuilder();

		int top = 0;
		int i, index = 0;
		int data;

		while(n-- > 0) {
			data = Integer.parseInt(br.readLine());

			if(data >= top) {
				for(i=top; i<data;i++) {
					arrayStack[index++] = i+1;
					sb.append("+\n");
				}
			}else {
				if(arrayStack[index-1] != data) {
					System.out.println("NO");
					return;
				}
			}
			index--;
			sb.append("-\n");
			if(data>top) top=data;
		}

		System.out.println(sb);

	}	
}
