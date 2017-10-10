package com.algol;

import java.util.Arrays;
import java.util.Scanner;

public class Algol5911 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int howPeople, totalMoney;

		int cnt =0;
		howPeople = sc.nextInt();
		totalMoney = sc.nextInt();

		int[] p = new int[howPeople];
		int[] s = new int[howPeople];
		int[] sum = new int[howPeople];
		int[] checkCoupon = new int[howPeople];

		for(int i=0; i<howPeople; i++) {
			p[i] = sc.nextInt();
			s[i] = sc.nextInt();
			sum[i] = p[i] + s[i];
		}

		checkCoupon = check(howPeople,totalMoney, p, s, sum);
		
		Arrays.sort(checkCoupon);
		System.out.print(checkCoupon[howPeople-1]);
	}


	public static int[] check(int tempPeople, int tempTotal, int[] tempP, int[] tempS,int[] tempSum) {

		int count;
		int[] best = new int[tempPeople];
		int[] p = new int[tempPeople];
		int[] s = new int[tempPeople];	
		int[] sum = new int[tempPeople];
		int money;

		for(int i=0;i<tempPeople;i++) {
			count =0;

			money = tempTotal;

			for(int aa =0; aa<tempPeople;aa++) {
				p[aa] = tempP[aa];
				s[aa] = tempS[aa];
				sum[aa] = tempSum[aa];
			}

			p[i] /= 2;
			sum[i] = p[i]+s[i];

			Arrays.sort(sum);
			for(int j=0;j<tempPeople;j++) {

				if(money<=0 || money<sum[j]) break;

				money -= sum[j];
				count++;

				best[i] = count;

			}
		}

		return best;

	}
}
