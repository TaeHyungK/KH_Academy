package com.iostream.s04;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedoutputStreamMain {
	public static void main(String[] args) {
		FileOutputStream fs = null;
		
		//버퍼를 만들고 그 안에 내용을 기술
		BufferedOutputStream bos = null;
		
		try {
			fs = new FileOutputStream("bufferOut.txt");
			bos = new BufferedOutputStream(fs);
			
			String str = "BufferedOutputStream Text입니다.";
			
			//BufferedOutputStream의 write() 메소드는
			//파일에 데이터를 직접 출력하는 것이 아니라 buffer에 내용을 저장하는 것
						//String -> byte[]
			bos.write(str.getBytes());
			
			//버퍼 사용시에는 꼭 사용해야함!
			//flush를 사용하지 않으려면 finally 구문에서 자원 정리를 해줘야함.
			//보통은 flush와 close를 둘다 사용
			// * 버퍼를 비우고 버퍼에 있는 데이터를 파일에 출력
			//flush를 하지 않으면 출력된 내용이 파일에 저장되지 않음
			bos.flush();
			
			System.out.println("파일을 생성하고 파일에 내용을 기술함");
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			//자원 정리
			//생성된 객체 역순으로 자원 정리
			//flush()메소드를 생략해도 close()를 명시하면 데이터 플러시가 가능함
			if(fs != null) { try {fs.close();} catch(IOException e) {e.printStackTrace();} }
			if(bos != null) { try {bos.close();} catch(IOException e) {e.printStackTrace();} }
		}
	}
}
