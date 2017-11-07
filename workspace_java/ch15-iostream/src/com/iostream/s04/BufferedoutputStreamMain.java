package com.iostream.s04;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedoutputStreamMain {
	public static void main(String[] args) {
		FileOutputStream fs = null;
		
		//���۸� ����� �� �ȿ� ������ ���
		BufferedOutputStream bos = null;
		
		try {
			fs = new FileOutputStream("bufferOut.txt");
			bos = new BufferedOutputStream(fs);
			
			String str = "BufferedOutputStream Text�Դϴ�.";
			
			//BufferedOutputStream�� write() �޼ҵ��
			//���Ͽ� �����͸� ���� ����ϴ� ���� �ƴ϶� buffer�� ������ �����ϴ� ��
						//String -> byte[]
			bos.write(str.getBytes());
			
			//���� ���ÿ��� �� ����ؾ���!
			//flush�� ������� �������� finally �������� �ڿ� ������ �������.
			//������ flush�� close�� �Ѵ� ���
			// * ���۸� ���� ���ۿ� �ִ� �����͸� ���Ͽ� ���
			//flush�� ���� ������ ��µ� ������ ���Ͽ� ������� ����
			bos.flush();
			
			System.out.println("������ �����ϰ� ���Ͽ� ������ �����");
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			//�ڿ� ����
			//������ ��ü �������� �ڿ� ����
			//flush()�޼ҵ带 �����ص� close()�� ����ϸ� ������ �÷��ð� ������
			if(fs != null) { try {fs.close();} catch(IOException e) {e.printStackTrace();} }
			if(bos != null) { try {bos.close();} catch(IOException e) {e.printStackTrace();} }
		}
	}
}
