import java.util.Scanner;

public class Test11 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] num= new int[3];
		
		
		System.out.print("ù��° ����: ");
		num[0] = input.nextInt();
		
		System.out.print("�ι�° ����: ");
		num[1] = input.nextInt();
		
		System.out.print("����° ����: ");
		num[2] = input.nextInt();
		
		System.out.printf("�Է��� ��: %d, %d, %d\n",num[0], num[1], num[2]);
		
		int min = num[0];
		
		for(int i=1;i<num.length;i++) {
			if(num[i] < min)
				min = num[i];
		}
		
		
		System.out.printf("�� ���� �����߿��� ���� ���� �� : %d", min);
		
	}
}
