package kr.spring.ch07.service;

import kr.spring.ch07.model.LoginCommand;

public class LoginService {
	public void checkAuth(LoginCommand loginCommand) throws Exception{
		if(!loginCommand.getUserId().equals(loginCommand.getPassword())) {
			//���̵�� ��й�ȣ�� ���� ��ġ���� ������ �α��� ����
			System.out.println("���� ���� - " + loginCommand.getUserId());
			throw new Exception();
		}
	}
}
