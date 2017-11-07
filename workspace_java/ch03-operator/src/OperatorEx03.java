
public class OperatorEx03 {
	public static void main(String[] args) {
		/*
		 * [실습]삼항 연산자 사용
		 * int형 변수 a에 10을 대입하고 
		 * int형 변수 b에 20을 대입한 후
		 * int형 변수 max, min 을 선언하고
		 * 최대값은 max에 최소값은 min에 저장하고
		 * 최대값과 최소값을 출력하시오.
		 */
		
		int a = 10, b= 20;
		int max, min;
		
		max = (a > b) ? a : b;
		min = (a < b) ? a : b;
		
		System.out.println("max: " + max);
		System.out.println("min: " + min);
	}
}
