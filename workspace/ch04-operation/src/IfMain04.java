import java.util.Scanner;

public class IfMain04 {
	public static void main(String[] args) {
		/*
		 * [실습]입력받은 정수 2개에 대해 최대값, 최소값을 구하여 출력
		 * [출력예시]
		 * 최대값 : 
		 * 최소값 : 
		 */
		
		Scanner input = new Scanner(System.in);
		
		int max,min;
		
		System.out.print("첫 번째 정수: ");
		int a = input.nextInt();
		
		System.out.print("두 번째 정수: ");
		int b = input.nextInt();
		
		if(a>b) {
			max = a;
			min = b;
		}else {
			max = b;
			min = a;
		}
		
		System.out.println("최대값 : " + max + "\n" +"최소값 : " + min);
		
	}
}
