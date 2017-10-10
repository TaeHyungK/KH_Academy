package com.iostream.s06;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CustomerMain01 {
	public static void main(String[] args) {
		System.out.println("===��ü ����ȭ�ϱ�===");
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		//����ȭ�� ��ü ����
		Customer c = new Customer("ȫ�浿");
		
		
		try {
			//					.ser : serializable �Ǿ��ִ� Ȯ����
			fos = new FileOutputStream("object.ser");
			oos = new ObjectOutputStream(fos);
			
			//��ü ����ȭ ����
			oos.writeObject(c);
			System.out.println("��ü ����ȭ�� �Ϸ�Ǿ����ϴ�");
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			//�ڿ� ����
			if(oos!=null) try {oos.close();} catch(IOException e) {}
			if(fos!=null) try {fos.close();} catch(IOException e) {}
		}
	}
}
