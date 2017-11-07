package com.iostream.s05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderMain02 {
	public static void main(String[] args) {
		
		
		//try with resource
		//자바 7버전부터 사용 가능
		//예외 발생 여부와 상관 없이 사용했던 리소스 객체 close메소드를 호출해서
		//안전하게 리소스를 닫아줌
		try(BufferedReader br = new BufferedReader(new FileReader("file2.txt"))) {
			String line= "";
			
			while((line=br.readLine()) != null) {
				System.out.println(line);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("---------------------");
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("file2.txt"));
			String line = "";
			
			while((line=br.readLine()) != null) {
				System.out.println(line);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(br!=null) try{br.close(); }catch(IOException e) {}
		}
	}
}
