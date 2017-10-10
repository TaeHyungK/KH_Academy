package com.iostream.s01;

import java.io.File;

public class FileMain04 {
	public static void main(String[] args) {
		//File.separator: os의 디렉토리 구분자(\)를 반환
		String path = "D:"+ File.separator + "javaWork"+File.separator+"sample.txt";
		
		String path2 = "D:"+ File.separator + "javaWork"+File.separator+"example.txt";
		 
		
		File f= new File(path);
		
		System.out.println("파일명: " + f.getName());
		
		System.out.println("===파일명 변경===");
		File f2 = new File(path2);
		
		//파일명을 변경할 수 있으면 파일명을 변경하고
		//true를 반환
		System.out.println(f.renameTo(f2));
		
		
	}
}
