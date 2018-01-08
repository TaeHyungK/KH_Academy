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
	//파일 업로드 경로 읽기
	@Value("${file_path}")
	private String path;
	
	//커맨드 객체(자바빈) 초기화
	@ModelAttribute("report")
	public SubmitReportCommand initCommand() {
		return new SubmitReportCommand();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return "report/submitReprtForm";
	}
	
}
