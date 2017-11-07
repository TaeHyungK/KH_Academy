package com.iostream.s05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderMain02 {
	public static void main(String[] args) {
		
		
		//try with resource
		//�ڹ� 7�������� ��� ����
		//���� �߻� ���ο� ��� ���� ����ߴ� ���ҽ� ��ü close�޼ҵ带 ȣ���ؼ�
		//�����ϰ� ���ҽ��� �ݾ���
		try(BufferedReader br = new BufferedReader(new FileReader("file2.txt"))) {
			String line= "";
			
			while((line=br.readLine()) != null) {
				System.out.println(line);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("---------------------");
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("file2.txt"));
			String line = "";
			
			while((line=br.readLine()) != null) {
				System.out.println(line);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(br!=null) try{br.close(); }catch(IOException e) {}
		}
	}
}
