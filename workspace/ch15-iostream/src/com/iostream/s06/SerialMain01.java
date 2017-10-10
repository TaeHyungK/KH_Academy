package com.iostream.s06;

import java.io.FileOutputStream;
import java.io.BufferedOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SerialMain01 {
	public static void main(String[] args) {
		String fileName = "UserInfo.ser";
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream(fileName);
			bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos);
			
			//직렬화할 객체 생성
			UserInfo u1 = new UserInfo("John", 30, "1234");
			UserInfo u2 = new UserInfo("Sunny", 26, "1234");
			
			ArrayList<UserInfo> list = new ArrayList<UserInfo>();
			
			list.add(u1);
			list.add(u2);

//			oos.writeObject(u1);
//			oos.writeObject(u2);
			oos.writeObject(list);
			
			System.out.println("직렬화 완료");
			
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			//자원정리
			if(oos!=null) try {oos.close();} catch(IOException e) {}
			if(bos!=null) try {bos.close();} catch(IOException e) {}
			if(fos!=null) try {fos.close();} catch(IOException e) {}
		}
	}
}
