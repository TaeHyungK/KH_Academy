package com.util.s01;

import java.util.StringTokenizer;

public class StringTokenizerMain {
	public static void main(String[] args) {
		String source = "100,200,300,400";
		
		//�����ڴ� �����ϰ� �����͸� ����
		StringTokenizer st = new StringTokenizer(source,",");
		
		//hasMoreToken(): �����ڷ� �߸� ���ڿ��� �ִ��� true false ��ȯ
		while(st.hasMoreTokens()) {
			//nextToken(): �����ڷ� �߶��� ���ڿ��� �о�鿩 ��ȯ.
			System.out.println(st.nextToken());
		}
		
	}
}
