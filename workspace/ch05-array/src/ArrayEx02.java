import java.util.Scanner;

public class ArrayEx02 {
	public static void main(String[] args) {
		/*
		 * [실습]단을 입력받아서 구구단 결과 값을 배열에 저장하고
		 * 그것을 출력
		 */
		Scanner input = new Scanner(System.in);
		
		int dan;
		int[] array = new int[9];
		
		System.out.print("단 입력: ");
		dan = input.nextInt();
		
		for(int i=0;i<array.length;i++) {
			array[i] = dan * (i+1);
			System.out.println(array[i]);
		}
	}
}
