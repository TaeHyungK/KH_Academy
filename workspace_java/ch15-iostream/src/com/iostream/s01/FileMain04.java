package com.iostream.s01;

import java.io.File;

public class FileMain04 {
	public static void main(String[] args) {
		//File.separator: os�� ���丮 ������(\)�� ��ȯ
		String path = "D:"+ File.separator + "javaWork"+File.separator+"sample.txt";
		
		String path2 = "D:"+ File.separator + "javaWork"+File.separator+"example.txt";
		 
		
		File f= new File(path);
		
		System.out.println("���ϸ�: " + f.getName());
		
		System.out.println("===���ϸ� ����===");
		File f2 = new File(path2);
		
		//���ϸ��� ������ �� ������ ���ϸ��� �����ϰ�
		//true�� ��ȯ
		System.out.println(f.renameTo(f2));
		
		
	}
}
