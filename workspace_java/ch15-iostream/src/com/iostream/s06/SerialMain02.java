package com.iostream.s06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class SerialMain02 {
	public static void main(String[] args) {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream("UserInfo.ser");
			ois = new ObjectInputStream(fis);
			
			//역직렬화 작업
			
			//들어간 순서대로 역직렬화를 수행해줘야함.
//			UserInfo u1 = (UserInfo)ois.readObject();
//			UserInfo u2 = (UserInfo)ois.readObject();
			ArrayList<UserInfo> list = (ArrayList<UserInfo>)ois.readObject();
			
//			System.out.println(u1);
//			System.out.println(u2);
			System.out.println(list);
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(ois!=null) try {ois.close();} catch(IOException e) {}
			if(fis!=null) try {fis.close();} catch(IOException e) {}
			
		}
	}
}
