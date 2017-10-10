package com.network.s01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;


public class InetAddressMain02 {
	public static void main(String[] args) {
		BufferedReader br = null;
		String url = null;
		InetAddress[] addresses = null;
		
		try {
			System.out.print("�� ����Ʈ �ּ� �Է�> ");
			
			br = new BufferedReader(new InputStreamReader(System.in));
			url = br.readLine();
			
			//�ش� �����ΰ� ���εǾ��ִ� ��� URL�� ��ȯ
			addresses = InetAddress.getAllByName(url);
			
			for(int i=0;i<addresses.length;i++) {
				System.out.println("ȣ��Ʈ �̸�: " +addresses[i].getHostName() +", ȣ��Ʈ IP�ּ�: " +addresses[i].getHostAddress());
			}
			
		}catch(UnknownHostException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(br!=null) try {br.close();} catch(IOException e) {}
		}
	}
}
