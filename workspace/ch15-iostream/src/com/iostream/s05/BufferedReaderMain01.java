package com.iostream.s05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderMain01 {
	public static void main(String[] args) {
		BufferedReader br = null;

		try {
			/*
			 * System.in : �ֿܼ��� ����� �� �ִ� ǥ�� �Է��� ����
			 * InputStreamReader : ����Ʈ �Է½�Ʈ��(1byte �Է� ��Ʈ��) -> ���� �Է� ��Ʈ��(2buyte�Է� ��Ʈ��)���� ����
			 * BufferedReader : 2����Ʈ �Է½�Ʈ��, readLine()�� �̿��ؼ� �� ������ �����͸� String���� ��ȯ(���� ����)
			 */
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("����� �̸�> ");
			String name = br.readLine();
			System.out.println(name);

			System.out.print("����� ����> ");
			int age = Integer.parseInt(br.readLine());
			System.out.println(age);

		}catch(NumberFormatException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			if(br!=null) { try { br.close();} catch(IOException e) { e.printStackTrace();} }
		}
	}
}
