
public class VariableMain01 {
	public static void main(String[] args) {
		//변수(Variable) : 값을 저장할 수 있는 메모리 공간
		
		//선언
		int num;
		//초기화
		num = 17;
		//출력
		System.out.println(num);
		
		int number = 20;
		
		System.out.println(number);
		
		//데이터 변경
		number = 3;
		System.out.println(number);
		
//		주의사항
//		동일한 변수 선언 오류
//		int number; 
		
		int a = 10, b= 20;
		int result;
		
		result = a + b; //연산
		
		System.out.printf("result = %d\n", result);
		
		//문자열 + 숫자 -> 문자열과 숫자를 연결해서 문자열을 만듦
		//문자열 + 문자열  
		//숫자 + 문자열 
		System.out.println("result = " + result);
		
		System.out.println("결과 = " + a + b); //연결
		System.out.println("결과 = " + (a + b)); //연산
		
		//변수 선언
		int no;
//		변수 선언 후 출력또는 연산하기 전에 반드시 초기화를 해야함
//		System.out.println(no);
		
				
		
		
	}
}
