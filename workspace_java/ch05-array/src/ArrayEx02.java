import java.util.Scanner;

public class ArrayEx02 {
	public static void main(String[] args) {
		/*
		 * [�ǽ�]���� �Է¹޾Ƽ� ������ ��� ���� �迭�� �����ϰ�
		 * �װ��� ���
		 */
		Scanner input = new Scanner(System.in);
		
		int dan;
		int[] array = new int[9];
		
		System.out.print("�� �Է�: ");
		dan = input.nextInt();
		
		for(int i=0;i<array.length;i++) {
			array[i] = dan * (i+1);
			System.out.println(array[i]);
		}
	}
}
