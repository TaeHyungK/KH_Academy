package kr.spring.ch04.service;

import kr.spring.ch04.Model.NewArticleCommand;
import kr.spring.ch04.controller.NewArticleController;

public class ArticleService {
	public void writeArticle(NewArticleCommand command) {
		System.out.println("신규 게시글 등록 : " + command);
	}
}
