package com.iostream.s04;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamMain {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		
		try {
			//덮어쓰기
			fos = new FileOutputStream("fileout.txt");
			//이어쓰기					파일명		,이어쓰기여부
//			fos = new FileOutputStream("fileout.txt",true);
			
			String message = "Hello File! 파일에 내용 기술!";
			
			//getBytes(): String 객체에서 제공하는 메소드, String->byte[]
			fos.write(message.getBytes());
			
			System.out.println("파일을 생성하고 내용을 기술했습니다.");
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally{//자원 정리
			if(fos != null) { try {fos.close();} catch(IOException e) {e.printStackTrace();} }
		}
	}
}
