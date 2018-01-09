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

	//Get 요청이 들어올 때 호출
	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return "article/newArticleForm";
	}
	//Post 요쳥이 들어롤 때 호출
	/*
	 *request에 전송된 데이터를 자바빈을 생성하고 자바빈 프로퍼티에 저장할 때는  @ModelAttribute(속성명)를 메서드의
	 *파라미터 앞에 명시
	 *생성된 자바빈을 지정한 속성명을 request에 저장하는 작업도 수행함
	 *
	 *@ModelAttribute(속성명)은 생략이 가능하고 생략을 해도 자바빈이 생성되고 전송된 데이터가 저장됨.
	 *request에 저장될 때는 자바빈의 이름의 앞의 첫글자를 소문자로 해서 속성명으로 지정함
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String submit(@ModelAttribute("command")NewArticleCommand command) {
		
		articleService.writeArticle(command);
		
		return "article/newArticleSubmitted";
	}
}









