package kr.spring.ch09.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import kr.spring.ch09.model.FileCommand;

public class FileValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return FileCommand.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "subject", "required");
		
		FileCommand command = (FileCommand)target;
		if(command.getFilename1() == null || command.getFilename1().isEmpty()) {
			errors.rejectValue("filename1", "required");
		}
		if(command.getFilename2() == null || command.getFilename2().isEmpty()) {
			errors.rejectValue("filename2", "required");
		}
	}

}
