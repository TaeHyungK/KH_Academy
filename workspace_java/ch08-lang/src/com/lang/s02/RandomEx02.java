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

		System.out.println("----�ζ� ��÷----");

		for(i=0;i<6;i++){ // lotto ����ȣ6�� + comp[6] :���ʽ� ����
			comp[i] = (int)((Math.random()*45)+1);
			for(j=0;j<i;j++){ // ����ȣ���� ��ġ���ʰ�
				if(comp[i] ==comp[j] || comp[i] == bonum){
					i--;
					break;
				}
			}
		}

		System.out.print("�ζ� ����� ��ȣ: " );
		for(i=0;i<6;i++){
			System.out.print(comp[i]+" ");
		}
		System.out.println();

		while(d1 != 1){

			for(i=0;i<6;i++){ // �� ��ȣ 6�����̱�
				user[i] = (int)((Math.random()*45)+1);
				for(j=0;j<i;j++){
					if(user[i] == user[j]){
						i--;
						break;
					}
				}
			}

			System.out.print(dojun+1 +"��° "+"�� ��÷ ��ȣ: ");

			for(i=0;i<6;i++){
				System.out.print(user[i]+" ");
			}

			jumsu = 0;
			for(i=0;i<6;i++){ // �������� �� �Ϲ��� +2�� ���ʽ��� +1��
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
				res = "\t1�� ��÷!! ���ϵ帳�ϴ�"; 
			}else if(jumsu == 11){ 
				d2++;
				res = "\t2�� ��÷"; 
			}else if(jumsu == 10 || jumsu ==9){ 
				d3++;
				res = "\t3�� ��÷"; 
			}else if(jumsu == 8 || jumsu ==7) {
				d4++;
				res = "\t4�� ��÷";  
			}else if(jumsu == 6 || jumsu ==5) {
				d5++;
				res = "\t5�� ��÷";  
			}else{
				fail++;
				res = "���Դϴ�.";
			}
			System.out.println("\t"+res);
			dojun++;

		}

		System.out.print("����� ��÷ ��ȣ : ");
		for(i=0;i<6;i++){
			System.out.print(comp[i] + " ");
		}
		System.out.println("\n2�� ��÷ Ƚ��: " + d2 + " ��");
		System.out.println("3�� ��÷ Ƚ��: " + d3 + " ��");
		System.out.println("4�� ��÷ Ƚ��: " + d4 + " ��");
		System.out.println("5�� ��÷ Ƚ��: " + d5 + " ��");
		System.out.println("��          Ƚ��: " + fail + " ��");
		System.out.println("�� " + (dojun+1) + "�� ���� 1� ��÷ �Ǿ����ϴ�.");
		System.out.printf("����Ͻ� �ݾ�: %,d��", ((dojun+1)*1000));
	}
}