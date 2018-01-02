package kr.spring.ch08;

public class ParserFactory {
	private static ParserFactory instance = new ParserFactory();

	public static ParserFactory getInstance() {
		return instance;
	}
	
	private ParserFactory() {}

	@Override
	public String toString() {
		return super.toString() + "ParserFactory 호출";
	}
	
	
	
}
