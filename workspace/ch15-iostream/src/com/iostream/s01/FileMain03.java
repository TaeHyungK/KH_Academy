package com.iostream.s01;

import java.io.File;
import java.io.IOException;

public class FileMain03 {
	public static void main(String[] args) {
		//���� ���: ��θ� ���� �� ����ϴ� ��
		String path = "D:\\javaWork\\sample.txt";
		
		//��� ���: Ư�� ���丮���� ����ϴ� ��
//		String path = "sample.txt";
		
		File f1 = new File(path);
		System.out.println("====���� ����====");
		try {
			//���� ����
			//������ ��θ� ������� ���� ����.
			//������ �����Ǹ� true�� ��ȯ,
			//�������� ������ false�� ��ȯ
			System.out.println(f1.createNewFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("====���� ����====");
		System.out.println("���� ���: " + f1.getAbsolutePath());
		System.out.println("��� ���: " + f1.getPath());
		System.out.println("���丮��: " + f1.getParent()); // ���� ������ path���� ���丮���� ������
		System.out.println("���ϸ�: " + f1.getName());
		
	}
}
