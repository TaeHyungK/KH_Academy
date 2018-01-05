package kr.spring.ch03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {
	
	@RequestMapping("/search/internal.do")
	/*
	 * @RequestParam ������̼��� HTTP ��û �Ķ���͸� �޼ҵ��� �Ķ���ͷ� ����
	 * query�� �ʼ������� �����ؾ� �ϴ� �������̱� ������ query �����޽� ���� �߻�
	 * @RequestParam�� ������ �� ����. ������ ���� �޼ҵ��� �Ķ���͸�� ��û �Ķ���͸���
	 * ��ġ�ؾ� ��. ��û �Ķ���Ͱ� ��� ������ �߻����� �ʰ� null�� ��ȯ
	 * 
	 */
	public ModelAndView searchInternal(@RequestParam("query") String query,
									   @RequestParam(value="p", defaultValue="1") int pageNumber) {
		System.out.println("query = " + query +", PageNumber = " + pageNumber);
		
		return new ModelAndView("search/internal");
	}
	@RequestMapping("/search/external.do")
	public ModelAndView SearchExternal(@RequestParam(value="query",required=false) String query) {
		
		System.out.println("query = " + query);
		
		return new ModelAndView("search/external");
	}
}
