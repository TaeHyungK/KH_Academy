package kr.spring.ch08.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.spring.ch08.model.SubmitReportCommand;

@Controller
@RequestMapping("/report/submitReport.do")
public class SubmitReportController {
	//���� ���ε� ��� �б�
	@Value("${file_path}")
	private String path;
	
	//Ŀ�ǵ� ��ü(�ڹٺ�) �ʱ�ȭ
	@ModelAttribute("report")
	public SubmitReportCommand initCommand() {
		return new SubmitReportCommand();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return "report/submitReprtForm";
	}
	
}
