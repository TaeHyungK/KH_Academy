package kr.spring.ch04.service;

import kr.spring.ch04.model.NewArticleCommand;

public class ArticleService {
	public void writeArticle(NewArticleCommand command) {
		System.out.println("�ű� �Խñ� ��� : " + command);
	}
}
