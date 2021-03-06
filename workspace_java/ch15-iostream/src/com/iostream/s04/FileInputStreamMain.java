package com.iostream.s04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamMain {
	public static void main(String[] args) {
		FileInputStream fis = null;
		int readbyte=0;
		
		//한글 처리를 위함
		byte[] readbyte2;
		
		try {
			fis = new FileInputStream("file.txt");
			
			//파일의 정보를 한 문자씩 읽어들여 아스키코드로 반환
			//영문 이외의 문자는 깨짐
//			while((readbyte = fis.read())!= -1) {
//				System.out.print((char)readbyte);
//			}
			
			//영문 이외의 문자도 처리 가능
			//available(): File의 글자 수 계산해주는 메소드
			readbyte2 = new byte[fis.available()];
			
			//읽어들인 데이터를 byte배열에 저장
			fis.read(readbyte2);
			
			//					byte[] -> String
			System.out.println(new String(readbyte2));
			
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			if(fis!=null) {
				try {
					fis.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
