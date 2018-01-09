package kr.spring.ch04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.spring.ch04.model.NewArticleCommand;
import kr.spring.ch04.service.ArticleService;

@Controller
@RequestMapping("/article/newArticle.do")
public class NewArticleController {
	
	@Autowired
	private ArticleService articleService;
			
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	//Get ��û�� ���� �� ȣ��
	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return "article/newArticleForm";
	}
	//Post �䫊�� ���� �� ȣ��
	/*
	 *request�� ���۵� �����͸� �ڹٺ��� �����ϰ� �ڹٺ� ������Ƽ�� ������ ����  @ModelAttribute(�Ӽ���)�� �޼�����
	 *�Ķ���� �տ� ���
	 *������ �ڹٺ��� ������ �Ӽ����� request�� �����ϴ� �۾��� ������
	 *
	 *@ModelAttribute(�Ӽ���)�� ������ �����ϰ� ������ �ص� �ڹٺ��� �����ǰ� ���۵� �����Ͱ� �����.
	 *request�� ����� ���� �ڹٺ��� �̸��� ���� ù���ڸ� �ҹ��ڷ� �ؼ� �Ӽ������� ������
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String submit(@ModelAttribute("command")NewArticleCommand command) {
		
		articleService.writeArticle(command);
		
		return "article/newArticleSubmitted";
	}
}









