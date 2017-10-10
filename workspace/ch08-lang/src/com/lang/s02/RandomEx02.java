package com.lang.s02;

public class RandomEx02 {
	public static void main(String[] ar){
		int[] comp = new int[6];
		int[] user = new int[6];
		int bonum = (int)((Math.random()*45)+1);
		int i,j,jumsu=0;
		int d1=0,d2=0,d3=0,d4=0,d5=0,fail=0;
		long dojun = 0;
		String res = "";

		System.out.println("----로또 추첨----");

		for(i=0;i<6;i++){ // lotto 행운번호6개 + comp[6] :보너스 생성
			comp[i] = (int)((Math.random()*45)+1);
			for(j=0;j<i;j++){ // 각번호별로 겹치지않게
				if(comp[i] ==comp[j] || comp[i] == bonum){
					i--;
					break;
				}
			}
		}

		System.out.print("로또 행운의 번호: " );
		for(i=0;i<6;i++){
			System.out.print(comp[i]+" ");
		}
		System.out.println();

		while(d1 != 1){

			for(i=0;i<6;i++){ // 내 번호 6가지뽑기
				user[i] = (int)((Math.random()*45)+1);
				for(j=0;j<i;j++){
					if(user[i] == user[j]){
						i--;
						break;
					}
				}
			}

			System.out.print(dojun+1 +"번째 "+"내 추첨 번호: ");

			for(i=0;i<6;i++){
				System.out.print(user[i]+" ");
			}

			jumsu = 0;
			for(i=0;i<6;i++){ // 몇개맞췄는지 비교 일반은 +2점 보너스는 +1점
				for(j=0;j<6;j++){
					if(comp[i] == user[j]) { 
						jumsu += 2; 
					}
				}
			}
			for(i=0;i<6;i++){
				if(bonum == user[i]){
					jumsu += 1;
				}
			}

			if(jumsu == 12){ 
				d1++;
				res = "\t1등 당첨!! 축하드립니다"; 
			}else if(jumsu == 11){ 
				d2++;
				res = "\t2등 당첨"; 
			}else if(jumsu == 10 || jumsu ==9){ 
				d3++;
				res = "\t3등 당첨"; 
			}else if(jumsu == 8 || jumsu ==7) {
				d4++;
				res = "\t4등 당첨";  
			}else if(jumsu == 6 || jumsu ==5) {
				d5++;
				res = "\t5등 당첨";  
			}else{
				fail++;
				res = "꽝입니다.";
			}
			System.out.println("\t"+res);
			dojun++;

		}

		System.out.print("행운의 당첨 번호 : ");
		for(i=0;i<6;i++){
			System.out.print(comp[i] + " ");
		}
		System.out.println("\n2등 당첨 횟수: " + d2 + " 번");
		System.out.println("3등 당첨 횟수: " + d3 + " 번");
		System.out.println("4등 당첨 횟수: " + d4 + " 번");
		System.out.println("5등 당첨 횟수: " + d5 + " 번");
		System.out.println("꽝          횟수: " + fail + " 번");
		System.out.println("총 " + (dojun+1) + "번 만에 1등에 당첨 되었습니다.");
		System.out.printf("사용하신 금액: %,d원", ((dojun+1)*1000));
	}
}