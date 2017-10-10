package com.iostream.s01;

import java.io.File;

public class FileMain06 {
	public static void main(String[] args) {
		
		String path = "D:"+File.separator+"javaWork"
                +File.separator+"javaSample";
		
		File f = new File(path);
		System.out.println("===디렉토리 생성===");
		System.out.println(f.mkdir());
	
		System.out.println("===디렉토리 삭제===");
		if(f.delete()) {
			System.out.println(f.getName() + " 디렉토리 삭제");
		}else {
			System.out.println("디렉토리가 존재하지 않습니다.");
		}
	}
}
