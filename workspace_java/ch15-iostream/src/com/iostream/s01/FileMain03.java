package com.iostream.s01;

import java.io.File;
import java.io.IOException;

public class FileMain03 {
	public static void main(String[] args) {
		//절대 경로: 경로를 전부 다 명시하는 것
		String path = "D:\\javaWork\\sample.txt";
		
		//상대 경로: 특정 디렉토리부터 명시하는 것
//		String path = "sample.txt";
		
		File f1 = new File(path);
		System.out.println("====파일 생성====");
		try {
			//파일 생성
			//제공된 경로를 기반으로 파일 생성.
			//파일이 생성되면 true를 반환,
			//생성되지 않으면 false를 반환
			System.out.println(f1.createNewFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("====파일 정보====");
		System.out.println("절대 경로: " + f1.getAbsolutePath());
		System.out.println("상대 경로: " + f1.getPath());
		System.out.println("디렉토리명: " + f1.getParent()); // 내가 제공한 path에서 디렉토리명을 가져옴
		System.out.println("파일명: " + f1.getName());
		
	}
}
