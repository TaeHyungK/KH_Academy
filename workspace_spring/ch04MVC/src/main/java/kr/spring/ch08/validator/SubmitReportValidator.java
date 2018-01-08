package kr.spring.ch08.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import kr.spring.ch08.model.SubmitReportCommand;

public class SubmitReportValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return SubmitReportCommand.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "subject", "required");
		
		SubmitReportCommand command = (SubmitReportCommand) target;
		if(command.getReportFile() == null || command.getReportFile().isEmpty()) {
			errors.rejectValue("reportFile", "required");
		}
		
	}
	
}
