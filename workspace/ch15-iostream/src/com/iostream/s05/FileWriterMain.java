package com.iostream.s05;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterMain {
	public static void main(String[] args) {
		FileWriter fw = null;
		
		try {
			//������½�Ʈ��
			//�����
			fw = new FileWriter("fileWriter.txt");
			
			//�̾��
//			fw = new FileWriter("fileWriter.txt",true);
			
			String message = "�ȳ��ϼ��� FileWriter �׽�Ʈ";
			fw.write(message);
//			fw.flush();
			
			System.out.println("������ �����ϰ� ������ ���!");
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			//�ڿ�����
			if( fw!= null) try { fw.close();} catch(IOException e) {}
		}
	}
}
