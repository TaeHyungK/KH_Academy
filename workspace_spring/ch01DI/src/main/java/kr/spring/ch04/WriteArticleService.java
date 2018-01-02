package kr.spring.ch04;

public class WriteArticleService {
	private WriteArticleDao writeArticleDao;
	
	public WriteArticleService(WriteArticleDao writeArticleDao) {
		this.writeArticleDao = writeArticleDao; 
	}
	
	public void write() {
		System.out.println("WriteArticleService의 write 메소드 실행");
		writeArticleDao.insert();
	}
}
