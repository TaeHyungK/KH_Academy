import java.util.Scanner;

public class SwitchMain03 {
	public static void main(String[] args) {
		//JDK7.0부터는 switch에 인자값으로 문자열 전달 가능
		Scanner input = new Scanner(System.in);
		
		int first = 0, second =0, result =0;
		String operator;
		
		System.out.print("첫 번째 수: ");
		first = input.nextInt();
		
		System.out.print("연산자: ");
		operator = input.next();
		
		System.out.print("두 번째 수: ");
		second = input.nextInt();
		
		switch(operator) {
			case "+":
				result = first+second;
				break;
			case "-":
				result = first-second;
				break;
			case "*":
				result = first*second;
				break;
			case "/": 
				if(second != 0) {
					result = first/second;
					break;
				}
				else {
					System.out.println("0으로 나눌 수 없습니다.");
					System.exit(0);
				}
			case "%":
				if(second != 0) {
					result = first%second;
					break;
				}
				else {
					System.out.println("0으로 나눌 수 없습니다.");
					System.exit(0);
				}
			default :
				System.out.println("연산자를 잘 못 선택하셨습니다.");
				//프로그램 종료
				System.exit(0);
		}
		
		System.out.println();
		System.out.println(first + " " + operator + " " + second + " = " + result);
		
	}
}
