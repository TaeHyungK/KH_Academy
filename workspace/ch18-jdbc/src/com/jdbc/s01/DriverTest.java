package com.jdbc.s01;

public class DriverTest {
	public static void main(String[] args) {
		//ojdbc6.jar�� path�ɰ�
		//oracle.jdbc.OracleDriver�� �޸𸮿� �ε��ϴ� �۾�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("����̹��� ���������� ��ġ�Ǿ����ϴ�.");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
}
