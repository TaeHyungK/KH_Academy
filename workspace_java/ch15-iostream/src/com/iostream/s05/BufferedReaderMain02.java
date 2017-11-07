package com.iostream.s05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderMain02 {
	public static void main(String[] args) {
		String line = "";
		BufferedReader br = null;
		
		try {
			//표준 입력을 구하고 바이트스트림을 문자스트림으로 가공해서 입력을 처리
			br = new BufferedReader(new InputStreamReader(System.in));
			
			do {
				System.out.print("문장을 입력하세요. 종료는 q 입력> ");
				
				//엔터를 제외한 한 라인의 데이터를 String으로 반환받음
				line = br.readLine();
				
				System.out.println("입력한 문장: " + line);
				
				
			}while(!line.equalsIgnoreCase("q"));
			
			System.out.println("프로그램 종료!");
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(br!=null) try {br.close();}catch(IOException e) { }
		}
	}
}
