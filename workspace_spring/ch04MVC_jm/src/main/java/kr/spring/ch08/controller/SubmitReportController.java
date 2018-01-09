package kr.spring.ch08.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.spring.ch08.model.SubmitReportCommand;
import kr.spring.ch08.validator.SubmitReportValidator;

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
      return "report/submitReportForm";
   }
   
   @RequestMapping(method = RequestMethod.POST)
   public String submit(@ModelAttribute("report")SubmitReportCommand command,BindingResult result) throws IllegalStateException, IOException {
      //유효성 체크
      new SubmitReportValidator().validate(command,result);
      
      if(result.hasErrors()) {
         return form();
      }
      File file = new File(path + "/" + command.getReportFile().getOriginalFilename());
      
      command.getReportFile().transferTo(file);
      
      System.out.println("주제 : " + command.getSubject());
      System.out.println("업로드한 파일 : " + command.getReportFile().getOriginalFilename());
      System.out.println("파일의 용량 : " + command.getReportFile().getSize());
      
      return "report/submittedReport";
   }
   
}