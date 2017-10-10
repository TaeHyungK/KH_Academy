package com.iostream.s05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderMain01 {
	public static void main(String[] args) {
		BufferedReader br = null;

		try {
			/*
			 * System.in : 콘솔에서 사용할 수 있는 표준 입력을 구함
			 * InputStreamReader : 바이트 입력스트림(1byte 입력 스트림) -> 문자 입력 스트림(2buyte입력 스트림)으로 가공
			 * BufferedReader : 2바이트 입력스트림, readLine()을 이용해서 한 라인의 데이터를 String으로 반환(엔터 제외)
			 */
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("당신의 이름> ");
			String name = br.readLine();
			System.out.println(name);

			System.out.print("당신의 나이> ");
			int age = Integer.parseInt(br.readLine());
			System.out.println(age);

		}catch(NumberFormatException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			if(br!=null) { try { br.close();} catch(IOException e) { e.printStackTrace();} }
		}
	}
}
