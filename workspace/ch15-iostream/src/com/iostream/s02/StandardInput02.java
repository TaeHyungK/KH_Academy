package com.iostream.s02;

import java.io.IOException;

public class StandardInput02 {
	public static void main(String[] args) {
		try {
			int input = 0;
			
			//��������� -1�� ������� ctrl + z
			while((input=System.in.read())!= -1) {
				System.out.println("input : " + input + ", (char)input : " + (char)input);

			}
			
			System.out.println("���α׷� ����");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
