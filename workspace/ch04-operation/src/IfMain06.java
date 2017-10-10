
public class IfMain06 {
	public static void main(String[] args) {
		int a = 10;
		float b = 10.0f;
		
		if(a == b) { //10 -> 10.0f 자동 형변환 일어남
			System.out.println("10과 10.0f는 같다.");
		}
		
		char c = '0';
		int d = 0;
		
		if(c != d) { //'0' -> 48 자동 형변환
			System.out.println("'0'과 0은 같지 않다.");
		}
		
		char e = 'A';
		int f = 65;
		if(e == f) { //'A' -> 65 자동 형변환
			System.out.println("'A'와 65는 같다.");
		}
				
	}
}
