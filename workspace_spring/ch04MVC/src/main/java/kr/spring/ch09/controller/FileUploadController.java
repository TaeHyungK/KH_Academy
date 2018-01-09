package kr.spring.ch09.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.spring.ch09.model.FileCommand;
import kr.spring.ch09.validator.FileValidator;

@Controller
@RequestMapping("/file/fileUpload.do")
public class FileUploadController {

	//파일 업로드 경로 읽기
	@Value("${file_path}")
	private String path;
	
	//커맨드 객체(자바빈) 초기화
	@ModelAttribute
	public FileCommand initCommand() {
		return new FileCommand();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return "file/fileUploadForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(FileCommand command,BindingResult result) throws IllegalStateException, IOException {
		
		//유효성 체크
		new FileValidator().validate(command, result);
		if(result.hasErrors()) {
			return form();
		}
		
		//첫번째 파일
		File file1 = new File(path + "/" + command.getFilename1().getOriginalFilename());
		command.getFilename1().transferTo(file1);
		//두번째 파일
		File file2 = new File(path + "/" + command.getFilename2().getOriginalFilename());
		command.getFilename2().transferTo(file2);
		
		return "file/submittedFile";
	}
	
}
