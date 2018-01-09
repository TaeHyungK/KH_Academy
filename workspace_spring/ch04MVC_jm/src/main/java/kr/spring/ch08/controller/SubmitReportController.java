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
      return "report/submitReportForm";
   }
   
   @RequestMapping(method = RequestMethod.POST)
   public String submit(@ModelAttribute("report")SubmitReportCommand command,BindingResult result) throws IllegalStateException, IOException {
      //��ȿ�� üũ
      new SubmitReportValidator().validate(command,result);
      
      if(result.hasErrors()) {
         return form();
      }
      File file = new File(path + "/" + command.getReportFile().getOriginalFilename());
      
      command.getReportFile().transferTo(file);
      
      System.out.println("���� : " + command.getSubject());
      System.out.println("���ε��� ���� : " + command.getReportFile().getOriginalFilename());
      System.out.println("������ �뷮 : " + command.getReportFile().getSize());
      
      return "report/submittedReport";
   }
   
}