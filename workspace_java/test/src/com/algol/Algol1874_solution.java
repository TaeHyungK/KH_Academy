package com.algol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algol1874_solution {
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int i, k, max=0,stIdx=0;
		int n = Integer.parseInt(in.readLine());
		int stack[] = new int[n];
		StringBuilder sb = new StringBuilder();
		
		while(n-->0) {
			k = Integer.parseInt(in.readLine());
			if(k > max)
				for(i=max; i<k; i++) {
					stack[stIdx++] = i+1;
					sb.append("+\n");
				}
			else
				if(stack[stIdx-1] != k) {
					System.out.println("NO");
					return;
				}
			stIdx--;
			sb.append("-\n");
			if(k>max) max=k;
		}
		
		System.out.println(sb);
		
	}
}
