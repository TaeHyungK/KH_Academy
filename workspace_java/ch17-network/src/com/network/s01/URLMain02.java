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
			//URL��ü�� �����ؼ� ���ͳ� �ּ� ����
			URL url = new URL(address);
			//URL�� ������ ���ͳ� �ּҿ� �����ؼ� �ش� HTML�� �о�鿩
			//InputStream���� ��ȯ�ϰ� �����Է½�Ʈ������ ����
			br = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));

			//�ݺ����� ����ؼ� �� ������ �����͸� �о�鿩 ���
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
