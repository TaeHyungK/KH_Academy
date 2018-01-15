package kr.spring.member.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import kr.spring.member.domain.MemberCommand;

public class MemberValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return MemberCommand.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"id","error.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"passwd","error.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name","error.required");
		
	}

}




