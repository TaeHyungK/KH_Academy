package com.network.s01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressMain01 {
	public static void main(String[] args) {
		BufferedReader br =null;
		String url = null;
		InetAddress iaddr = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.print("웹 사이트 주소 입력> ");
			url = br.readLine();
			
			iaddr = InetAddress.getByName(url);
			System.out.println("호스트 이름: " +iaddr.getHostName());
			System.out.println("호스트 IP주소: " +iaddr.getHostAddress());
			
			System.out.println("--------------");
			
			//로컬 호스트 IP주소 구하기
			iaddr = InetAddress.getLocalHost();
			System.out.println("로컬 호스트 이름:" +iaddr.getHostName());
			System.out.println("로컬 IP주소: " +iaddr.getHostAddress());
			
		}catch(UnknownHostException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(br!=null) try { br.close();} catch(IOException e) {}
		}
		
	}
}
