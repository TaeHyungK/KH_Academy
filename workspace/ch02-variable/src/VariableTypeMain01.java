
public class VariableTypeMain01 {
	public static void main(String[] args) {
		System.out.println("===논리형===");
		boolean b = true;
		System.out.println("b = " + b);
		
		System.out.println("===문자형===");
		//문자형 크기 : 2byte 표현 범위: 0 ~ 65,535
		//다국어 처리를 위한 유니코드(unicode) 방식
		char c1 = 'A'; // 아스키코드 'A' = 65
		char c2 = 65;
		char c3 = '\u0041'; // A를 유니코드로 표현
		char c4 = '자';
		char c5 = '\uc790'; // 자를 유니코드로 표현
		
		System.out.println("c1 = " + c1);
		System.out.println("c2 = " + c2);
		System.out.println("c3 = " + c3);
		System.out.println("c4 = " + c4);
		System.out.println("c5 = " + c5);
		
		
		
		
		
	}
}
