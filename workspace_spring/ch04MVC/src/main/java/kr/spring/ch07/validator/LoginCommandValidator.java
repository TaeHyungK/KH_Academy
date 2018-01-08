package kr.spring.ch07.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kr.spring.ch07.model.LoginCommand;

public class LoginCommandValidator implements Validator{

	//Validator가 검증할 수 있는 타입인지를 검사
	@Override
	public boolean supports(Class<?> clazz) {
		return LoginCommand.class.isAssignableFrom(clazz);
	}
	
	//target 객체에 대한 검증을 실행
	//검증 결과에 문제가 있을 경우 Errors객체에 어떤 문제가 있는지에 대한 정보를 저장
	@Override
	public void validate(Object target, Errors errors) {
		LoginCommand command = (LoginCommand)target;
		if(command.getUserId() == null || command.getUserId().trim().isEmpty()) {
								//필드(변수명)	//에러코드(properties파일의 키값)
			errors.rejectValue("userId", "required");
		}
		if(command.getPassword() == null || command.getPassword().trim().isEmpty()) {
			errors.rejectValue("password", "required");
		}
	}

}
