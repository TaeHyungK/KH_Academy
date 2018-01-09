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

	//���� ���ε� ��� �б�
	@Value("${file_path}")
	private String path;
	
	//Ŀ�ǵ� ��ü(�ڹٺ�) �ʱ�ȭ
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
		
		//��ȿ�� üũ
		new FileValidator().validate(command, result);
		if(result.hasErrors()) {
			return form();
		}
		
		//ù��° ����
		File file1 = new File(path + "/" + command.getFilename1().getOriginalFilename());
		command.getFilename1().transferTo(file1);
		//�ι�° ����
		File file2 = new File(path + "/" + command.getFilename2().getOriginalFilename());
		command.getFilename2().transferTo(file2);
		
		return "file/submittedFile";
	}
	
}
