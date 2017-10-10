package com.network.s01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLMain02 {
	public static void main(String[] args) {
		BufferedReader br = null;
		String address = "https://www.naver.com";
		String line = "";

		try {
			//URL객체를 생성해서 인터넷 주소 지정
			URL url = new URL(address);
			//URL에 지정된 인터넷 주소에 접속해서 해당 HTML을 읽어들여
			//InputStream으로 반환하고 문자입력스트림으로 가공
			br = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));

			//반복문을 사용해서 한 라인의 데이터를 읽어들여 출력
			while((line=br.readLine())!=null) {
				System.out.println(line);
			}

		}catch (MalformedURLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			if(br!=null) try {br.close();} catch(IOException e) {}
		}


	}
}
