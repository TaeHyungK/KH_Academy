package kr.spring.ch07.service;

import kr.spring.ch07.model.LoginCommand;

public class LoginService {
	public void checkAuth(LoginCommand loginCommand) throws Exception{
		if(!loginCommand.getUserId().equals(loginCommand.getPassword())) {
			//아이디와 비밀번호가 서로 일치하지 않으면 로그인 실패
			System.out.println("인증 에러 - " + loginCommand.getUserId());
			throw new Exception();
		}
	}
}
