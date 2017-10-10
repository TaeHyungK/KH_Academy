import java.util.Scanner;

public class Test11 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] num= new int[3];
		
		
		System.out.print("첫번째 정수: ");
		num[0] = input.nextInt();
		
		System.out.print("두번째 정수: ");
		num[1] = input.nextInt();
		
		System.out.print("세번째 정수: ");
		num[2] = input.nextInt();
		
		System.out.printf("입력한 수: %d, %d, %d\n",num[0], num[1], num[2]);
		
		int min = num[0];
		
		for(int i=1;i<num.length;i++) {
			if(num[i] < min)
				min = num[i];
		}
		
		
		System.out.printf("세 개의 정수중에서 가장 작은 값 : %d", min);
		
	}
}
