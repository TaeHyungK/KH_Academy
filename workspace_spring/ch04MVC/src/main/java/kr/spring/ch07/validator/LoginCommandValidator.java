package kr.spring.ch07.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kr.spring.ch07.model.LoginCommand;

public class LoginCommandValidator implements Validator{

	//Validator�� ������ �� �ִ� Ÿ�������� �˻�
	@Override
	public boolean supports(Class<?> clazz) {
		return LoginCommand.class.isAssignableFrom(clazz);
	}
	
	//target ��ü�� ���� ������ ����
	//���� ����� ������ ���� ��� Errors��ü�� � ������ �ִ����� ���� ������ ����
	@Override
	public void validate(Object target, Errors errors) {
		LoginCommand command = (LoginCommand)target;
		if(command.getUserId() == null || command.getUserId().trim().isEmpty()) {
								//�ʵ�(������)	//�����ڵ�(properties������ Ű��)
			errors.rejectValue("userId", "required");
		}
		if(command.getPassword() == null || command.getPassword().trim().isEmpty()) {
			errors.rejectValue("password", "required");
		}
	}

}
