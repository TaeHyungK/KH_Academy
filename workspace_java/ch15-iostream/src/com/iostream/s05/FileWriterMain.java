package com.iostream.s05;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterMain {
	public static void main(String[] args) {
		FileWriter fw = null;
		
		try {
			//문자출력스트림
			//덮어쓰기
			fw = new FileWriter("fileWriter.txt");
			
			//이어쓰기
//			fw = new FileWriter("fileWriter.txt",true);
			
			String message = "안녕하세요 FileWriter 테스트";
			fw.write(message);
//			fw.flush();
			
			System.out.println("파일을 생성하고 내용을 기술!");
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			//자원정리
			if( fw!= null) try { fw.close();} catch(IOException e) {}
		}
	}
}
