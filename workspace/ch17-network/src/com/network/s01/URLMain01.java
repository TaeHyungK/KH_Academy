package com.network.s01;

import java.net.MalformedURLException;
import java.net.URL;

public class URLMain01 {
	public static void main(String[] args) {
		try {
			URL url = new URL("http://java.sun.com/index.jsp?name=kim#content");
			
			System.out.println("��������: " + url.getProtocol());
			System.out.println("ȣ��Ʈ: " + url.getHost());
			//getPort() �޼ҵ�� URL�� ��õ� ��Ʈ�� ��ȸ�ؼ� ��ȯ
			//��õǾ� ���� ������ -1 ��ȯ
			System.out.println("��Ʈ: " + url.getPort());
			System.out.println("�⺻ ��Ʈ: " + url.getDefaultPort());
			System.out.println("Path: " + url.getPath());
			System.out.println("Query: " + url.getQuery());
			System.out.println("Reference: " + url.getRef());
			
		}catch(MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
