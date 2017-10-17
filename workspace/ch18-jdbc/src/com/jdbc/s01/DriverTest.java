package com.jdbc.s01;

public class DriverTest {
	public static void main(String[] args) {
		//ojdbc6.jar를 path걸고
		//oracle.jdbc.OracleDriver를 메모리에 로드하는 작업
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("드라이버가 정상적으로 설치되었습니다.");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
}
