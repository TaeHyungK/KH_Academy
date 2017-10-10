package com.iostream.s05;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderMain {
	public static void main(String[] args) {
		FileReader fr = null;
		int readChar;
		
		try {
			//문자 출력 스트림(2byte 출력)
			fr = new FileReader("file.txt");
			
			//파일로부터 데이터를 한 문자씩 읽어들여 유니코드로 반환
			while((readChar = fr.read())!= -1) {
				System.out.print((char)readChar);
				
			}
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			//자원정리
			if(fr!=null) try { fr.close();} catch(IOException e) {}
		}
	}
}
