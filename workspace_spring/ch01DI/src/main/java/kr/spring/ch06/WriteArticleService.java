package kr.spring.ch06;

public class WriteArticleService {
	private WriteArticleDao writeArticleDao;

	//의존관계 설정 방식 : 프로퍼티
	public void setWriteArticleDao(WriteArticleDao writeArticleDao) {
		this.writeArticleDao = writeArticleDao;
	}
	
	public void write() {
		System.out.println("WriteArticleService의 write 메소드 실행");
		writeArticleDao.insert();
	}
	
}
