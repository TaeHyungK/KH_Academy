import java.util.Scanner;

public class OperatorEx04 {
	public static void main(String[] args) {
		/*
		 * [숙제]키보드에서 초를 입력받아서
		 * 시, 분, 초로 나타낼 수 있는 프로그램을 작성하시오.
		 * 
		 * 출력예시
		 * ------
		 * 초 입력 : 4200
		 * 1시간 10분 0초 
		 */
		
		Scanner input = new Scanner(System.in);
		
		int input_sec = 0, hour = 0, min = 0, sec = 0;
		
		System.out.println("초 입력 : ");
		input_sec = input.nextInt();
		
		hour = input_sec / 3600;
		min = (input_sec % 3600) / 60;
		sec = (input_sec % 3600) % 60;
		
		System.out.println(hour + "시" + min + "분" + sec + "초");
	}
}
