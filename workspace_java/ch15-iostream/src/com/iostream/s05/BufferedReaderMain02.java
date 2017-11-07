package com.iostream.s05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderMain02 {
	public static void main(String[] args) {
		String line = "";
		BufferedReader br = null;
		
		try {
			//ǥ�� �Է��� ���ϰ� ����Ʈ��Ʈ���� ���ڽ�Ʈ������ �����ؼ� �Է��� ó��
			br = new BufferedReader(new InputStreamReader(System.in));
			
			do {
				System.out.print("������ �Է��ϼ���. ����� q �Է�> ");
				
				//���͸� ������ �� ������ �����͸� String���� ��ȯ����
				line = br.readLine();
				
				System.out.println("�Է��� ����: " + line);
				
				
			}while(!line.equalsIgnoreCase("q"));
			
			System.out.println("���α׷� ����!");
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(br!=null) try {br.close();}catch(IOException e) { }
		}
	}
}
