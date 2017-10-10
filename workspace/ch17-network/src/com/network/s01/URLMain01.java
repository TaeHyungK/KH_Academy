package com.network.s01;

import java.net.MalformedURLException;
import java.net.URL;

public class URLMain01 {
	public static void main(String[] args) {
		try {
			URL url = new URL("http://java.sun.com/index.jsp?name=kim#content");
			
			System.out.println("프로토콜: " + url.getProtocol());
			System.out.println("호스트: " + url.getHost());
			//getPort() 메소드는 URL에 명시된 포트를 조회해서 반환
			//명시되어 있지 않으면 -1 반환
			System.out.println("포트: " + url.getPort());
			System.out.println("기본 포트: " + url.getDefaultPort());
			System.out.println("Path: " + url.getPath());
			System.out.println("Query: " + url.getQuery());
			System.out.println("Reference: " + url.getRef());
			
		}catch(MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
