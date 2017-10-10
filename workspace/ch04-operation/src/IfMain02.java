import java.util.Scanner;

public class IfMain02 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("정수형 데이터 입력: ");
		int a = input.nextInt();
		
		//수행문이 한 줄일 경우에 중괄호 생략 가능
		if(a<0) 
			a = -a;
		
		System.out.println("절대값은 " + a);
		
	}
}
