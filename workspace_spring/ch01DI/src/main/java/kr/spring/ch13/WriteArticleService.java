package kr.spring.ch13;

public class WriteArticleService {
	private WriteArticleDao writeArticleDao;

	//의존 관계 설정 방식 : 프로퍼티 방식
	public void setWriteArticleDao(WriteArticleDao writeArticleDao) {
		this.writeArticleDao = writeArticleDao;
	}
	
	public void write() {
		System.out.println("WriteArticleService의 write 메소드 실행");
		writeArticleDao.insert();
	}
	
}
