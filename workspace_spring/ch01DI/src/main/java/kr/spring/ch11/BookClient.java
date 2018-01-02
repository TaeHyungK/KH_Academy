package kr.spring.ch11;

import java.util.Properties;

public class BookClient {
	private Properties prop;

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	@Override
	public String toString() {
		return "BookClient [prop=" + prop + "]";
	}
	
}
