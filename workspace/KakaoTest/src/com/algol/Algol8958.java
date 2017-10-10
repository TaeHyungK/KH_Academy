package com.algol;
import java.util.ArrayList;
import java.util.Scanner;

public class Algol8958 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ArrayList<String> list = new ArrayList<String>();

		int sum = 0;
		int cnt = 1;


		int testCase = Integer.parseInt(sc.nextLine());

		for(int i=0;i<testCase;i++) {
			list.add(sc.nextLine());
		}

		String[] temp;
		for(int i=0;i<list.size();i++) {
			for(int j=0;j<list.get(i).length();j++) {
				temp = list.get(i).split("");
				if(temp[j].equals("O")) {
					sum += cnt;
					cnt++;

				}else {
					cnt = 1;
				}
			}
			System.out.println(sum);
			sum = 0;
			cnt = 1;
		}


	}
}
