package com.iostream.s04;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamMain {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		
		try {
			//�����
			fos = new FileOutputStream("fileout.txt");
			//�̾��					���ϸ�		,�̾�⿩��
//			fos = new FileOutputStream("fileout.txt",true);
			
			String message = "Hello File! ���Ͽ� ���� ���!";
			
			//getBytes(): String ��ü���� �����ϴ� �޼ҵ�, String->byte[]
			fos.write(message.getBytes());
			
			System.out.println("������ �����ϰ� ������ ����߽��ϴ�.");
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally{//�ڿ� ����
			if(fos != null) { try {fos.close();} catch(IOException e) {e.printStackTrace();} }
		}
	}
}
