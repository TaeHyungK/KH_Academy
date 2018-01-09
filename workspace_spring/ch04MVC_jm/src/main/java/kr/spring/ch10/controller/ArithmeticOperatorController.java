package kr.spring.ch10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArithmeticOperatorController {
   @RequestMapping("/math/divide.do")
   public String divide(int op1, int op2, Model model) {
      
      model.addAttribute("result", op1/op2);
      
      return "math/result";
   }
}