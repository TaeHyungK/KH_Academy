import java.util.Scanner;

public class OperatorEx04 {
	public static void main(String[] args) {
		/*
		 * [����]Ű���忡�� �ʸ� �Է¹޾Ƽ�
		 * ��, ��, �ʷ� ��Ÿ�� �� �ִ� ���α׷��� �ۼ��Ͻÿ�.
		 * 
		 * ��¿���
		 * ------
		 * �� �Է� : 4200
		 * 1�ð� 10�� 0�� 
		 */
		
		Scanner input = new Scanner(System.in);
		
		int input_sec = 0, hour = 0, min = 0, sec = 0;
		
		System.out.println("�� �Է� : ");
		input_sec = input.nextInt();
		
		hour = input_sec / 3600;
		min = (input_sec % 3600) / 60;
		sec = (input_sec % 3600) % 60;
		
		System.out.println(hour + "��" + min + "��" + sec + "��");
	}
}
