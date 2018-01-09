package kr.spring.ch01.service;

import kr.spring.ch01.model.LoginCommand;

public class LoginService {
	public void checkAuth(LoginCommand loginCommand) throws Exception {
		if(!loginCommand.getId().equals(loginCommand.getPassword())) {
			throw new Exception("invalid id or password");
		}
		
	}

}
