package com.iostream.s01;

import java.io.File;

public class FileMain06 {
	public static void main(String[] args) {
		
		String path = "D:"+File.separator+"javaWork"
                +File.separator+"javaSample";
		
		File f = new File(path);
		System.out.println("===���丮 ����===");
		System.out.println(f.mkdir());
	
		System.out.println("===���丮 ����===");
		if(f.delete()) {
			System.out.println(f.getName() + " ���丮 ����");
		}else {
			System.out.println("���丮�� �������� �ʽ��ϴ�.");
		}
	}
}
